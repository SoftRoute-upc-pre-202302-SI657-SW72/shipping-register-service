package upc.edu.pe.softroute.shippingregisterservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.Shipping;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.ShippingCompany;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingCompanyService;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Shipping>> findAllShippingRegisters(){
        try{
            List<Shipping> shippingRegisters = shippingService.getAll();
            if (shippingRegisters.size() > 0){
                return new ResponseEntity<>(shippingRegisters, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Shipping Register by Id", notes = "Method for finding a Shipping Register by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Register found by Id"),
            @ApiResponse(code = 404, message = "Shipping Register Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Shipping> findShippingRegisterById(@PathVariable("id") Long id){
        try {
            Optional<Shipping> shippingRegister = shippingService.getById(id);
            if (!shippingRegister.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(shippingRegister.get(), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Shipping Register", notes = "Method to update a Shipping Register")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Register updated successfully"),
            @ApiResponse(code = 404, message = "Shipping Register Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Shipping> updateShippingRegister(@PathVariable("id") Long id, @RequestBody Shipping shipping){
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
    }

}
