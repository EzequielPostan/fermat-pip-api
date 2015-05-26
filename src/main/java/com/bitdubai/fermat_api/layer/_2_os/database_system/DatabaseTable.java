package com.bitdubai.fermat_api.layer._2_os.database_system;

import java.util.List;
import java.util.UUID;

import com.bitdubai.fermat_api.layer._2_os.database_system.exceptions.*;

/**
 *
 *  <p>The abstract class <code>com.bitdubai.fermat_api.layer._2_os.database_system.DatabaseTable</code> is a interface
 *     that define the methods to manage a DatabaseTable object. Set filters and orders, and load records to memory.
 *
 *
 *  @author  Luis
 *  @version 1.0.0
 *  @since  01/01/15.
 * */
public interface DatabaseTable {
    

    public DatabaseTableColumn newColumn();

    public List<String> getColumns();

    public List<DatabaseTableRecord> getRecords();

    public DatabaseTableRecord getEmptyRecord();

    public void clearAllFilters();
    
    public List<DatabaseTableFilter> getFilters();

    public DatabaseTableFilterGroup getFilterGroup();
    
    public void updateRecord (DatabaseTableRecord record) throws CantUpdateRecord;

    public void insertRecord (DatabaseTableRecord record) throws CantInsertRecord;

    public void loadToMemory() throws CantLoadTableToMemory;

    public boolean isTableExists();

    public void setStringFilter(String columnName, String value,DatabaseFilterType type);

    public void setFilterGroup(List<DatabaseTableFilter> filters, List<DatabaseTableFilterGroup> subGroups, DatabaseFilterOperator type);

    public void setUUIDFilter(String columnName, UUID value,DatabaseFilterType type);

    public void setFilterOrder(String columnName, DatabaseFilterOrder direction);

    public void setFilterTop(String top);


}
