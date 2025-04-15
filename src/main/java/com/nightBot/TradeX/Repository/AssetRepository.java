package com.nightBot.TradeX.Repository;

import com.nightBot.TradeX.Model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {
     List<Asset> findByUserId(Long userId);

    Asset findByUserIdAndCoinId(Long userId, String coinId);

    Asset findByIdAndUserId(Long assetId, Long userId);
}
