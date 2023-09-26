package upc.edu.pe.softroute.shippingregisterservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.*;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingCompanyService;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingService;
import upc.edu.pe.softroute.shippingregisterservice.dto.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/shipping_register")
@CrossOrigin(origins = "*")
@Api(value = "Web Service RESTFul of Shipping Register", tags = "ShippingRegister")
public class ShippingController {
    private final IShippingService shippingService;
    private final IShippingCompanyService shippingCompanyService;
    public ShippingController(IShippingService shippingService, IShippingCompanyService shippingCompanyService) {
        this.shippingService = shippingService;
        this.shippingCompanyService = shippingCompanyService;
    }

    @PostMapping(value = "/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Shipping Rgyster", notes = "Method to create a new Shipping Company")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Shipping Company found"),
            @ApiResponse(code = 404, message = "Shipping Company Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Shipping> insertShippingRegister(@PathVariable(value = "companyId") Long companyId, @Valid @RequestBody Shipping shipping) {
        Optional<ShippingCompany> shippingCompany = null;
        try {
            shippingCompany = shippingCompanyService.getById(companyId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!shippingCompany.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shipping.setShippingCompany(shippingCompany.get());
        try{
            Shipping shippingCompanyNew = shippingService.save(shipping);
            return ResponseEntity.status(HttpStatus.CREATED).body(shippingCompanyNew);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all Shipping Registers", notes = "Method to list all Shipping Registers")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All Shipping Registers founds"),
            @ApiResponse(code = 404, message = "Shipping Registers Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<ShippingDTO>> findAllShippingRegisters(){
        try {
            List<Shipping> shippingRegisters = shippingService.getAll();
            if (shippingRegisters.size() > 0){
                // Convertir Shipping a ShippingDTO
                List<ShippingDTO> shippingDTOList = shippingRegisters.stream()
                        .map(this::convertShippingToDTO)
                        .collect(Collectors.toList());

                return new ResponseEntity<>(shippingDTOList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ShippingDTO convertShippingToDTO(Shipping shipping) {
        ShippingDTO dto = new ShippingDTO();
        dto.setId(shipping.getId());
        dto.setShippingDate(shipping.getShippingDate());
        dto.setShippingTime(shipping.getShippingTime());
        dto.setShippingDescription(shipping.getShippingDescription());
        dto.setShippingPrice(shipping.getShippingPrice());

        // Obtener el nombre de la compañía de envío desde la entidad relacionada
        if (shipping.getShippingCompany() != null) {
            dto.setShippingCompany(convertShippingCompanyToDTO(shipping.getShippingCompany()));
        }

        // Obtener el nombre de la ciudad de origen desde la entidad relacionada
        if (shipping.getOriginCity() != null) {
            dto.setOriginCity(convertOriginCityToDTO(shipping.getOriginCity()));
        }

        // Obtener el nombre de la ciudad de destino desde la entidad relacionada
        if (shipping.getDestinationCity() != null) {
            dto.setDestinationCity(convertDestinationCityToDTO(shipping.getDestinationCity()));
        }

        // Obtener el sender desde la entidad relacionada
        if (shipping.getSender() != null) {
            dto.setSender(convertSenderToDTO(shipping.getSender()));
        }

        // Obtener el receiver desde la entidad relacionada
        if (shipping.getConsignee() != null) {
            dto.setConsignee(convertReceiverToDTO(shipping.getConsignee()));
        }

        // Obtener el tipo de envío desde la entidad relacionada
        if (shipping.getTypePackage() != null) {
            dto.setTypePackage(convertShippingTypeToDTO(shipping.getTypePackage()));
        }

        return dto;
    }

    private TypePackageDTO convertShippingTypeToDTO(TypePackage typePackage) {
        TypePackageDTO dto = new TypePackageDTO();
        dto.setId(typePackage.getId());
        dto.setTypePackageName(typePackage.getTypePackageName());
        return dto;
    }

    private ConsigneeDTO convertReceiverToDTO(Consignee consignee) {
        ConsigneeDTO dto = new ConsigneeDTO();
        dto.setId(consignee.getId());
        dto.setConsigneeName(consignee.getConsigneeName());
        dto.setConsigneeLastName(consignee.getConsigneeLastName());
        dto.setConsigneePhone(consignee.getConsigneePhone());
        dto.setConsigneeEmail(consignee.getConsigneeEmail());
        return dto;
    }

    private SenderDTO convertSenderToDTO(Sender sender) {
        SenderDTO dto = new SenderDTO();
        dto.setId(sender.getId());
        dto.setSenderName(sender.getSenderName());
        dto.setSenderLastName(sender.getSenderLastName());
        dto.setSenderPhone(sender.getSenderPhone());
        dto.setSenderEmail(sender.getSenderEmail());
        return dto;
    }

    private DestinationCityDTO convertDestinationCityToDTO(DestinationCity destinationCity) {
        DestinationCityDTO dto = new DestinationCityDTO();
        dto.setId(destinationCity.getId());
        dto.setDestinationCityName(destinationCity.getDestinationCityName());
        return dto;
    }

    private OriginCityDTO convertOriginCityToDTO(OriginCity originCity) {
        OriginCityDTO dto = new OriginCityDTO();
        dto.setId(originCity.getId());
        dto.setOriginCityName(originCity.getOriginCityName());
        return dto;
    }

    private ShippingCompanyDTO convertShippingCompanyToDTO(ShippingCompany shippingCompany){
        ShippingCompanyDTO dto = new ShippingCompanyDTO();
        dto.setId(shippingCompany.getId());
        dto.setShippingCompanyName(shippingCompany.getShippingCompanyName());
        dto.setShippingCompanyAddress(shippingCompany.getShippingCompanyAddress());
        dto.setShippingCompanyPhone(shippingCompany.getShippingCompanyPhone());
        dto.setShippingCompanyEmail(shippingCompany.getShippingCompanyEmail());
        dto.setShippingCompanyRuc(shippingCompany.getShippingCompanyRuc());
        dto.setShippingCompanyDescription(shippingCompany.getShippingCompanyDescription());
        return dto;
    }




    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Shipping Register by Id", notes = "Method for finding a Shipping Register by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Register found by Id"),
            @ApiResponse(code = 404, message = "Shipping Register Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ShippingDTO> findShippingRegisterById(@PathVariable("id") Long id){
        try {
            Optional<Shipping> shippingRegister = shippingService.getById(id);
            if (!shippingRegister.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                ShippingDTO shippingDTO = shippingRegister.map(this::convertShippingToDTO).get();
                return new ResponseEntity<>(shippingDTO, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Shipping Register", notes = "Method to update a Shipping Register")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Register updated successfully"),
            @ApiResponse(code = 404, message = "Shipping Register Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Shipping> updateShippingRegister(@PathVariable("id") Long id, @Valid @RequestBody Shipping shipping){
        try {
            Optional<Shipping> shippingRegister = shippingService.getById(id);
            if (!shippingRegister.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                shipping.setId(id);
                shippingService.save(shipping);
                return new ResponseEntity<>(shipping, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Shipping Register", notes = "Method to update a All Items of Shipping Register")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Register updated successfully"),
            @ApiResponse(code = 404, message = "Shipping Register Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Shipping> updateShippingRegister(@PathVariable("id") Long id, @RequestBody Shipping updatedShipping){
        try {
            Optional<Shipping> actualshippingRegister = shippingService.getById(id);
            Optional<ShippingCompany> actualCompany = shippingCompanyService.getById(id);
            //Optional<OriginCity> actualOriginCity = shippingService.getById(id);

            if (!actualshippingRegister.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                Shipping existingShipping = actualshippingRegister.get();
                // Actualiza los campos específicos que desees
                existingShipping.setShippingDate(updatedShipping.getShippingDate());
                existingShipping.setShippingTime(updatedShipping.getShippingTime());
                existingShipping.setShippingDescription(updatedShipping.getShippingDescription());
                existingShipping.setShippingPrice(updatedShipping.getShippingPrice());
                // Puedes continuar actualizando otros campos si es necesario
                // Luego, guarda la entidad actualizada
                shippingService.save(existingShipping);
                System.out.println("Entidad actualizada: " + existingShipping);

                return new ResponseEntity<>(existingShipping, HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
