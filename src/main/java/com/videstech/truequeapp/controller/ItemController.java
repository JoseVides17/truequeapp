package com.videstech.truequeapp.controller;

import com.videstech.truequeapp.dto.item.ItemCreateDTO;
import com.videstech.truequeapp.dto.item.ItemDTO;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.service.Item.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.AssertFalse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
@Tag(name = "Items", description = "Operaciones relacionadas con los items.")
public class ItemController {

    private final ItemService itemService;

    /**
     * Obtiene todos los ítems registrados por el usuario autenticado.
     *
     * @return lista de ItemDTO
     */
    @Operation(
            summary = "Obtener lista de items del usuario.",
            description = "Retorna una lista de ítems del usuario."
    )
    @ApiResponse(responseCode = "200", description = "Lista de items obtenida correctamente")
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return ResponseEntity.ok(itemService.findAll());
    }

    /**
     * Crea un item.
     *
     * @return un ItemDTO.
     */
    @Operation(
            summary = "Crear un item por el usuario",
            description = "Retorna el item creado"
    )
    @ApiResponse(responseCode = "201", description = "Item creado con exito.")
    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(dto));
    }

    /**
     * Obtiene un item del usuario.
     *
     * @return lista de FavoriteDTO
     */
    @Operation(
            summary = "Obtener items del usuario autenticado",
            description = "Retorna un item"
    )
    @ApiResponse(responseCode = "200", description = "Item obtenido con exito")
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getById(id));
    }

    /**
     * Elimina item.
     */
    @Operation(
            summary = "Elimina item de la lista.",
            description = "Elimina item de la lista"
    )
    @ApiResponse(responseCode = "204", description = "Item eliminado con exito")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
