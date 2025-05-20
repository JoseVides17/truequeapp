package com.videstech.truequeapp.controller;

import com.videstech.truequeapp.dto.favorite.FavoriteDTO;
import com.videstech.truequeapp.service.favorite.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
@Tag(name = "Favoritos", description = "Operaciones relacionadas con los favoritos del usuario.")
public class FavoriteController {

    private final FavoriteService favoriteService;

    /**
     * Agrega un favorito a la lista del usuario.
     *
     * @return FavoriteDTO
     */
    @Operation(
            summary = "Agregar favorito al usuario.",
            description = "Retorna el favorito agregado."
    )
    @ApiResponse(responseCode = "201", description = "Favorito agregado")
    @PostMapping("/{itemId}")
    public ResponseEntity<FavoriteDTO> addFavorite(@PathVariable Long itemId) {
        return ResponseEntity.ok(favoriteService.addFavorite(itemId));
    }

    /**
     * Elimina favorito de a lista del usuario.
     */
    @Operation(
            summary = "Eliminar favorito de la lista.",
            description = "Elimina el favorito de la lsta del usuario."
    )
    @ApiResponse(responseCode = "204", description = "Elemento eliminado de la lista.")
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long itemId) {
        favoriteService.removeFavorite(itemId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene todos los ítems favoritos del usuario autenticado.
     *
     * @return lista de FavoriteDTO
     */
    @Operation(
            summary = "Obtener favoritos del usuario autenticado",
            description = "Retorna una lista de ítems marcados como favoritos por el usuario actualmente autenticado"
    )
    @ApiResponse(responseCode = "200", description = "Lista de favoritos obtenida correctamente")
    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getFavorites() {
        return ResponseEntity.ok(favoriteService.getFavorites());
    }
}

