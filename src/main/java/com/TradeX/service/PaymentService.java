package com.TradeX.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.TradeX.domain.PaymentMethod;
import com.TradeX.model.PaymentOrder;
import com.TradeX.model.User;
import com.TradeX.response.PaymentResponse;

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
