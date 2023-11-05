package com.ecomArt.service.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.ecomArt.service.entity.Product;
import com.ecomArt.service.repository.ProductRepository;
import com.ecomArt.service.request.ProductRequest;
import com.ecomArt.service.response.ProductResponse;
import com.ecomArt.service.services.ProductService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest, Long artId) throws IOException {
        System.out.println("AddProduct of service is called");
        Product product = modelMapper.map(productRequest, Product.class);
        product.setIncrementdartistId(artId);
        System.out.println(productRequest.getImage().getOriginalFilename());
        product.setImageName(productRequest.getImage().getOriginalFilename());
        product.setImageType(productRequest.getImage().getContentType());
        product.setImageData(productRequest.getImage().getBytes());
        if (productRequest.getImage() != null) {
            System.out.println("File uploaded successfully: " + productRequest.getImage().getOriginalFilename());
        }

        Product newProduct = productRepository.save(product);
        ProductResponse response = modelMapper.map(newProduct, ProductResponse.class);
        response.setArtist_Id(product.getIncrementdartistId());
        
        response.setImage(product.getImageData());

        return response;

    }
    @Override
    public List<Product> getProductByArtId(Long incrementdartistId){
        return productRepository.findByIncrementdartistId(incrementdartistId);
    }

    @Override
    public Product getProductById(Long productId){
        return productRepository.findByProductId(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void deleteProductById(Long productId) {
        productRepository.deleteByProductId(productId);
    }

    @Override
    @Transactional
    public void updateProduct(Long productId, ProductRequest updatedProduct) throws ChangeSetPersister.NotFoundException, IOException {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setDiscount(updatedProduct.getDiscount());
        existingProduct.setStock(updatedProduct.getStock());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setImageName(updatedProduct.getImage().getOriginalFilename());
        existingProduct.setImageType(updatedProduct.getImage().getContentType());
        existingProduct.setImageData(updatedProduct.getImage().getBytes());
        if (updatedProduct.getImage() != null) {
            System.out.println("File updated successfully: " + updatedProduct.getImage().getOriginalFilename());
        }
        productRepository.save(existingProduct);
    }

}
