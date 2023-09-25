package upc.edu.pe.softroute.shippingregisterservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.ShippingCompany;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingCompanyService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/shipping_companies")
@CrossOrigin(origins = "*")
@Api(value = "Web Service RESTFul of Shipping Companies", tags = "ShippingCompanies")
public class ShippingCompanyController {

    private final IShippingCompanyService shippingCompanyService;
    public ShippingCompanyController(IShippingCompanyService shippingCompanyService) {
        this.shippingCompanyService = shippingCompanyService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Shipping Company", notes = "Method to create a new Shipping Company")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Shipping Company found"),
            @ApiResponse(code = 404, message = "Shipping Company Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<ShippingCompany> insertShippingCompany(@Valid @RequestBody ShippingCompany shippingCompany){
        try{
            ShippingCompany shippingCompanyNew = shippingCompanyService.save(shippingCompany);
            return ResponseEntity.status(HttpStatus.CREATED).body(shippingCompanyNew);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all Shipping Companies", notes = "Method to list all Shipping Companies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All Shipping Companies founds"),
            @ApiResponse(code = 404, message = "Shipping Companies Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<ShippingCompany>> findAllShippingCompanies(){
        try{
            List<ShippingCompany> shippingCompanies = shippingCompanyService.getAll();
            if (shippingCompanies.size() > 0){
                return new ResponseEntity<>(shippingCompanies, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Shipping Company by Id", notes = "Method for finding a Shipping Company by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Company found by Id"),
            @ApiResponse(code = 404, message = "Shipping Company Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ShippingCompany> findShippingCompanyById(@PathVariable("id") Long id){
        try {
            Optional<ShippingCompany> shippingCompany = shippingCompanyService.getById(id);
            if (!shippingCompany.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(shippingCompany.get(), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Shipping Company data", notes = "Method to update Shipping Company")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Company updated successfully"),
            @ApiResponse(code = 404, message = "Shipping Company Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    public ResponseEntity<ShippingCompany> updateShippingCompany(@PathVariable("id") Long id, @RequestBody ShippingCompany shippingCompany){
        try {
            Optional<ShippingCompany> existingShippingCompany = shippingCompanyService.getById(id);
            if (!existingShippingCompany.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                shippingCompany.setId(id);
                shippingCompanyService.save(shippingCompany);
                return new ResponseEntity<>(shippingCompany, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Shipping Company", notes = "Method for deleting a Shipping Company")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Company deleted"),
            @ApiResponse(code = 404, message = "Shipping Company Not Deleted"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ShippingCompany> deleteShippingCompany(@PathVariable("id") Long id){
        try{
            Optional<ShippingCompany> shippingCompany = shippingCompanyService.getById(id);
            if (!shippingCompany.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                shippingCompanyService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ruc/{ruc}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Shipping Company by Ruc", notes = "Method for finding a Shipping Company by Ruc")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Shipping Company found by Ruc"),
            @ApiResponse(code = 404, message = "Shipping Company Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ShippingCompany> findShippingCompanyByShippingCompanyRuc(@PathVariable("ruc") String ruc){
        try {
            Optional<ShippingCompany> shippingCompany = shippingCompanyService.findShippingCompanyByShippingCompanyRuc(ruc);
            if (!shippingCompany.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(shippingCompany.get(), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
