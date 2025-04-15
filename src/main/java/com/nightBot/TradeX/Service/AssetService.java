package com.nightBot.TradeX.Service;

import com.nightBot.TradeX.Model.Asset;
import com.nightBot.TradeX.Model.Coin;
import com.nightBot.TradeX.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AssetService {
    Asset createAsset(User user,Coin coin ,double quantity);

    Asset getAssetById(Long assetId) throws Exception;

    Asset getAssetByUserAndId(Long userId,Long assetId);

    List<Asset> getUsersAssets(Long userId);

    Asset updateAsset(Long assetId,double quantity) throws Exception;

    Asset findAssetByUserIdAndCoinId(Long userId,String coinId) throws Exception;

    void deleteAsset(Long assetId);

}
