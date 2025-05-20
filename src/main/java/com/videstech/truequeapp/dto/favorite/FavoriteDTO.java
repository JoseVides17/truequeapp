package com.videstech.truequeapp.dto.favorite;

import com.videstech.truequeapp.model.Favorite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FavoriteDTO {
    private Long id;
    private Long itemId;
    private String itemTitle;
    private String category;
    private String imageUrl;
    private LocalDateTime fechaAgregado;

    public FavoriteDTO(Favorite favorite){
        this.id = favorite.getId();
        this.itemId = favorite.getItem().getId();
        this.itemTitle = favorite.getItem().getTitle();
        this.category = favorite.getItem().getCategory();
        this.imageUrl = favorite.getItem().getImageUrl();
        this.fechaAgregado = favorite.getFechaAgregado();
    }

}
