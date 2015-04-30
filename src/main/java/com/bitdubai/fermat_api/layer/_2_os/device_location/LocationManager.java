package com.bitdubai.fermat_api.layer._2_os.device_location;

import com.bitdubai.fermat_api.layer._2_os.device_location.Location;
/**
 * Created by Natalia on 30/04/2015.
 */
public interface LocationManager {

    public Location getLocation();

    public void setContext (Object context);
}
