package com.it.revolution.trees.app.model.dto;

import com.it.revolution.trees.app.model.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponseDto {

    private String message;

    private UserDto registered;

}
