package com.ecomArt.service.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResponseTest {

    @Test
    public void testArtistResponse() {
        ArtistResponse artistResponse = new ArtistResponse();
        artistResponse.setArtId(Long.parseLong("01"));
        artistResponse.setPassword("testPassword");
        artistResponse.setName("testUser");
        artistResponse.setEmail("testUser@test.io");
        assertNotNull(artistResponse);
    }

    @Test
    public void testProductResponse() {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setArtist_Id(Long.parseLong("01"));
        productResponse.setProductId(Long.parseLong("001"));
        productResponse.setProductName("testProduct");
        productResponse.setPrice(100.0);
        productResponse.setDescription("testProductDescription");
        productResponse.setImage(new byte[]{1});
        productResponse.setDiscount(15.0);
        productResponse.setStock(200);
        productResponse.setCategory("testProductCategory");
        productResponse.setImageType("testImageType");

        assertNotNull(productResponse);
    }

    @Test
    public void testUserResponse() {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(Long.parseLong("01"));
        userResponse.setPassword("testPassword");
        userResponse.setEmailId("testUser@test.io");
        userResponse.setName("testUser");
        userResponse.setPhoneNumber("0102030");

        assertNotNull(userResponse);
    }
}
