package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.common.settings.WebSettings;
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
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final UserDtoValidationService dtoValidator;

    private final MailSenderService mailSender;

    private final WebSettings webSettings;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByEmailAndPassword(String email, String password) throws BadAuthorizedCredentialsException {
        return userRepository.findByEmail(email)
                .filter(c->passwordEncoder.matches(password, c.getPassword()))
                .orElseThrow(BadAuthorizedCredentialsException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElse(null);
    }

    public User save(User customer) {
        return userRepository.save(customer);
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
        user.setActivationCode(UUID.randomUUID().toString());
        User registered = userRepository.save(user);
        sendMessage(registered);
        return registered;
    }

    /**
     * Sends email message with activation code to the registered Customer.<br>
     * */
    private void sendMessage(User user) {
        String email = user.getEmail();
        if (Objects.nonNull(email) && !email.isBlank()) {
            String message = String.format(
                    "Hello, %s\nWelcome to the 4vesla site. You are trying to create new account, please follow this link http://%s/activate/email/%d/%s to accomplish registration process.",
                    user.getFullName(),
                    webSettings.getBackend().getHost(),
                    user.getId(),
                    user.getActivationCode()
            );
            mailSender.send(email, "4vesla account confirmation.", message);
        }
    }

}