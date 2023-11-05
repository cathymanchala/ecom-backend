package com.ecomArt.service.request;


import lombok.Data;


@Data
public class UserRequest {

    private Long userId;
    private String password;
    private String emailId;
    private String name;
    private String phoneNumber;

}
