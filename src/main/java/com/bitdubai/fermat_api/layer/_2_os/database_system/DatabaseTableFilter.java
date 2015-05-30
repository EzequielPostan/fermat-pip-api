package com.bitdubai.fermat_api.layer._2_os.database_system;

/**
 *
 *  <p>The abstract class <code>com.bitdubai.fermat_api.layer._2_os.database_system.DatabaseTableFilter</code> is a interface
 *     that define methods to sets the columns that were used to make the filter on a table.
 *
 *
 *  @author  Luis
 *  @version 1.0.0
 *  @since  01/02/15.
 * */
public interface DatabaseTableFilter {
    
    
    public void setColumn (String column);

    public void setType (DatabaseFilterType type);

    public void setValue (String value);

    public String  getColumn ();

    public String getValue ();

    public DatabaseFilterType getType ();
    
}
