package com.ecomArt.service.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequest {
    private Long artist_Id;
    private Long productId;
    private String productName;
    private double price;
    private String description;
    private MultipartFile image;
    private double discount;
    private int stock;
    private String category;
}
