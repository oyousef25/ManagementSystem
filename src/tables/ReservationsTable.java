package tables;

import daos.ReservationsDAO;
import pojo.Reservations;

import java.util.ArrayList;

public class ReservationsTable implements ReservationsDAO {
    @Override
    public ArrayList<Reservations> AllReservations() {
        return null;
    }

    @Override
    public Reservations getReservation(int reservationId) {
        return null;
    }

    @Override
    public void deleteReservation(int id) {

    }

    @Override
    public void createReservation(Reservations reservation) {

    }
}
