package com.ecomArt.service.services;


import com.ecomArt.service.request.ArtistAccountRequest;
import com.ecomArt.service.response.ArtistResponse;
import com.ecomArt.service.request.LoginUserRequest;
import com.ecomArt.service.request.UserRequest;

import com.ecomArt.service.response.UserResponse;


public interface ArtistService {
    ArtistResponse createArtistAccount(ArtistAccountRequest artistAccountRequest);

    UserResponse getUserLoginData(LoginUserRequest loginUserRequest);

    ArtistResponse getArtistLoginData(ArtistAccountRequest artistAccountRequest);

    UserResponse createUserAccount(UserRequest userRequest);

    public UserResponse updateUser(UserRequest userRequest, Long userId);

    public UserResponse getUserById(Long userId);

}
