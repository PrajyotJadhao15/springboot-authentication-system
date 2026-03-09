package com.system.auth.controller;

import com.system.auth.entity.User;
import com.system.auth.security.CustomUserDetailsService;
import com.system.auth.service.JwtUtility;
import com.system.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public final JwtUtility jwtUtility;
    private final CustomUserDetailsService customUserDetailsService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        customUserDetailsService.loadUserByUsername(user.getUsername());

       String jwtToken= jwtUtility.generateToken(user.getUsername());

       return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }

}
