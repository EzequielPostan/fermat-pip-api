package com.bitdubai.fermat_api.layer._2_os.device_location;

/**
 * Created by Natalia on 30/04/2015.
 */
public interface Location {

    public double getLatitude();

    public double getLongitude();

    public void setLatitude (double lat);

    public void setLongitude (double lng);
}
