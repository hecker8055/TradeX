package com.nightBot.TradeX.Model;


import com.nightBot.TradeX.Domain.WalletTransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class WalletTransaction {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @ManyToOne
    private Wallet wallet;



    private WalletTransactionType type;

    private LocalDate date;

    private String transferId;

    private String  purpose;

    private Long amount;

}
