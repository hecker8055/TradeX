package com.nightBot.TradeX.Model;


import com.nightBot.TradeX.Domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String otp;

    @OneToOne
    private User user;


    private String email;

    private String mobile;

    private VerificationType verificationType;


}
