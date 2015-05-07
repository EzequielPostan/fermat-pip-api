package com.bitdubai.fermat_api.layer._15_transaction.incoming_crypto;

import com.bitdubai.fermat_api.layer._15_transaction.TransactionManager;

/**
 * Created by loui on 18/03/15.
 */
public interface IncomingCryptoManager {

    public Registry getRegistry();

    public TransactionManager getTransactionManager();

}
