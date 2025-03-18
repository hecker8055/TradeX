package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.VerificationCode;

public interface VerificationCodeService {

    VerificationCode sendVerificationCode(VerificationCode verificationCode);

    VerificationCode getVerificationCodeById(Long Id);

    VerificationCode getVerificationCodeByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);

}
