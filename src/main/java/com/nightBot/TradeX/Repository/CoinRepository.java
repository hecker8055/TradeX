package com.nightBot.TradeX.Repository;

import com.nightBot.TradeX.Model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin,String> {


}
