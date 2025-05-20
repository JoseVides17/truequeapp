package com.videstech.truequeapp.service.Item;

import com.videstech.truequeapp.dto.item.ItemCreateDTO;
import com.videstech.truequeapp.dto.item.ItemDTO;
import com.videstech.truequeapp.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<ItemDTO> findAll();
    ItemDTO create(ItemCreateDTO dto);
    ItemDTO getById(Long id);
    void delete(Long id);

}
