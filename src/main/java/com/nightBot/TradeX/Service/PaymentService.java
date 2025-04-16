package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.PaymentMethod;
import com.nightBot.TradeX.Model.PaymentOrder;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Response.PaymentResponse;

public interface PaymentService {
    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProccedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user,
                                              Long Amount,
                                              Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long Amount,
                                            Long orderId) throws StripeException;
}
