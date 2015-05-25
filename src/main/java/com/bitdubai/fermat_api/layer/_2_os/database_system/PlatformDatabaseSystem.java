package com.bitdubai.fermat_api.layer._2_os.database_system;

import com.bitdubai.fermat_api.layer._2_os.database_system.exceptions.CantCreateDatabaseException;
import com.bitdubai.fermat_api.layer._2_os.database_system.exceptions.DatabaseNotFoundException;
import com.bitdubai.fermat_api.layer._2_os.file_system.exceptions.CantOpenDatabaseException;



/**
 * Created by ciencias on 3/18/15.
 */

/**
 *
 *  <p>The abstract class <code>com.bitdubai.fermat_api.layer._2_os.database_system.PlatformDatabaseSystem</code> is a interface
 *     that define the methods to manage database system. Used from PlugIn
 *     The Database System knows which databases are already accessible on this device.
 *
 *
 *  @author  Luis
 *  @version 1.0.0
 *  @since   18/01/15.
 * */

 public interface PlatformDatabaseSystem {

    public Database openDatabase(String databaseName) throws CantOpenDatabaseException, DatabaseNotFoundException;

    public Database createDatabase (String databaseName) throws CantCreateDatabaseException;

    public void deleteDatabase(String databaseName) throws CantOpenDatabaseException, DatabaseNotFoundException;

    void setContext (Object context);
}
