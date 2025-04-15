package com.nightBot.TradeX.Request;


import com.nightBot.TradeX.Domain.OrderType;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private   String coinId;
    private  double quantity;
    private OrderType orderType;
}

