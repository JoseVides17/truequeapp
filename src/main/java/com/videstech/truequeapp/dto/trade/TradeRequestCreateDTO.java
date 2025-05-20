package com.videstech.truequeapp.dto.trade;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TradeRequestCreateDTO {

    @NotNull
    private Long itemOfferedId;

    @NotNull
    private Long itemRequestedId;

}
