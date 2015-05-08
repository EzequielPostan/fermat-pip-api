package com.bitdubai.fermat_api.layer._2_os.device_connectivity;

/**
 * Created by Natalia on 08/05/2015.
 */
public interface ConnectivityMonitor {

    public void start();

    public void stop();

    public Network getConnectionInfo();
}
