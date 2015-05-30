package com.bitdubai.fermat_api.layer._7_crypto_network;

import com.bitdubai.fermat_api.Plugin;

/**
 * Created by ciencias on 30.12.14.
 */
public interface CryptoNetworkSubsystem {
    public void start () throws com.bitdubai.fermat_api.layer._7_crypto_network.bitcoin.exceptions.CantStartSubsystemException;
    public Plugin getPlugin();
}
