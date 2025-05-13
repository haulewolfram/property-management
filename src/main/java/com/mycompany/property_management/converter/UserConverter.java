package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }
    public UserDTO convertEntitytoDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        return userDTO;
    }

}
