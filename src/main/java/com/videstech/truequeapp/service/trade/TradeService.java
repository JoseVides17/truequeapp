package com.videstech.truequeapp.service.trade;

import com.videstech.truequeapp.dto.trade.TradeRequestCreateDTO;
import com.videstech.truequeapp.dto.trade.TradeRequestDTO;
import com.videstech.truequeapp.dto.trade.TradeStatusUpdateDTO;
import com.videstech.truequeapp.model.enums.TradeStatus;

import java.util.List;

public interface TradeService {
    TradeRequestDTO create(TradeRequestCreateDTO dto);
    List<TradeRequestDTO> getTradesForUser();
    TradeRequestDTO updateStatus(Long id, TradeStatus status);
}

