package com.ecomArt.service.services;

import java.io.IOException;
import java.util.List;

import com.ecomArt.service.entity.Product;
import com.ecomArt.service.request.ProductRequest;
import com.ecomArt.service.response.ProductResponse;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest, Long artId) throws IOException;

    List<Product> getProductByArtId(Long productId);

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    void deleteProductById(Long productId);
    void updateProduct(Long productId, ProductRequest updatedProduct) throws ChangeSetPersister.NotFoundException, IOException;
}
