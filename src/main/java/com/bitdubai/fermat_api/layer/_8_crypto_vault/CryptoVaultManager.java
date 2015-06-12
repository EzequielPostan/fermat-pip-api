package com.bitdubai.fermat_api.layer._8_crypto_vault;

import com.bitdubai.fermat_api.layer._1_definition.money.CryptoAddress;

import java.util.List;
import java.util.UUID;

/**
 * Created by rodrigo on 11/06/15.
 */
public interface CryptoVaultManager {
    public void setUserId (UUID UserId);
    public void connectToBitcoin();
    public void disconnectFromBitcoin();
    public String getAddress();
    public List<String> getAddresses(int amount);
}
