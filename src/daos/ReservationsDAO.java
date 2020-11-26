package daos;

import pojo.Reservations;

import java.util.ArrayList;

/**
 * Reservations DAO(Data Access Object) helps us:
 * 1. access all Reservations
 * 2. access a single Reservation
 * 3. Create a new Reservation
 * 4. Delete an existing Reservation
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 20th NOV 2020
 */
public interface ReservationsDAO {
    /**
     * A functions that return all Reservations
     * @return
     */
    public ArrayList<Reservations> getAllReservations();

    /**
     * A function that returns a single Reservation
     * @return
     */
    public Reservations getReservation(int reservationId);

    /**
     * A function that Deletes an Existing Reservation record
     * @param id
     */
    public void deleteReservation(int id);

    /**
     * A function that Creates a new Reservation
     * @param reservation
     */
    public void createReservation(Reservations reservation);
}
