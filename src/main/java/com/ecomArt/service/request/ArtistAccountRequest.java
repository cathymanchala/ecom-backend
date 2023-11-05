package com.ecomArt.service.request;

import lombok.Data;

@Data
public class ArtistAccountRequest {

    private Long artId;
    private String password;
    private String name;
    private String email;
}
