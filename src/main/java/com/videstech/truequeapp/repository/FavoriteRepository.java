package com.videstech.truequeapp.repository;

import com.videstech.truequeapp.dto.favorite.FavoriteDTO;
import com.videstech.truequeapp.model.Favorite;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByUserAndItem(User user, Item item);
    List<Favorite> findAllByUser(User user);
    void deleteByUserIdAndItemId(Long userId, Long itemId);
}
