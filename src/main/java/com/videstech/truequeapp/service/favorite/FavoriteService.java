package com.videstech.truequeapp.service.favorite;

import com.videstech.truequeapp.dto.favorite.FavoriteDTO;
import com.videstech.truequeapp.mapper.FavoriteMapper;
import com.videstech.truequeapp.model.Favorite;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.model.User;
import com.videstech.truequeapp.repository.FavoriteRepository;
import com.videstech.truequeapp.repository.ItemRepository;
import com.videstech.truequeapp.repository.UserRepository;
import com.videstech.truequeapp.service.user.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ItemRepository itemRepository;
    private final UserServiceImpl userServiceImpl;
    private final FavoriteMapper favoriteMapper;

    public FavoriteDTO addFavorite(Long itemId) {
        User user = userServiceImpl.getAuthenticatedUser();
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item no encontrado"));

        if (favoriteRepository.findByUserAndItem(user, item).isPresent()) {
            throw new RuntimeException("El ítem ya está en favoritos.");
        }
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setItem(item);
        favorite.setFechaAgregado(LocalDateTime.now());
        favoriteRepository.save(favorite);
        return favoriteMapper.toDTO(favorite);
    }

    public void removeFavorite(Long itemId) {
        User user = userServiceImpl.getAuthenticatedUser();
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item no encontrado"));
        favoriteRepository.deleteByUserIdAndItemId(user.getId(), item.getId());
    }

    public List<FavoriteDTO> getFavorites() {
        User user = userServiceImpl.getAuthenticatedUser();
        List<Favorite> favorites = favoriteRepository.findAllByUser(user);
        return favoriteMapper.toDTOList(favorites);
    }
}

