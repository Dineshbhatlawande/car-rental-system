package com.codeforcars.dto;

import com.codeforcars.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private long userId;

}
