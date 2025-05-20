package com.videstech.truequeapp.service.trade;

import com.videstech.truequeapp.dto.trade.TradeRequestCreateDTO;
import com.videstech.truequeapp.dto.trade.TradeRequestDTO;
import com.videstech.truequeapp.dto.trade.TradeStatusUpdateDTO;
import com.videstech.truequeapp.mapper.TradeRequestMapper;
import com.videstech.truequeapp.model.Item;
import com.videstech.truequeapp.model.TradeRequest;
import com.videstech.truequeapp.model.enums.TradeStatus;
import com.videstech.truequeapp.model.User;
import com.videstech.truequeapp.repository.ItemRepository;
import com.videstech.truequeapp.repository.TradeRequestRepository;
import com.videstech.truequeapp.repository.UserRepository;
import com.videstech.truequeapp.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {
    private final TradeRequestRepository tradeRepo;
    private final ItemRepository itemRepository;
    private final UserServiceImpl userServiceimpl;

    @Override
    public TradeRequestDTO create(TradeRequestCreateDTO dto) {
        User authenticatedUser = userServiceimpl.getAuthenticatedUser();
        Item itemOffered = itemRepository.findById(dto.getItemOfferedId()).orElseThrow(() -> new RuntimeException("ItemOffered not found"));
        Item itemRequested = itemRepository.findById(dto.getItemRequestedId()).orElseThrow(() -> new RuntimeException("ItemRequested not found"));
        if(!itemOffered.getOwner().getId().equals(authenticatedUser.getId())) {
            throw new RuntimeException("El item no pertenece al usuario autenticado");
        }
        if(itemRequested.getOwner().getId().equals(authenticatedUser.getId())) {
            throw new RuntimeException("No puedes solicitar tu propio item");
        }
        TradeRequest tradeRequest = TradeRequestMapper.toEntity(dto, authenticatedUser, itemRequested.getOwner(), itemOffered, itemRequested);
        TradeRequest saved = tradeRepo.save(tradeRequest);
        return TradeRequestMapper.toDTO(saved);
    }

    @Override
    public List<TradeRequestDTO> getTradesForUser() {
        User user = userServiceimpl.getAuthenticatedUser();
        return tradeRepo.findBySenderIdOrReceiverId(user.getId(), user.getId())
                .stream()
                .map(TradeRequestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TradeRequestDTO updateStatus(Long id, TradeStatus status) {
        TradeRequest tr = tradeRepo.findById(id).orElseThrow(() -> new RuntimeException("Trade not found"));
        User currentUser = userServiceimpl.getAuthenticatedUser();
        if (!tr.getReceiver().getId().equals(currentUser.getId())){
            throw new RuntimeException("Solo el receptor puede modificar el intercambio");
        }
        if (tr.getStatus() != TradeStatus.PENDING){
            throw new RuntimeException("No se puede cambiar el estado de un intercambio que no esta pendiente");
        }
        tr.setStatus(status);
        tradeRepo.save(tr);
        return TradeRequestMapper.toDTO(tr);
    }
}

