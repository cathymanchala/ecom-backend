package com.ecomArt.service.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntityTest {

    @Test
    public void testArtistAccount() {
        ArtistAccount artistAccount = new ArtistAccount();

        artistAccount.setPassword("testPassword");
        artistAccount.setName("testUser");
        artistAccount.setEmail("testUser@test.io");

        assertNotNull(artistAccount);
    }

    @Test
    public void testGeneralPublicUser() {
        GeneralPublicUser generalPublicUser = new GeneralPublicUser();

        generalPublicUser.setPassword("testPassword");
        generalPublicUser.setEmailId("testUser@test.io");
        generalPublicUser.setName("testUser");
        generalPublicUser.setPhoneNumber("0102030");

        assertNotNull(generalPublicUser);
    }

    @Test
    public void testProduct() {
        Product product = new Product();

        product.setProductName("testUser");
        product.setPrice(1.01);
        product.setDescription("testDescription");
        product.setImageData(new byte[]{1});
        product.setImageName("testImageName");
        product.setImageType("testImageType");
        product.setDiscount(15.0);
        product.setStock(10);
        product.setCategory("testCategory");

        assertNotNull(product);
    }
}
