package com.videstech.truequeapp.controller;

import com.videstech.truequeapp.dto.user.UserCreateDTO;
import com.videstech.truequeapp.dto.user.UserDTO;
import com.videstech.truequeapp.repository.UserRepository;
import com.videstech.truequeapp.security.JWT.JwtService;
import com.videstech.truequeapp.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Realiza el registro de un usuario.
     *
     * @return un UserDTO
     */
    @Operation(
            summary = "Registrar un usuario",
            description = "Retorna el usuario registrado."
    )
    @ApiResponse(responseCode = "200", description = "Usuario registrado con exito.")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(dto));
    }

    /**
     * Obtiene un usuario registrado.
     *
     * @return un UserDTO
     */
    @Operation(
            summary = "Obtener un usuario",
            description = "Retorna un usuario registrado"
    )
    @ApiResponse(responseCode = "200", description = "Usuario obtenido con exito.")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

}
