package tables;

import Database.DBConst;
import Database.Database;
import daos.TableNumDAO;
import pojo.TableNumber;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * TableNumTable Class -- Represents the table numbers
 * This class implements the TableNumDAO
 * therefore, has access to methods that access an arrayList of tableNums, as well as each individual tableNum
 * These methods are useful when accessing all records in the TableNumber table or individual records (by ID)

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 24th 2020
 */
public class TableNumTable implements TableNumDAO {
    //properties
    Database db = Database.getInstance();
    ArrayList<TableNumber> tableNumbers;

    /**
     * The purpose of this method is to retrieve all records from the TableNumber table and store them into an arraylist
     * @return Returns an arrayList of table numbers
     */
    @Override
    public ArrayList<TableNumber> getAllTableNumbers() {
        String query = "SELECT * FROM " + DBConst.TABLE_NUMBER_TABLE;
        tableNumbers = new ArrayList<TableNumber>();
        try{
            Statement getTableNumbers = db.getConnection().createStatement();
            ResultSet data = getTableNumbers.executeQuery(query);

            while(data.next()){
                tableNumbers.add(
                        new TableNumber(
                                data.getInt(DBConst.TABLE_NUMBER_COLUMN_ID), //id
                                data.getInt(DBConst.TABLE_NUMBER_COLUMN_NUMBER))); //table number
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tableNumbers;
    }

    /**
     * The purpose of this method is to retrieve a specific record from the TableNumber table
     * @param tableId corresponding id to the item to be retrieved
     * @return Returns a TableNum object or null if the table_number did not exist in the database
     */
    @Override
    public TableNumber getTableNumber(int tableId) {
        String query = "SELECT * FROM " + DBConst.TABLE_NUMBER_TABLE+
                " WHERE " + DBConst.TABLE_NUMBER_COLUMN_ID + " = " + tableId;
        try{
            Statement getTableNumbers =
                    db.getConnection().createStatement();
            ResultSet data = getTableNumbers.executeQuery(query);
            if(data.next()){
                TableNumber tableNumber =
                        new TableNumber(data.getInt(DBConst.TABLE_NUMBER_COLUMN_ID),
                                data.getInt(DBConst.TABLE_NUMBER_COLUMN_NUMBER));
                return tableNumber;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTableCount(int tableID){
        int count = -1;

        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + DBConst.TABLE_RESERVATIONS + " WHERE "
                                    + DBConst.RESERVATIONS_COLUMN_TABLE + " = '" + tableID + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;

    }
}
