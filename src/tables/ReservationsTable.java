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
                        data.getInt(DBConst.RESERVATIONS_COLUMN_GUESTS),
                        data.getInt(DBConst.RESERVATIONS_COLUMN_TABLE),
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
                            data.getInt(DBConst.RESERVATIONS_COLUMN_GUESTS),
                            data.getInt(DBConst.RESERVATIONS_COLUMN_TABLE),
                            data.getInt(DBConst.RESERVATIONS_COLUMN_PHONE)));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void deleteReservation(int id) {

    }

    @Override
    public void createReservation(Reservations reservation) {

    }
}
