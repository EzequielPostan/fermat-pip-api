package com.bitdubai.fermat_api.layer._2_os;

import com.bitdubai.fermat_api.layer._2_os.database_system.PlatformDatabaseSystem;
import com.bitdubai.fermat_api.layer._2_os.database_system.PluginDatabaseSystem;


/**
 * Created by Natalia on 20/05/2015.
 */
public interface DataBaseSystemOs {

    public PluginDatabaseSystem getPluginDatabaseSystem();

    public PlatformDatabaseSystem getPlatformDatabaseSystem();

    public void setContext (Object context);
}
