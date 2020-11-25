package tables;

import Database.DBConst;
import Database.Database;
import daos.TableNumDAO;
import pojo.TableNumber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableNumTable implements TableNumDAO {
    Database db = Database.getInstance();
    ArrayList<TableNumber> tableNumbers;

    @Override
    public ArrayList<TableNumber> getAllTableNumbers() {
        String query = "SELECT * FROM " + DBConst.TABLE_NUMBER_TABLE;
        try{
            Statement getTableNumbers = db.getConnection().createStatement();
            ResultSet data = getTableNumbers.executeQuery(query);

            while(data.next()){
                tableNumbers.add(new TableNumber(data.getInt(DBConst.TABLE_NUMBER_COLUMN_ID),
                        data.getInt(DBConst.TABLE_NUMBER_COLUMN_NUMBER)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tableNumbers;
    }

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
}
