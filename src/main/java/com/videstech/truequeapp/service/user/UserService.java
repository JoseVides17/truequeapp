package com.videstech.truequeapp.service.user;

import com.videstech.truequeapp.dto.user.UserCreateDTO;
import com.videstech.truequeapp.dto.user.UserDTO;
import com.videstech.truequeapp.model.User;

import java.util.Optional;

public interface UserService {
    UserDTO register(UserCreateDTO dto);
    UserDTO findById(Long id);
    UserDTO findByEmail(String email);
}
