/*
 * @#ICoinapultWallet.java - 2015
 * Copyright bitDubai.com., All rights reserved.
  * You may not modify, use, reproduce or distribute this software.
 * BITDUBAI/CONFIDENTIAL
 */
package com.bitdubai.fermat_api.layer._11_world.coinapult.wallet;

import com.bitdubai.fermat_api.layer._11_world.coinapult.exceptions.CantGetAddressesException;
import com.bitdubai.fermat_api.layer._11_world.coinapult.exceptions.CantGetTransactionsException;
import com.bitdubai.fermat_api.layer._11_world.coinapult.exceptions.CantGetWalletBalanceException;

import java.util.List;

/**
 * The interface <code>com.bitdubai.fermat_api.layer._11_world.coinapult.wallet.ICoinapultWallet</code>
 * <p/>
 * Created by Roberto Requena - (rrequena) on 02/05/15.
 *
 * @version 1.0
 */
public interface ICoinapultWallet {

    /**
     * Method responsible for make conversion between two currency
     *
     * @param amount
     * @param currency
     * @param outAmount
     * @param outCurrency
     * @return ICoinapultTransaction
     */
    public ICoinapultTransaction convert(Number amount, String currency, Number outAmount, String outCurrency);

    /**
     * Method  responsible for loading addresses of this wallet
     * @return List<ICoinapultAddress>
     */
    public List<ICoinapultAddress> getAddresses() throws CantGetAddressesException;

    /**
     * Method  responsible for loading the balances of this wallet
     * @return List<ICoinapultBalance>
     */
    public List<ICoinapultBalance> getBalances() throws CantGetWalletBalanceException;

    /**
     * Method  responsible for generate new bitcoin address for this wallet
     * @return List<ICoinapultBalance>
     */
    public ICoinapultAddress generateNewBitCoinAddress();


    /**
     * Method  responsible for LOCK an amount of bitcoin, It provides the stability of asset prices
     * https://coinapult.com/locks/info
     *
     * @param amount
     * @param outAmount
     * @param outCurrency
     * @return ICoinapultTransaction
     */
    public ICoinapultTransaction lock(Number amount, Number outAmount, String outCurrency);

    /**
     * Method  responsible for UNLOCK an amount of bitcoin, to dispose of them and spend
     *
     * @param amount
     * @param inCurrency
     * @param outAmount
     * @param address If specified the amount unlocked will be sent to the given address, otherwise the amount will be credited to your Coinapult wallet.
     *
     * @return ICoinapultTransaction
     */
    public ICoinapultTransaction unlock(Number amount, String inCurrency, Number outAmount, String address);

    /**
     * Method  responsible for send an amount of bitcoin
     *
     * @param amount
     * @param currency
     * @param address
     * @param outAmount
     *
     * @return ICoinapultTransaction
     */
    public ICoinapultTransaction send(Number amount, String currency, String address, Number outAmount);

    /**
     * Method  responsible for receive an amount of bitcoin
     *
     * @param amount
     * @return ICoinapultTransaction
     */
    public ICoinapultTransaction receive(Number amount);

    /**
     * Method  responsible for loading transactions of this wallet
     *
     * @return List<ICoinapultTransaction>
     * @throws com.bitdubai.fermat_api.layer._11_world.coinapult.exceptions.CantGetTransactionsException
     */
    public List<ICoinapultTransaction> getTransactions() throws CantGetTransactionsException;





}
