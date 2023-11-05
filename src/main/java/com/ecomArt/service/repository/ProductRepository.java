package com.ecomArt.service.repository;

//import com.ecomArt.service.entity.ArtistAccount;
import com.ecomArt.service.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIncrementdartistId(Long incrementdartistId);
    Product findByProductId(Long productId);
    void deleteByProductId(Long productId);

}