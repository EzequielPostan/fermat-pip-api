package com.bitdubai.fermat_api.layer._2_os.device_connectivity;

import com.bitdubai.fermat_api.CantGetActiveConnectionException;
import com.bitdubai.fermat_api.CantGetConnectionsException;
import com.bitdubai.fermat_api.CantGetIsConnectedException;

import java.util.List;

/**
 * Created by Natalia on 04/05/2015.
 */
public interface ConnectivityManager {

    public List<Network> getConnections() throws CantGetConnectionsException;

    public Network getActiveConnection() throws CantGetActiveConnectionException;

    public boolean isConnected(ConnectionType redType) throws CantGetIsConnectedException;

    public void setContext (Object context);
}
