package com.videstech.truequeapp.repository;

import com.videstech.truequeapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByOwnerId(Long id);
}
