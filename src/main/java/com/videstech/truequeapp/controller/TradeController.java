package com.videstech.truequeapp.controller;

import com.videstech.truequeapp.dto.trade.TradeRequestCreateDTO;
import com.videstech.truequeapp.dto.trade.TradeRequestDTO;
import com.videstech.truequeapp.dto.trade.TradeStatusUpdateDTO;
import com.videstech.truequeapp.model.enums.TradeStatus;
import com.videstech.truequeapp.service.trade.TradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
@RequiredArgsConstructor
public class TradeController {
    private final TradeService tradeService;

    /**
     * Registra una TradeRequest.
     *
     * @return una TradeRequestDTO
     */
    @Operation(
            summary = "Registrar Trade por el usuario autenticado",
            description = "Retorna la trade creada"
    )
    @ApiResponse(responseCode = "201", description = "Trade creada con exito.")
    @PostMapping
    public ResponseEntity<TradeRequestDTO> createTrade(@RequestBody TradeRequestCreateDTO dto) {
        TradeRequestDTO created = tradeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Obtiene una lista de TradeRequest del usuario.
     *
     * @return una lista de TradeRequestDTO del usuario
     */
    @Operation(
            summary = "Obtener trades del usuario",
            description = "Retorna una lista de trades del usuario."
    )
    @ApiResponse(responseCode = "200", description = "Lista de trades obtenida con exito.")
    @GetMapping("/my-trades")
    public ResponseEntity<List<TradeRequestDTO>> getUserTrades() {
        return ResponseEntity.ok(tradeService.getTradesForUser());
    }

    /**
     * Actualiza el status de la trade.
     *
     * @return La TradeRequestDTO actualizada
     */
    @Operation(
            summary = "Actualizar status de la trade",
            description = "Retorna la trade actualizada"
    )
    @ApiResponse(responseCode = "200", description = "trade actualizada con exito.")
    @PutMapping("/{id}/change-status")
    public ResponseEntity<TradeRequestDTO> updateStatus(
            @PathVariable Long id, @RequestBody @Valid TradeStatusUpdateDTO status) {
        TradeRequestDTO updated = tradeService.updateStatus(id, status.getStatus());
        return ResponseEntity.ok(updated);
    }
}