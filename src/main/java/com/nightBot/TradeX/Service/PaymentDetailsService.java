package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.PaymentDetails;
import com.nightBot.TradeX.Model.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user
    );

    public PaymentDetails getUsersPaymentDetails(User user);

}
