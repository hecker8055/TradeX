package com.TradeX.service;

import com.TradeX.model.CoinDTO;
import com.TradeX.response.ApiResponse;

public interface ChatBotService {
    ApiResponse getCoinDetails(String coinName);

    CoinDTO getCoinByName(String coinName);

    String simpleChat(String prompt);
}
