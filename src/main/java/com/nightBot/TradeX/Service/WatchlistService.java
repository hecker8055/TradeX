package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.Coin;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Model.Watchlist;

public interface WatchlistService {
    Watchlist findUserWatchlist(Long userId) throws Exception;

    Watchlist createWatchList(User user);

    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
