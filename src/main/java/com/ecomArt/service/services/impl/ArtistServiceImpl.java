package com.ecomArt.service.services.impl;

import com.ecomArt.service.entity.ArtistAccount;
import com.ecomArt.service.exception.InvalidUserLoginAccessException;
import com.ecomArt.service.repository.ArtistRepository;
import com.ecomArt.service.repository.UserRepository;
import com.ecomArt.service.entity.GeneralPublicUser;
import com.ecomArt.service.request.ArtistAccountRequest;
import com.ecomArt.service.request.LoginUserRequest;
import com.ecomArt.service.request.UserRequest;
import com.ecomArt.service.response.ArtistResponse;
import com.ecomArt.service.response.UserResponse;
import com.ecomArt.service.services.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class ArtistServiceImpl implements ArtistService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public ArtistResponse createArtistAccount(ArtistAccountRequest artistAccountRequest) {

        ArtistAccount artistAccount = new ArtistAccount();
        artistAccount.setArtId(artistAccountRequest.getArtId());
        artistAccount.setPassword(artistAccountRequest.getPassword());
        artistAccount.setName(artistAccountRequest.getName());
        artistAccount.setEmail(artistAccountRequest.getEmail());

        ArtistAccount artistEntity = artistRepository.saveAndFlush(artistAccount);

        ArtistResponse artistResponse = constructArtistResponse(artistEntity.getArtId());

        return artistResponse;
    }

    @Override
    public ArtistResponse getArtistLoginData(ArtistAccountRequest artistAccountRequest) {

        Optional<ArtistAccount> artistAccount = artistRepository.findByEmailAndPassword(artistAccountRequest.getEmail(), artistAccountRequest.getPassword());

        if(artistAccount.isEmpty()){
            throw new InvalidUserLoginAccessException("no hospital is present with this email an password");
        }

        if(artistAccount.isPresent()){
            ArtistAccount artistAccountEntity = artistAccount.get();
            return constructArtistResponse(artistAccountEntity.getArtId());

        }
        return null;
    }

    @Override
    public UserResponse getUserLoginData(LoginUserRequest loginUserRequest) {

        Optional<GeneralPublicUser> generalPublicUser = userRepository.findByEmailIdAndPassword(loginUserRequest.getEmail(), loginUserRequest.getPassword());

        UserResponse userResponse = new UserResponse();

        if(generalPublicUser.isEmpty()){
            throw new InvalidUserLoginAccessException("no user is present with this email an password");
        }

        if(generalPublicUser.isPresent()){
            GeneralPublicUser generalPublicUserEntity = generalPublicUser.get();
            userResponse.setUserId(generalPublicUserEntity.getUserId());
            userResponse.setEmailId(generalPublicUserEntity.getEmailId());
            userResponse.setName(generalPublicUserEntity.getName());
            userResponse.setPhoneNumber(generalPublicUserEntity.getPhoneNumber());
        }

        return userResponse;
    }
    @Override
    public UserResponse createUserAccount(UserRequest userRequest) {
        GeneralPublicUser generalPublicUser = new GeneralPublicUser();

        generalPublicUser.setPassword(userRequest.getPassword());
        generalPublicUser.setEmailId(userRequest.getEmailId());
        generalPublicUser.setPhoneNumber(userRequest.getPhoneNumber());
        generalPublicUser.setName(userRequest.getName());

        GeneralPublicUser generalPublicUserEntity = userRepository.saveAndFlush(generalPublicUser);

        return constructUserResponse(generalPublicUserEntity.getEmailId());

    }

    public ArtistResponse constructArtistResponse(Long artistId){
        ArtistAccount artistAccount = artistRepository.findByArtId(artistId);

        ArtistResponse artistResponse = new ArtistResponse();
        artistResponse.setArtId(artistAccount.getArtId());
        artistResponse.setPassword(artistAccount.getPassword());
        artistResponse.setName(artistAccount.getName());
        artistResponse.setEmail(artistAccount.getEmail());

        return artistResponse;
    }

    public UserResponse constructUserResponse(String emailId){
        GeneralPublicUser generalPublicUserEntity = userRepository.findByEmailId(emailId);
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(generalPublicUserEntity.getUserId());
        userResponse.setPassword(generalPublicUserEntity.getPassword());
        userResponse.setEmailId(generalPublicUserEntity.getEmailId());
        userResponse.setPhoneNumber(generalPublicUserEntity.getPhoneNumber());
        userResponse.setName(generalPublicUserEntity.getName());

        return userResponse;

    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long userId) {

        GeneralPublicUser generalPublicUser = userRepository.findByUserId(userId);

        generalPublicUser.setName(userRequest.getName());
        generalPublicUser.setPassword(userRequest.getPassword());
        generalPublicUser.setEmailId(userRequest.getEmailId());
        generalPublicUser.setPhoneNumber(userRequest.getPhoneNumber());

        GeneralPublicUser generalPublicUserEntity = userRepository.saveAndFlush(generalPublicUser);

        return constructUserResponse(generalPublicUserEntity.getEmailId());

    }

    public UserResponse getUserById(Long userId){
        GeneralPublicUser generalPublicUserEntity = userRepository.findByUserId(userId);
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(generalPublicUserEntity.getUserId());
        userResponse.setPassword(generalPublicUserEntity.getPassword());
        userResponse.setEmailId(generalPublicUserEntity.getEmailId());
        userResponse.setPhoneNumber(generalPublicUserEntity.getPhoneNumber());
        userResponse.setName(generalPublicUserEntity.getName());

        return userResponse;

    }
    
    
}
