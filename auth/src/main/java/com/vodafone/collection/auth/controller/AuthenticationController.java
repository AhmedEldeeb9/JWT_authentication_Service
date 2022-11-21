package com.vodafone.collection.auth.controller;


import com.vodafone.collection.auth.dtoRequest.AuthRequest;
import com.vodafone.collection.auth.dtoResponse.AuthResponse;
import com.vodafone.collection.auth.service.UserResourcesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/voda-auth", produces = "application/json")
public class AuthenticationController {

    @Autowired
    UserResourcesService userResourcesService;


    @PostMapping(path = "/adminlogin")
    @Operation(summary = "Login after authenticate and get token used over the application",
            description = "Login after authenticate and get token used over the application")
    public AuthResponse login(@RequestBody AuthRequest authenticationRequest) throws Exception {

        String token = "";
            AuthResponse auth = new AuthResponse();
        try {
            // user data >> first element holds userName, Second one holds Password
            auth.setJwttoken(userResourcesService.generateToken(authenticationRequest.getUsername()));
            auth.setUsername(authenticationRequest.getUsername());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return auth;
    }


}
