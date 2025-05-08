package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import jakarta.transaction.Transactional;
import org.hibernate.dialect.OracleUserDefinedTypeExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
     private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
         @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        // TODO: Add logic to save the property

PropertyEntity pe=propertyConverter.convertDTOtoEntity(propertyDTO);
        pe=propertyRepository.save(pe);
        PropertyDTO dto=propertyConverter.convertEntitytoDTO(pe);
        return dto;
    }

    @Override

    public List<PropertyDTO> getAllProperties() {
             List<PropertyEntity>listOfProps=(List<PropertyEntity>)propertyRepository.findAll();
             List<PropertyDTO>propList=new ArrayList<>();
             for(PropertyEntity pe:listOfProps){
                 PropertyDTO dto=propertyConverter.convertEntitytoDTO(pe);
                 propList.add(dto);
             }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long PropertyId) {
            Optional<PropertyEntity> optEn = propertyRepository.findById(PropertyId);
            PropertyDTO dto=null;
            if(optEn.isPresent()){
                PropertyEntity pe=optEn.get();//Data from database
                pe.setTitle(propertyDTO.getTitle());
                pe.setAddress(propertyDTO.getAddress());
                pe.setOwnerEmail(propertyDTO.getOwnerEmail());
                pe.setOwnerName(propertyDTO.getOwnerName());
                pe.setPrice(propertyDTO.getPrice());
                pe.setDescription(propertyDTO.getDescription());
                dto=propertyConverter.convertEntitytoDTO(pe);
                propertyRepository.save(pe);
            }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optEn.isPresent()){
            PropertyEntity pe=optEn.get();//Data from database
            pe.setDescription(propertyDTO.getDescription());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto=null;
        if(optEn.isPresent()){
            PropertyEntity pe=optEn.get();//Data from database
            pe.setPrice(propertyDTO.getPrice());
            dto=propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
