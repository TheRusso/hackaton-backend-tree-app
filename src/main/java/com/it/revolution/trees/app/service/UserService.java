package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.exception.BadAuthorizedCredentialsException;
import com.it.revolution.trees.app.model.entity.User;
import com.it.revolution.trees.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User findByEmailAndPassword(String email, String password) throws BadAuthorizedCredentialsException {
        return userRepository.findByEmail(email)
                .filter(c->passwordEncoder.matches(password, c.getPassword()))
                .orElseThrow(BadAuthorizedCredentialsException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElse(null);
    }
}
