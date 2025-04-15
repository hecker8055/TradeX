package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Model.Withdrawal;

import java.util.List;

public interface WithdrawalService {


    Withdrawal requestWithdrawal(Long amount, User user);
    Withdrawal procedWithdrawal(Long withdrawalId,boolean accept) throws Exception;
    List<Withdrawal> getUsersWithdrawalHistory(User user);
    List<Withdrawal> getAllWithdrawalRequest();
}
