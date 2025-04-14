package com.nightBot.TradeX.Repository;

import com.nightBot.TradeX.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
