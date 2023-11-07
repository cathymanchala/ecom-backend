package com.ecomArt.service.response;

import lombok.Builder;
import lombok.Data;


@Data
public class ProductResponse {
    private Long artist_Id;
    private Long productId;
    private String productName;
    private double price;
    private String description;
    private byte[] image;
    private double discount;
    private int stock;
    private String category;
    private String imageType;
}
