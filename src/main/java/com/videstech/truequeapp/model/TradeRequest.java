package com.videstech.truequeapp.model;

import com.videstech.truequeapp.model.enums.TradeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    @ManyToOne
    private Item itemOffered;

    @ManyToOne
    private Item itemRequested;

    @Enumerated(EnumType.STRING)
    private TradeStatus status;

    private LocalDateTime createdAt = LocalDateTime.now();

}
