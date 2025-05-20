package com.videstech.truequeapp.controller;

import com.videstech.truequeapp.dto.review.ReviewCreateDTO;
import com.videstech.truequeapp.dto.review.ReviewDTO;
import com.videstech.truequeapp.model.Review;
import com.videstech.truequeapp.service.review.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    /**
     * Crea una nueva review.
     *
     * @return una ReviewDTO.
     */
    @Operation(
            summary = "crear una review",
            description = "Retorna la review creada"
    )
    @ApiResponse(responseCode = "201", description = "Review creada con exito.")
    @PostMapping
    public ResponseEntity<ReviewDTO> create(@RequestBody @Valid ReviewCreateDTO dto) {
        ReviewDTO created = reviewService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Obtiene una lista de reviews del usuario.
     *
     * @return una lista de ReviewDTO
     */
    @Operation(
            summary = "Obtener Reviews del usuario",
            description = "Retorna una lista de Reviews"
    )
    @ApiResponse(responseCode = "200", description = "Lista de reviews obtenida con exito.")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsForUser(userId));
    }
}