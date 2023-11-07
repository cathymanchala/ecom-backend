package com.ecomArt.service.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {

    private Long userId;
    private String password;
    private String emailId;
    private String name;
    private String phoneNumber;
}
