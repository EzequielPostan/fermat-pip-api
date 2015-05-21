package com.bitdubai.fermat_api.layer._2_os.location_system;

import com.bitdubai.fermat_api.layer._2_os.location_system.exceptions.CantGetDeviceLocationException;

/**
 * Created by Natalia on 30/04/2015.
 */
public interface LocationManager {

    public Location getLocation() throws CantGetDeviceLocationException;

    public void setContext (Object context);


}
