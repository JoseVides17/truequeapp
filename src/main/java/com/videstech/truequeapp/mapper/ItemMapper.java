package com.videstech.truequeapp.mapper;

import com.videstech.truequeapp.dto.item.ItemCreateDTO;
import com.videstech.truequeapp.dto.item.ItemDTO;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.model.User;

import java.time.LocalDateTime;

public class ItemMapper {

    public static ItemDTO toDTO(Item item) {
        if (item == null) return null;

        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setTitle(item.getTitle());
        dto.setDescription(item.getDescription());
        dto.setType(item.getType());
        dto.setCategory(item.getCategory());
        dto.setImageUrl(item.getImageUrl());
        dto.setIsAvailable(item.getIsAvailable());
        dto.setCreatedAt(item.getCreatedAt());
        dto.setOwnerId(item.getOwner() != null ? item.getOwner().getId() : null);
        return dto;
    }

    public static Item toEntity(ItemCreateDTO dto, User owner) {
        if (dto == null) return null;

        Item item = new Item();
        item.setTitle(dto.getTitle());
        item.setDescription(dto.getDescription());
        item.setType(dto.getType());
        item.setCategory(dto.getCategory());
        item.setImageUrl(dto.getImageUrl());
        item.setIsAvailable(true);
        item.setCreatedAt(LocalDateTime.now());
        item.setOwner(owner);
        return item;
    }
}

