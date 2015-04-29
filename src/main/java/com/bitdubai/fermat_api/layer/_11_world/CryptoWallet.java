package com.bitdubai.fermat_api.layer._11_world;

import com.bitdubai.fermat_api.layer._11_world.blockchain_info.exceptions.CantGetAddressBalanceException;
import com.bitdubai.fermat_api.layer._11_world.blockchain_info.exceptions.CantGetAddressesException;
import com.bitdubai.fermat_api.layer._11_world.blockchain_info.exceptions.CantGetNewAddressException;
import com.bitdubai.fermat_api.layer._11_world.blockchain_info.exceptions.CantGetWalletBalanceException;
import com.bitdubai.fermat_api.layer._11_world.blockchain_info.exceptions.CantSendCryptoException;
import com.bitdubai.fermat_api.layer._11_world.blockchain_info.exceptions.CantStartBlockchainInfoWallet;
import com.bitdubai.fermat_api.layer._1_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_api.layer._1_definition.money.CryptoAddress;

import java.util.List;
import java.util.UUID;

/**
 * Created by ciencias on 3/12/15.
 */
public interface CryptoWallet {


    public void start() throws CantStartBlockchainInfoWallet;

    public void stop();

    public long getWalletBalance(CryptoCurrency cryptoCurrency) throws CantGetWalletBalanceException;

    public long getAddressBalance(CryptoAddress cryptoAddress) throws CantGetAddressBalanceException;

    // to get all the addresses in a wallet
    public List<CryptoAddress> getAddresses() throws CantGetAddressesException;

    // to create new address in a wallet
    public CryptoAddress getNewAddress() throws CantGetNewAddressException;

    // added CryptoAddressFrom to choose the address where i sending from in my wallet
    // can be null, and the method haves to use the first or primary address in wallet
    public void sendCrypto (CryptoAddress cryptoAddressFrom, CryptoCurrency cryptoCurrency, long amount, CryptoAddress cryptoAddressTo) throws CantSendCryptoException;

}