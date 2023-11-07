package com.ecomArt.service.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistAccountRequest {

    private Long artId;
    private String password;
    private String name;
    private String email;
}
