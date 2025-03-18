package com.nightBot.TradeX.Request;

import lombok.Data;

@Data
public class ResetPasswordRequest {

    private String otp;
    private String password;
}
