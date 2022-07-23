package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserDtoValidationService {

    public IllegalStateException validateCustomerDto(UserDto userDto) {
        if (isNull(userDto)) {
            return new IllegalStateException("User object can not be null");
        }
        if (isNull(userDto.getFullName())) {
            return new IllegalStateException("User full name can not be null");
        }
        if ("".equals(userDto.getFullName())) {
            return new IllegalStateException("User name can not be empty");
        }
        if (isNull(userDto.getEmail())) {
            return new IllegalStateException("User email can not be null");
        }
        if ("".equals(userDto.getEmail())) {
            return new IllegalStateException("User email can not be empty");
        }
        if (isNull(userDto.getPassword())) {
            return new IllegalStateException("User password can not be null");
        }
        if ("".equals(userDto.getPassword())) {
            return new IllegalStateException("User password can not be empty");
        }

        return validateEmail(userDto.getEmail());
    }

    public IllegalStateException validateEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return new IllegalStateException("Not valid email");
        }
        return null;
    }

}
