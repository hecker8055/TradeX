package com.nightBot.TradeX.Model;


import com.nightBot.TradeX.Domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ForgotPasswordToken {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


    @OneToOne
    private User user;

    private String otp;

    private VerificationType verificationType;

    private String sendTo;




}
