package tables;

import Database.DBConst;
import Database.Database;
import daos.ReservationsDAO;
import pojo.Reservations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReservationsTable implements ReservationsDAO {
    Database db = Database.getInstance();
    ArrayList<Reservations> reservations;

    @Override
    public ArrayList<Reservations> getAllReservations() {
        String query = "SELECT * FROM " + DBConst.TABLE_RESERVATIONS;
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

    @Override
    public Reservations getReservation(int reservationId) {
        String query = "SELECT * FROM " + DBConst.TABLE_RESERVATIONS+
                " WHERE " + DBConst.RESERVATIONS_COLUMN_ID + " = " + reservationId;
        Reservations reservation = new Reservations();

        try{
            Statement getReservations = db.getConnection().createStatement();
            ResultSet data = getReservations.executeQuery(query);
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
}
