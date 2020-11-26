package tables;

import Database.DBConst;
import Database.Database;
import daos.GuestsDAO;
import pojo.Guests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Guests Table Class -- Represents the number of guests
 * This class implements the GuestsDAO
 * therefore, has access to methods that access an arrayList of guests, as well as each individual guest
 * These methods are useful when accessing all records in the Guests table or individual records (by ID)

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 24th 2020
 */
public class GuestsTable implements GuestsDAO {
    //properties
    Database db = Database.getInstance();
    ArrayList<Guests> guests;


    /**
     * The purpose of this method is to retrieve all records from the Guests table and store them into an arraylist
     * @return Returns an arrayList of guests
     */
    @Override
    public ArrayList<Guests> getAllGuests() {
        String query = "SELECT * FROM " + DBConst.TABLE_GUESTS;
        try{
            Statement getGuests = db.getConnection().createStatement();
            ResultSet data = getGuests.executeQuery(query);

            while(data.next()){
                guests.add(new Guests(data.getInt(DBConst.GUESTS_COLUMN_ID),//id
                                      data.getInt(DBConst.GUESTS_COLUMN_NUMBER))); //number of guests
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return guests;
    }

    /**
     * The purpose of this method is to retrieve a specific record from the Guests table
     * @param guestId corresponding id to the item to be retrieved
     * @return Returns a guest object or null if the guest_num did not exist in the database
     */
    @Override
    public Guests getGuest(int guestId) {
        String query = "SELECT * FROM " + DBConst.TABLE_GUESTS+
                " WHERE " + DBConst.GUESTS_COLUMN_ID + " = " + guestId;
        try{
            Statement getGuest =
                    db.getConnection().createStatement();
            ResultSet data = getGuest.executeQuery(query);
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
