package com.ecomArt.service.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.awt.image.BufferedImage;
import com.ecomArt.service.entity.Product;
import com.ecomArt.service.request.ProductRequest;
import com.ecomArt.service.response.ProductResponse;
import com.ecomArt.service.services.ProductService;

@RestController
@RequestMapping("/service")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping(value="/add-product/{artist_Id}", consumes  = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductResponse addProduct(@ModelAttribute ProductRequest productRequest, @PathVariable Long artist_Id) throws IOException {
        System.out.println("addProduct of controller called");
        System.out.println(productRequest.getImage().getOriginalFilename());
        return productService.addProduct(productRequest, artist_Id);
    }

    @GetMapping(value="/get-product/{incrementdartistId}")
    public ResponseEntity<List<ProductResponse>> getProductByArtId(@PathVariable Long incrementdartistId) {
        List<Product> products = productService.getProductByArtId(incrementdartistId);

        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product product : products) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductId(product.getProductId());
            productResponse.setProductName(product.getProductName());
            productResponse.setDiscount(product.getDiscount());
            productResponse.setArtist_Id(product.getIncrementdartistId());
            productResponse.setImage(product.getImageData());
            productResponse.setStock(product.getStock());
            productResponse.setDescription(product.getDescription());
            productResponse.setPrice(product.getPrice());
            productResponse.setCategory(product.getCategory());
            productResponse.setImageType(product.getImageType());

            productResponses.add(productResponse);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(productResponses, headers, HttpStatus.OK);
    }

    @GetMapping(value="/get-product-details/{productId}")
    public ResponseEntity<ProductResponse> getProductByProductId(@PathVariable Long productId) {

        Product product = productService.getProductById(productId);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductName(product.getProductName());
        productResponse.setDiscount(product.getDiscount());
        productResponse.setArtist_Id(product.getIncrementdartistId());
        productResponse.setImage(product.getImageData());
        productResponse.setStock(product.getStock());
        productResponse.setPrice(product.getPrice());
        productResponse.setCategory(product.getCategory());
        productResponse.setDescription(product.getDescription());
        productResponse.setImageType(product.getImageType());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(productResponse, headers, HttpStatus.OK);
    }

    @GetMapping(value="/get-all-products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product product : products) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductId(product.getProductId());
            productResponse.setProductName(product.getProductName());
            productResponse.setDiscount(product.getDiscount());
            productResponse.setArtist_Id(product.getIncrementdartistId());
            productResponse.setImage(product.getImageData());
            productResponse.setStock(product.getStock());
            productResponse.setDescription(product.getDescription());
            productResponse.setPrice(product.getPrice());
            productResponse.setCategory(product.getCategory());
            productResponse.setImageType(product.getImageType());

            productResponses.add(productResponse);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(productResponses, headers, HttpStatus.OK);
    }
    @PutMapping(value="/update-product/{productId}", consumes  = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateProduct(
            @PathVariable Long productId,
            @ModelAttribute ProductRequest updatedProduct) {
        try {
            productService.updateProduct(productId, updatedProduct);
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating product: " + e.getMessage());
        }
    }

    @DeleteMapping(value="/delete-product/{productId}")
    public void deleteProductByProductId(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }

}
