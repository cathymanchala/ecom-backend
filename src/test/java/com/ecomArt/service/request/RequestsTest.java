package com.ecomArt.service.request;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestsTest {

    @Test
    public void testArtistAccount() {
        ArtistAccountRequest artistAccountRequest = ArtistAccountRequest.builder()
                .artId(Long.parseLong("01"))
                .password("testPassword")
                .name("testUser")
                .email("testUser@test.io")
                .build();

        assertNotNull(artistAccountRequest);
    }

    @Test
    public void testLoginUserRequest() {
        LoginUserRequest loginUserRequest = LoginUserRequest.builder()
                .email("testUser@test.io")
                .password("testPassword")
                .build();
        assertNotNull(loginUserRequest);
    }

    @Test
    public void testProductRequest() {
        MultipartFile mockFile = new MockMultipartFile("file", "filename.txt", "text/plain", "File content".getBytes());

        ProductRequest productRequest = ProductRequest.builder()
                .artist_Id(Long.parseLong("01"))
                .productId(Long.parseLong("1"))
                .productName("testProduct")
                .price(25.00)
                .description("testDescription")
                .image(mockFile)
                .discount(10.0)
                .stock(200)
                .category("testCategory")
                .build();

        assertNotNull(productRequest);
    }

    @Test
    public void testUserRequest() {
        UserRequest userRequest = UserRequest.builder()
                .userId(Long.parseLong("01"))
                .password("testPassword")
                .emailId("testUser@test.io")
                .name("testUser")
                .phoneNumber("0102030")
                .build();
        assertNotNull(userRequest);
    }
}
