package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.TwoFactorOTP;
import com.nightBot.TradeX.Model.User;

public interface TwoFactorOtpService {

      TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt);

      TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean  verifyTwoFactorOtp(TwoFactorOTP twoFactorOtp,String otp);

    void  deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);



}
