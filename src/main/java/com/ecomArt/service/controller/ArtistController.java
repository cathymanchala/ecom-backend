package com.ecomArt.service.controller;

import com.ecomArt.service.request.ArtistAccountRequest;
import com.ecomArt.service.request.LoginUserRequest;
import com.ecomArt.service.request.UserRequest;
import com.ecomArt.service.response.ArtistResponse;
import com.ecomArt.service.response.UserResponse;
import com.ecomArt.service.services.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
@Validated
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    @PostMapping("/create-user-account")
    public UserResponse createUserAccount(@RequestBody UserRequest userRequest){
        return artistService.createUserAccount(userRequest);
    }

    @PostMapping("/create-artist-account")
    public ArtistResponse createArtistAccount(@RequestBody ArtistAccountRequest artistAccountRequest){
        return artistService.createArtistAccount(artistAccountRequest);
    }

    @PostMapping("/login-user")
    public UserResponse loginRequest(@RequestBody LoginUserRequest loginUserRequest) {
        return artistService.getUserLoginData(loginUserRequest);
    }

    @PostMapping("/login-artist")
    public ArtistResponse artistLoginRequest(@RequestBody ArtistAccountRequest artistAccountRequest){
        return artistService.getArtistLoginData(artistAccountRequest);
    }

    @PutMapping("/update-user/{userId}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest, @PathVariable Long userId){
        return artistService.updateUser(userRequest,userId);
    }

    @GetMapping("/get-user/{userId}")
    public UserResponse getUserById(@PathVariable Long userId){
        return artistService.getUserById(userId);
    }

    


}
