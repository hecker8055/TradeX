package com.nightBot.TradeX.Request;


import com.nightBot.TradeX.Domain.VerificationType;
import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private  String sendTo;

    private VerificationType verificationType;
}
