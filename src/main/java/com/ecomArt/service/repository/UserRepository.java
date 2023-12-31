package com.ecomArt.service.repository;

import com.ecomArt.service.entity.GeneralPublicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GeneralPublicUser, String> {

    Optional<GeneralPublicUser> findByEmailIdAndPassword(String emailId, String password);

    GeneralPublicUser findByEmailId(String emailId);

    GeneralPublicUser findByUserId(Long userId);
}
