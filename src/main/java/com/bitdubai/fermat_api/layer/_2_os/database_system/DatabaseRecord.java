package com.bitdubai.fermat_api.layer._2_os.database_system;

/**
 *
 *  <p>The abstract class <code>com.bitdubai.fermat_api.layer._2_os.database_system.DatabaseRecord</code> is a interface
 *     that define the methods to access the properties of the object Database Record.
 *
 *
 *  @author  Natalia
 *  @version 1.0.0
 *  @since   25/03/2015.
 * */

 public interface DatabaseRecord {

    public String getName();

    public String getValue();

    public boolean getChange();

    public void setName (String name);

    public void setValue (String value);

    public void setChange (boolean change);

}
