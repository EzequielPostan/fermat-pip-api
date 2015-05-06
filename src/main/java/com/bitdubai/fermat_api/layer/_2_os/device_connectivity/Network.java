package com.bitdubai.fermat_api.layer._2_os.device_connectivity;

/**
 * Created by Natalia on 06/05/2015.
 */
public interface Network {

    public ConnectionType getType();

    public boolean getIsConnected();

    public void setType(ConnectionType type);

    public void setIsConnected(boolean connected);
}
