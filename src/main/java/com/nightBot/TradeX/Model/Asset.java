package com.nightBot.TradeX.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data


public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;
    private double buyPrice;

    @ManyToOne
    private Coin coin;



    @ManyToOne
    private User user;
}
