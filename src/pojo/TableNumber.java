package pojo;

/**
 * Table Number Class Contains:
 * 1. Table Number table properties(id, Number of the guests).
 * 2. A Constructor to make a new instance.
 * 3. Properties Getters to read the property value and Setters to change the property value.
 * 4. We don't need a toString() function because both properties are int data type.
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 20th NOV 2020
 */
public class TableNumber {
    /**
     * Class Properties
     */
    private int id;
    private int tableNum;

    /**
     * The Class's Constructor
     * @param id
     * @param tableNum
     */
    public TableNumber(int id, int tableNum) {
        super();
        this.id = id;
        this.tableNum = tableNum;
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
     * Table Number Getter
     * @return
     */
    public int getTableNum() {
        return tableNum;
    }

    /**
     * Table Number Setter
     * @param tableNum
     */
    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * Retrieves the string equivalent to table Number
     * @return tableNum string
     */
    @Override
    public String toString() {
        return "" + tableNum;
    }
}
