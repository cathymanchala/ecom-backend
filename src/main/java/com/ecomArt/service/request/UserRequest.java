package com.ecomArt.service.request;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserRequest {

    private Long userId;
    private String password;
    private String emailId;
    private String name;
    private String phoneNumber;

}
