package com.videstech.truequeapp.repository;

import com.videstech.truequeapp.model.TradeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRequestRepository extends JpaRepository<TradeRequest, Long> {
    List<TradeRequest> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
}
