package tables;

import Database.DBConst;
import Database.Database;
import daos.GuestsDAO;
import pojo.Guests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GuestsTable implements GuestsDAO {
    Database db = Database.getInstance();
    ArrayList<Guests> guests;

    @Override
    public ArrayList<Guests> getAllGuests() {
        String query = "SELECT * FROM " + DBConst.TABLE_GUESTS;
        try{
            Statement getGuests = db.getConnection().createStatement();
            ResultSet data = getGuests.executeQuery(query);

            while(data.next()){
                guests.add(new Guests(data.getInt(DBConst.GUESTS_COLUMN_ID),
                                      data.getInt(DBConst.GUESTS_COLUMN_NUMBER)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return guests;
    }

    @Override
    public Guests getGuest(int guestId) {
        String query = "SELECT * FROM " + DBConst.TABLE_GUESTS+
                " WHERE " + DBConst.GUESTS_COLUMN_ID + " = " + guestId;
        try{
            Statement getGuests =
                    db.getConnection().createStatement();
            ResultSet data = getGuests.executeQuery(query);
            if(data.next()){
                Guests guest =
                        new Guests(data.getInt(DBConst.GUESTS_COLUMN_ID),
                                data.getInt(DBConst.GUESTS_COLUMN_NUMBER));
                return guest;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
