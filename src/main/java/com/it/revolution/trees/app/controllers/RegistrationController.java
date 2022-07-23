package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.exception.TakenEmailException;
import com.it.revolution.trees.app.mapper.UserMapper;
import com.it.revolution.trees.app.model.dto.RegistrationResponseDto;
import com.it.revolution.trees.app.model.dto.UserDto;
import com.it.revolution.trees.app.model.entity.User;
import com.it.revolution.trees.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<RegistrationResponseDto> register(UserDto registrationRequest) throws TakenEmailException, IllegalStateException {

        User registered = userService.register(registrationRequest);
        UserDto userDto = userMapper.entityToDto(registered);

        return ResponseEntity.ok(RegistrationResponseDto.builder().message("Registration succeed!").registered(userDto).build());
    }

}
