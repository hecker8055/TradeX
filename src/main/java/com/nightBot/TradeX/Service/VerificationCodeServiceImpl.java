package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.VerificationType;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Model.VerificationCode;
import com.nightBot.TradeX.Repository.UserRepository;
import com.nightBot.TradeX.Repository.VerificationCodeRepository;
import com.nightBot.TradeX.Utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {


    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Override
    public VerificationCode sendVerificationCode(User user , VerificationType verificationType) {
        VerificationCode verificationCode1 = new VerificationCode();
        verificationCode1.setOtp(OtpUtils.generateOTP());
        verificationCode1.setVerificationType(verificationType);
        verificationCode1.setUser(user);

        return verificationCodeRepository.save(verificationCode1);
    }



    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {
        Optional<VerificationCode> verificationCode = verificationCodeRepository.findById(id);
        if(verificationCode.isPresent()){
            verificationCode.get();
        }
        throw  new Exception("verification code not found");


    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long userId) {
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {
       verificationCodeRepository.delete(verificationCode);
    }
}
