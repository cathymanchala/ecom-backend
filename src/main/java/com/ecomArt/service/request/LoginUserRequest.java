package com.ecomArt.service.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserRequest {

    private String email;
    private String password;

}
