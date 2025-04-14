package com.nightBot.TradeX.Repository;

import com.nightBot.TradeX.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long>{

    List<Order> findByUserId(Long userId);
}
