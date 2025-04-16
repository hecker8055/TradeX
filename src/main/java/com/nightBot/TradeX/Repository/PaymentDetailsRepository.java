package com.nightBot.TradeX.Repository;

import com.nightBot.TradeX.Model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long> {
    PaymentDetails getPaymentDetailsByUserId(Long userId);
}
