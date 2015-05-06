package com.bitdubai.fermat_api.layer._2_os.device_connectivity;

import java.util.List;

/**
 * Created by Natalia on 04/05/2015.
 */
public interface ConnectivityManager {

    public List<Network> getConnections();

    public Network getActiveConnection();

    public ConnectionCapacity getConnectionIntensity();

    public boolean isConnected(ConnectionType redType);

    public void setContext (Object context);
}
