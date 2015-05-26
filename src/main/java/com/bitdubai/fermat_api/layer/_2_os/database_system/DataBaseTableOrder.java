package com.bitdubai.fermat_api.layer._2_os.database_system;

/**
 *
 *  <p>The abstract class <code>com.bitdubai.fermat_api.layer._2_os.database_system.DataBaseTableOrder</code> is a interface
 *     that define the methods to set and get the query filter order.
 *
 *
 *  @author  Natalia
 *  @version 1.0.0
 *  @since  27/03/15.
 * */

 public interface DataBaseTableOrder {

    public void setColumName (String column);

    public void setDirection (DatabaseFilterOrder direction);

    public String getColumName ();

    public DatabaseFilterOrder getDirection ();
}
