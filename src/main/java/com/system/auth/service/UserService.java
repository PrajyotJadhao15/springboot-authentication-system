package com.system.auth.service;

import com.system.auth.dto.UserDto;
import com.system.auth.entity.User;
import com.system.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserDto saveUser(UserDto userDto){

       // User user=modelMapper.map(userDto, User.class);

       // userRepository.save(modelMapper.map(userDto, User.class));

        return modelMapper.map(userRepository.save(modelMapper.map(userDto, User.class)), UserDto.class);

    }


}
