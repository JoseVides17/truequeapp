package com.videstech.truequeapp.mapper;

import com.videstech.truequeapp.dto.user.UserCreateDTO;
import com.videstech.truequeapp.dto.user.UserDTO;
import com.videstech.truequeapp.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setLocation(user.getLocation());
        dto.setPhone(user.getPhone());
        dto.setReputation(user.getReputation());
        return dto;
    }

    public static User toEntity(UserCreateDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setLocation(dto.getLocation());
        user.setPhone(dto.getPhone());
        return user;
    }
}

