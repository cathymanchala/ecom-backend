package com.entity;

import com.ecomArt.service.entity.ArtistAccount;
import com.ecomArt.service.entity.GeneralPublicUser;
import com.ecomArt.service.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntityTest {

    @Test
    public void testArtistAccount() {
        ArtistAccount artistAccount = new ArtistAccount();
        String password = "testPassword";
        String name = "testName";
        String email = "testEmail";

        assertEquals(password, "testPassword");
        assertEquals(name, "testName");
        assertEquals(email, "testEmail");
    }

    @Test
    public void testGeneralPublicUser() {
        GeneralPublicUser generalPublicUser = new GeneralPublicUser();
        String password = "testPassword";
        String emailId = "testEmailId";
        String name = "testName";
        String phoneNumber = "1";

        assertEquals(password, "testPassword");
        assertEquals(emailId, "testEmailId");
        assertEquals(name, "testName");
        assertEquals(phoneNumber, "1");
    }

    @Test
    public void testProduct() {
        Product product = new Product();

        String productName = "testProductName";
        double price = 1.01;
        String description = "testDescription";
        byte[] imageData = new byte[]{1};
        String imageName = "testImageName";
        String imageType = "testImageType";
        double discount = 1.5;
        int stock = 10;
        String category = "testCategory";

        assertEquals(productName, "testProductName");
        assertEquals(price, 1.01);
        assertEquals(description, "testDescription");
        assertNotNull(imageData);
        assertEquals(imageName, "testImageName");
        assertEquals(imageType, "testImageType");
        assertEquals(discount, 1.5);
        assertEquals(stock, 10);
        assertEquals(category, "testCategory");
    }
}
