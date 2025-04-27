package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.Order;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Model.Wallet;
import org.springframework.stereotype.Service;


public interface WalletService {
    Wallet getUserWallet(User user);
    Wallet addBalance(Wallet wallet,Long money);
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet,Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws Exception;





}
