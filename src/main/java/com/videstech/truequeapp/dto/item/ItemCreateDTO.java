package com.videstech.truequeapp.dto.item;

import com.videstech.truequeapp.model.enums.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemCreateDTO {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private ItemType type;

    private String category;

    private String imageUrl;

}
