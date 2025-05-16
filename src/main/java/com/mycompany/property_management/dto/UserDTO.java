package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is required")
    @NotEmpty(message = "Owner email can not be Empty")
    @Size(min=1, max=50, message="Email should be 1 to 50 character in length")
    private String ownerEmail;
    private String phoneNumber;
    @NotNull(message = "Password is mandatory")
    @NotEmpty(message = "password can not be empty")
    private String password;
}
