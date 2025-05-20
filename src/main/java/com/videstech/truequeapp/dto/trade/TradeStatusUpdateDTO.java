package com.videstech.truequeapp.dto.trade;

import com.videstech.truequeapp.model.enums.TradeStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TradeStatusUpdateDTO {

    @NotNull
    private TradeStatus status;

}
