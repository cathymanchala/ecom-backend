package com.ecomArt.service.request;

import lombok.Data;

@Data
public class LoginUserRequest {

    private String email;
    private String password;

}
