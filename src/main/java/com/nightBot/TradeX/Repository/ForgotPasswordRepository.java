package com.nightBot.TradeX.Repository;

import com.nightBot.TradeX.Model.ForgotPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgotPasswordRepository  extends JpaRepository<ForgotPasswordToken, String> {

    ForgotPasswordToken findByUserId(Long userId);


}
