package com.ecomArt.service.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ArtistResponse {
    private Long artId;
    private String password;
    private String name;
    private String email;
}
