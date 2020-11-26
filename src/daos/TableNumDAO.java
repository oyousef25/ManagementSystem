package daos;

import pojo.TableNumber;

import java.util.ArrayList;

/**
 * Table Number DAO(Data Access Object) helps us:
 * 1. access all Table Numbers
 * 2. access a single Table Number
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 20th NOV 2020
 */
public interface TableNumDAO {
    /**
     * A function to return all Table Numbers
     * @return
     */
    public ArrayList<TableNumber> getAllTableNumbers();

    /**
     * A function to return a single Table Number
     * @param tableId
     * @return
     */
    public TableNumber getTableNumber(int tableId);
}
