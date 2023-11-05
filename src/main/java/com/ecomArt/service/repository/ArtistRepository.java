package com.ecomArt.service.repository;

import com.ecomArt.service.entity.ArtistAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistAccount, Long> {
    ArtistAccount findByArtId(Long artistId);
    Optional<ArtistAccount> findByEmailAndPassword(String artEmail, String artPassword);
}
