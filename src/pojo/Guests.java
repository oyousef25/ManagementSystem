package pojo;

/**
 * GUESTS CLASS CONTAINS:
 * 1. Guests table properties(id, Number of the guests).
 * 2. A Constructor to make a new instance.
 * 3. Properties Getters to read the property value and Setters to change the property value.
 * 4. We don't need a toString() function because both properties are int data type.
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 20th NOV 2020
 */
public class Guests {
    /**
     * Class Properties
     */
    private int id;
    private int numOfGuests;

    /**
     * Class Constructor
     * @param id
     * @param numOfGuests
     */
    public Guests(int id, int numOfGuests) {
        super();
        this.id = id;
        this.numOfGuests = numOfGuests;
    }

    /**
     * ID getter
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * ID setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Number of guests getter
     * @return numOfGuests
     */
    public int getNumOfGuests() {
        return numOfGuests;
    }

    /**
     * Number of guests setter
     * @param numOfGuests
     */
    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    /**
     * outputs format to string for number of guests
     * @return numOfGuests String
     */
    public String toString(){
        return "" + this.numOfGuests;
    }
}
