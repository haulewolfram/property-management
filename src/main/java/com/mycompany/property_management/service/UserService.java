package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password );

}
