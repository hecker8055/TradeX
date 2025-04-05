package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.OrderType;
import com.nightBot.TradeX.Model.Order;
import com.nightBot.TradeX.Model.OrderItem;
import com.nightBot.TradeX.Model.User;

public interface  OrderService {

    Order createOrder(User user , OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId);
}
