package com.ecomArt.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;


@Entity()
@Table(name = "artist_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private Long incrementdartistId;
    private String productName;
    private double price;
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;
    private String imageName;
    private String imageType;
    private double discount;
    private int stock;
    private String category;
}
