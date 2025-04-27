package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Domain.PaymentMethod;
import com.nightBot.TradeX.Model.PaymentOrder;
import com.nightBot.TradeX.Model.User;
import com.nightBot.TradeX.Response.PaymentResponse;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {
    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProccedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId) throws RazorpayException, RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user,
                                              Long amount,
                                              Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long amount,
                                            Long orderId) throws StripeException;
}
