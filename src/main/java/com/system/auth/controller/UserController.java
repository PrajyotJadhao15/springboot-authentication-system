package com.system.auth.controller;
import com.system.auth.dto.UserDto;
import com.system.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto regUser){

        regUser.setPassword(passwordEncoder.encode(regUser.getPassword()));

        return new ResponseEntity<>(userService.saveUser(regUser),HttpStatus.ACCEPTED);

    }


}
