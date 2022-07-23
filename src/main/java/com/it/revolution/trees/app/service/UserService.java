package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.exception.BadAuthorizedCredentialsException;
import com.it.revolution.trees.app.exception.TakenEmailException;
import com.it.revolution.trees.app.mapper.UserMapper;
import com.it.revolution.trees.app.model.dto.UserDto;
import com.it.revolution.trees.app.model.entity.Role;
import com.it.revolution.trees.app.model.entity.User;
import com.it.revolution.trees.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final UserDtoValidationService dtoValidator;

    public User findByEmailAndPassword(String email, String password) throws BadAuthorizedCredentialsException {
        return userRepository.findByEmail(email)
                .filter(c->passwordEncoder.matches(password, c.getPassword()))
                .orElseThrow(BadAuthorizedCredentialsException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElse(null);
    }

    public User register(UserDto userDto) throws TakenEmailException {

        IllegalStateException ex = dtoValidator.validateCustomerDto(userDto);
        if (Objects.nonNull(ex)){
            throw ex;
        }

        User user = userMapper.dtoToEntity(userDto);
        if (userRepository.existsByEmail(user.getEmail())){
            throw new TakenEmailException(user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        return userRepository.save(user);
    }
}