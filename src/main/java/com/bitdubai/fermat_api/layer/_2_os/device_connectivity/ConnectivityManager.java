package com.bitdubai.fermat_api.layer._2_os.device_connectivity;

/**
 * Created by Natalia on 04/05/2015.
 */
public interface ConnectivityManager {

    public ConnectionType getConnectionType();

    public ConnectionCapacity getConnectionIntensity();

    public boolean isConnected(ConnectionType redType);

    public void setContext (Object context);
}
