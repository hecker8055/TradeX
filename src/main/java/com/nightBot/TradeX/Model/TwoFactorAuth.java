package com.nightBot.TradeX.Model;

import com.nightBot.TradeX.Domain.VerificationType;

import lombok.Data;

@Data
public class TwoFactorAuth {

    private boolean isEnabled = false;
    private VerificationType sendTo;
}
