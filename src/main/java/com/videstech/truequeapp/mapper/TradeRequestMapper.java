package com.videstech.truequeapp.mapper;

import com.videstech.truequeapp.dto.trade.TradeRequestCreateDTO;
import com.videstech.truequeapp.dto.trade.TradeRequestDTO;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.model.TradeRequest;
import com.videstech.truequeapp.model.enums.TradeStatus;
import com.videstech.truequeapp.model.User;

import java.time.LocalDateTime;

public class TradeRequestMapper {

    public static TradeRequestDTO toDTO(TradeRequest request) {
        if (request == null) return null;

        TradeRequestDTO dto = new TradeRequestDTO();
        dto.setId(request.getId());
        dto.setSenderId(request.getSender().getId());
        dto.setReceiverId(request.getReceiver().getId());
        dto.setItemOfferedId(request.getItemOffered().getId());
        dto.setItemRequestedId(request.getItemRequested().getId());
        dto.setStatus(request.getStatus());
        dto.setCreatedAt(request.getCreatedAt());
        return dto;
    }

    public static TradeRequest toEntity(TradeRequestCreateDTO dto, User sender, User receiver, Item offered, Item requested) {
        if (dto == null) return null;

        TradeRequest request = new TradeRequest();
        request.setSender(sender);
        request.setReceiver(receiver);
        request.setItemOffered(offered);
        request.setItemRequested(requested);
        request.setStatus(TradeStatus.PENDING);
        request.setCreatedAt(LocalDateTime.now());
        return request;
    }
}

