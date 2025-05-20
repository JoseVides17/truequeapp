package com.videstech.truequeapp.service.user;

import com.videstech.truequeapp.dto.user.UserCreateDTO;
import com.videstech.truequeapp.dto.user.UserDTO;
import com.videstech.truequeapp.mapper.UserMapper;
import com.videstech.truequeapp.model.User;
import com.videstech.truequeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(UserCreateDTO dto) {
        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return UserMapper.toDTO((userRepository.save(user)));
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO).orElseThrow(() -> new RuntimeException(("User not found")));
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userRepository.findByEmail(email).map(UserMapper::toDTO).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

}
