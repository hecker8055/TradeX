package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.VerificationType;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Model.VerificationCode;

public interface VerificationCodeService {

    VerificationCode sendVerificationCode(User user , VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId);



    void deleteVerificationCodeById(VerificationCode verificationCode);

}
