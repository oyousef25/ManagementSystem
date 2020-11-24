package pojo;

/**
 * Reservations Constructor Contains:
 * 1. Reservations Class Properties
 * 2. Reservations Class Constructors(with id, without id and an Empty Constructor)
 * 3. Reservations Class Getters and Setters
 * 4. A toString method to return the guest's name
 */
public class Reservations {

    /**
     * Class's Properties
     */
    private int id;
    private String name;
    private int date;
    //It's int because we're going to use its id in the table
    private int guests;
    private int tableNum;
    private int phoneNumber;

    /**
     * Class's first constructor:
     * @param id
     * @param name
     * @param date
     * @param guests
     * @param tableNum
     * @param phoneNumber
     */
    public Reservations(int id, String name, int date, int guests, int tableNum, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.guests = guests;
        this.tableNum = tableNum;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Class's Second Constructor (Without the id property)
     * @param name
     * @param date
     * @param guests
     * @param tableNum
     * @param phoneNumber
     */
    public Reservations(String name, int date, int guests, int tableNum, int phoneNumber) {
        this.name = name;
        this.date = date;
        this.guests = guests;
        this.tableNum = tableNum;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Class's third Constructor (Empty Constructor)
     */
    public Reservations() {
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
    public int getDate() {
        return date;
    }

    /**
     * Date Setter
     * @param date
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Guests Getter
     * @return
     */
    public int getGuests() {
        return guests;
    }

    /**
     * Guests Setter
     * @param guests
     */
    public void setGuests(int guests) {
        this.guests = guests;
    }

    /**
     * Table Number Getter
     * @return
     */
    public int getTableNum() {
        return tableNum;
    }

    /**
     * Table NUmber Setter
     * @param tableNum
     */
    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
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

    /**
     * toString() Method to return the guest's name:
     * @return
     */
    @Override
    public String toString() {
        return getName() + " ";
    }
}
