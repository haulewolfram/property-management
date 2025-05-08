package com.mycompany.property_management.service;
import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Component
public interface PropertyService {
    @Autowired
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long PropertyId);
    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO  updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,Long propertyId);
    void deleteProperty(Long propertyId);
}
