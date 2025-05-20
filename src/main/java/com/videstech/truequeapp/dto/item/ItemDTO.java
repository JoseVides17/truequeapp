package com.videstech.truequeapp.dto.item;

import com.videstech.truequeapp.model.enums.ItemType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDTO {
    private Long id;
    private String title;
    private String description;
    private ItemType type;
    private String category;
    private String imageUrl;
    private Boolean isAvailable;
    private LocalDateTime createdAt;
    private Long ownerId;
}

