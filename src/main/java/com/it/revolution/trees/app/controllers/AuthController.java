package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.exception.BadAuthorizedCredentialsException;
import com.it.revolution.trees.app.model.entity.User;
import com.it.revolution.trees.app.security.jwt.JwtProvider;
import com.it.revolution.trees.app.security.jwt.dto.AuthRequest;
import com.it.revolution.trees.app.security.jwt.dto.AuthResponse;
import com.it.revolution.trees.app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;

    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public AuthResponse auth(AuthRequest request) throws BadAuthorizedCredentialsException {
        User user = userService.findByEmailAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

}
