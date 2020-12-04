package tables;

import Database.DBConst;
import Database.Database;
import daos.ReservationsDAO;
import pojo.DisplayReservation;
import pojo.Reservations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * ReservationsTable Class -- Represents the Reservations Table
 * This class implements the ReservationsDAO
 * therefore, has access to a number of methods used to retrieve, manipulate and display the reservations in the Reservations Table

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 24th 2020
 */
public class ReservationsTable implements ReservationsDAO {
    //properties
    Database db = Database.getInstance();
    ArrayList<Reservations> reservations;

    /**
     * The purpose of this method is to retrieve all records from the Reservations table and store them into an arraylist
     * @return Returns an arrayList of reservations
     */
    @Override
    public ArrayList<Reservations> getAllReservations() {
        String query = "SELECT * FROM " + DBConst.TABLE_RESERVATIONS;
        reservations = new ArrayList<Reservations>();
        try{
            Statement getReservations = db.getConnection().createStatement();
            ResultSet data = getReservations.executeQuery(query);

            while(data.next()){
                reservations.add(new Reservations(data.getInt(DBConst.RESERVATIONS_COLUMN_ID),
                        data.getString(DBConst.RESERVATIONS_COLUMN_NAME),
                        data.getInt(DBConst.RESERVATIONS_COLUMN_DATE),
                        data.getInt(DBConst.RESERVATIONS_COLUMN_TABLE),
                        data.getInt(DBConst.RESERVATIONS_COLUMN_GUESTS),
                        data.getInt(DBConst.RESERVATIONS_COLUMN_PHONE)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reservations;
    }

    /**
     * The purpose of this method is to retrieve a specific record from the Reservations table
     * @param reservationId
     * @return Returns a Reservation
     */
    @Override
    public Reservations getReservation(int reservationId) {
        String query = "SELECT * FROM " + DBConst.TABLE_RESERVATIONS+
                " WHERE " + DBConst.RESERVATIONS_COLUMN_ID + " = " + reservationId;
        Reservations reservation = new Reservations();

        try{
            Statement getReservations = db.getConnection().createStatement();
            ResultSet data = getReservations.executeQuery(query);
            //data.next() makes data the first record, then the next record etc.
            data.next();
            reservations.add(
                    new Reservations(data.getInt(DBConst.RESERVATIONS_COLUMN_ID),
                            data.getString(DBConst.RESERVATIONS_COLUMN_NAME),
                            data.getInt(DBConst.RESERVATIONS_COLUMN_DATE),
                            data.getInt(DBConst.RESERVATIONS_COLUMN_TABLE),
                            data.getInt(DBConst.RESERVATIONS_COLUMN_GUESTS),
                            data.getInt(DBConst.RESERVATIONS_COLUMN_PHONE)));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    /**
     * The purpose of this method is to remove a specified reservation from the table
     * @param id corresponding id to the item to be deleted
     */
    @Override
    public void deleteReservation(int id) {
        String query  = "DELETE FROM " + DBConst.TABLE_RESERVATIONS + " WHERE " +
                DBConst.RESERVATIONS_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted reservation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The purpose of this method is to insert a specified reservation into the table
     * @param reservation parameter reservation to be created and inserted into the table
     */
    @Override
    public void createReservation(Reservations reservation) {
        String query = "INSERT INTO " + DBConst.TABLE_RESERVATIONS +
                "(" + DBConst.RESERVATIONS_COLUMN_NAME + ", " +
                DBConst.RESERVATIONS_COLUMN_DATE + "," +
                DBConst.RESERVATIONS_COLUMN_TABLE + "," +
                DBConst.RESERVATIONS_COLUMN_GUESTS + "," +
                DBConst.RESERVATIONS_COLUMN_PHONE  + ") VALUES ('" +
                reservation.getName() + "','" + reservation.getDate() + "','" +
                reservation.getTableNum() + "','" + reservation.getGuests() + "','" +
                reservation.getPhoneNumber() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Reservation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The purpose of this method is to display the reservations table in a nice manner
     * Contains an SQL query which combines related columns from different tables to display in one table
     * @return Returns an arrayList of reservations
     */
    public ArrayList<DisplayReservation> getPrettyItems(){
        ArrayList<DisplayReservation> reservations = new ArrayList<DisplayReservation>();

        //statement contains JOIN which is able to combine related columns between two or more tables
        String query = "SELECT reservations.id, reservations.name, " +
                " reservations.date, table_number.number AS table_number," +
                " number_of_guests.num_of_guests AS number_of_guests, " +
                " reservations.phone " +
                " FROM reservations " +
                "JOIN table_number on reservations.table_number = table_number.id " +
                "JOIN number_of_guests on reservations.number_of_guests = number_of_guests.id " +
                "ORDER BY reservations.id ASC";
        try {
            Statement getReservations = db.getConnection().createStatement();
            ResultSet data = getReservations.executeQuery(query);
            while(data.next()) {
                reservations.add(new DisplayReservation(data.getInt("id"),
                        data.getString("name"),
                        data.getString("date"),
                        data.getString("table_number"),
                        data.getString("number_of_guests"),
                        data.getInt("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    /**
     * The purpose of this method is to return the row count of the reservation
     * @param reservation specifies reservation to obtain row count from
     * @return Returns the row count of the reservation provided
     */
    public int getReservationCount(int reservation) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + DBConst.TABLE_RESERVATIONS + " WHERE "
                                    + DBConst.RESERVATIONS_COLUMN_NAME + " = '" + reservation + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
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
