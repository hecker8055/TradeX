package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.VerificationType;
import com.nightBot.TradeX.Model.ForgotPasswordToken;
import com.nightBot.TradeX.Model.User;

public interface ForgotPasswordService {

    ForgotPasswordToken  createToken (User user,
                                      String id,
                                      String otp,
                                      VerificationType verificationType,String sendTo);

    ForgotPasswordToken findById(String id);
    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);

}
