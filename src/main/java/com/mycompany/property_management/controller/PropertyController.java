package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    @Value("${pms.dummy:}")
    private  String dummy;
    @Value("${spring.datasource.url:}")
    private  String dbUrl;



    @Autowired
    private PropertyService propertyService;

    @PostMapping("/property")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO>responseEntity=new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/property")
    public ResponseEntity<List<PropertyDTO>>getAllProperty(){
        List<PropertyDTO> propertylist=propertyService.getAllProperties();
        System.out.println(dummy);
        System.out.println(dbUrl);
        ResponseEntity<List<PropertyDTO>>responseEntity=new ResponseEntity<>(propertylist,HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/property/{propertyId}")
    public  ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
    propertyDTO=propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO>responseEntity=new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
        return responseEntity;
    }
    @PatchMapping("/property/update-description/{propertyId}")
    public  ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO=propertyService.updatePropertyDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO>responseEntity=new ResponseEntity<>(propertyDTO,HttpStatus.OK);
        return responseEntity;

    }
    @PatchMapping("/property/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO=propertyService.updatePropertyPrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO>responseEntity=new ResponseEntity<>(propertyDTO,HttpStatus.OK);
        return responseEntity;

    }
    @DeleteMapping("/property/{propertyId}")
    public void deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void>responseEntity=new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

    }
}
