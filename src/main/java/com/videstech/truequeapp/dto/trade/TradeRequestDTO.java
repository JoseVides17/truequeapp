package com.videstech.truequeapp.dto.trade;

import com.videstech.truequeapp.model.enums.TradeStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TradeRequestDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private Long itemOfferedId;
    private Long itemRequestedId;
    private TradeStatus status;
    private LocalDateTime createdAt;
}
