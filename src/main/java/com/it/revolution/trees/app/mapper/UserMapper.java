package com.it.revolution.trees.app.mapper;

import com.it.revolution.trees.app.model.dto.UserDto;
import com.it.revolution.trees.app.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDto entityToDto(User entity) {

        return UserDto.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .fullName(entity.getFullName()).build();

    }

    public User dtoToEntity(UserDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .fullName(dto.getFullName()).build();
    }

}
