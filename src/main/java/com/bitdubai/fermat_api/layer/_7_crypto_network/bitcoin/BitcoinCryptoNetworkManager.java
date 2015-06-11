package com.bitdubai.fermat_api.layer._7_crypto_network.bitcoin;

import com.bitdubai.fermat_api.layer._8_crypto_vault.CryptoVault;

/**
 * Created by rodrigo on 10/06/15.
 */
public interface BitcoinCryptoNetworkManager {
    public void setVault (CryptoVault cryptoVault);
    public void connectToBitcoinNetwork();
    public void disconnectFromBitcoinNetwork();
}
