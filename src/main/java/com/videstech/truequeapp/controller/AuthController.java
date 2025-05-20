package com.videstech.truequeapp.controller;

import com.videstech.truequeapp.dto.auth.AuthRequest;
import com.videstech.truequeapp.dto.auth.AuthResponse;
import com.videstech.truequeapp.model.User;
import com.videstech.truequeapp.repository.UserRepository;
import com.videstech.truequeapp.security.JWT.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    /**
     * Realiza el login del usuario en el sistema.
     *
     * @return un token para el usuario.
     */
    @Operation(
            summary = "Loguear al usuario",
            description = "Retorna un token"
    )
    @ApiResponse(responseCode = "200", description = "Usuario logueado con exito.")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new AuthResponse(token));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).build();
        }
    }
}
