package pojo;

/**
 * 1. Display Reservation Class Contains:
 * 2. The Reservations Table's properties
 * 3. A Class Constructor
 * 4. Getters and Setters to read and change the property's value
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 20th NOV 2020
 */
public class DisplayReservation {
    /**
     * Class's Properties:
     */
    private int id;
    private String name;
    private String date;
    private String tableNum;
    private String guests;
    private int phoneNumber;

    /**
     * Class's Constructor:
     * @param id
     * @param name
     * @param date
     * @param tableNum
     * @param guests
     * @param phoneNumber
     */
    public DisplayReservation(int id, String name, String date, String tableNum, String guests,  int phoneNumber) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tableNum = tableNum;
        this.guests = guests;
        this.phoneNumber = phoneNumber;
    }

    /**
     * ID Getter
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * ID Setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Name Getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name Setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Date Getter
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Date Setter
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Table Number Getter
     * @return
     */
    public String getTableNum() {
        return tableNum;
    }

    /**
     * Table Number Setter
     * @param tableNum
     */
    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * Number Of Guests Getter
     * @return
     */
    public String getGuests() {
        return guests;
    }

    /**
     * Number Of Guests Setter
     * @param guests
     */
    public void setGuests(String guests) {
        this.guests = guests;
    }

    /**
     * Phone Number Getter
     * @return
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Phone Number Setter
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
