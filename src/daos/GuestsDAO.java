package daos;

import pojo.Guests;

import java.util.ArrayList;

/**
 * Guests DAO(Data Access Object) helps us:
 * 1. access all Guests Numbers/Quantities (How Many People Are Coming to the reservation)
 * 2. access a single Guests Number/Quantity
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 20th NOV 2020
 */
public interface GuestsDAO {
    /**
     * A function that returns all guests quantities in each reservation
     * @return guests arraylist
     */
    public ArrayList<Guests> getAllGuests();

    /**
     * A function that returns a single guests quantity in a specific reservation
     * @param guestId
     * @return guest
     */
    public Guests getGuest(int guestId);
}
