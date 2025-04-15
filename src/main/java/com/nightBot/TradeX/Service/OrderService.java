package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.OrderType;
import com.nightBot.TradeX.Model.Coin;
import com.nightBot.TradeX.Model.Order;
import com.nightBot.TradeX.Model.OrderItem;
import com.nightBot.TradeX.Model.User;

import java.util.List;

public interface  OrderService {

    Order createOrder(User user , OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;



    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol);

    Order  processOrder(Coin coin, double  quantity , OrderType orderType, User user) throws Exception;



}
