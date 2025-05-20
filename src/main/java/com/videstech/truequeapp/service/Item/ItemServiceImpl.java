package com.videstech.truequeapp.service.Item;

import com.videstech.truequeapp.dto.item.ItemCreateDTO;
import com.videstech.truequeapp.dto.item.ItemDTO;
import com.videstech.truequeapp.mapper.ItemMapper;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.model.User;
import com.videstech.truequeapp.repository.ItemRepository;
import com.videstech.truequeapp.repository.UserRepository;
import com.videstech.truequeapp.service.user.UserService;
import com.videstech.truequeapp.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final UserServiceImpl userServiceImpl;
    private final ItemRepository itemRepository;

    @Override
    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream().map(ItemMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO create(ItemCreateDTO dto) {
        User owner = userServiceImpl.getAuthenticatedUser();
        Item item = ItemMapper.toEntity(dto, owner);
        Item seved = itemRepository.save(item);
        return ItemMapper.toDTO(seved);
    }

    @Override
    public ItemDTO getById(Long id) {
        return itemRepository.findById(id).map(ItemMapper::toDTO).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public void delete(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found");
        }
        itemRepository.deleteById(id);
    }



}
