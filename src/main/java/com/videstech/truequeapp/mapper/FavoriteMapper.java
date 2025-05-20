package com.videstech.truequeapp.mapper;

import com.videstech.truequeapp.dto.favorite.FavoriteDTO;
import com.videstech.truequeapp.model.Favorite;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FavoriteMapper {
    public FavoriteDTO toDTO(Favorite favorite) {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setId(favorite.getId());
        dto.setItemId(favorite.getItem().getId());
        dto.setItemTitle(favorite.getItem().getTitle());
        dto.setCategory(favorite.getItem().getCategory());
        dto.setImageUrl(favorite.getItem().getImageUrl());
        dto.setFechaAgregado(favorite.getFechaAgregado());
        return dto;
    }

    public List<FavoriteDTO> toDTOList(List<Favorite> favorites) {
        return favorites.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
