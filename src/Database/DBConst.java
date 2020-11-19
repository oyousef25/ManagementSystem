package Database;

/**
 * @DBConst class
 * This class will create all 3 tables:
 */

public class DBConst {
    /*
        CREATING CONSTANTS TO REPRESENT EACH COLUMN AND TABLE
     */

    /**
     * Reservations Table will have 6 columns:
     * 1. ID
     * 2. NAME
     * 3. DATE
     * 4. TABLE_NUMBER
     * 5. NUMBER_OF_PEOPLE
     * 6. PHONE_NUMBER
      */
    public static final String TABLE_RESERVATIONS = "reservations";
    public static final String RESERVATIONS_COLUMN_ID = "id";
    public static final String RESERVATIONS_COLUMN_NAME = "name";
    public static final String RESERVATIONS_COLUMN_DATE = "date";
    public static final String RESERVATIONS_COLUMN_TABLE = "table_number";
    public static final String RESERVATIONS_COLUMN_GUESTS = "number_of_guests";
    public static final String RESERVATIONS_COLUMN_PHONE = "phone";

    /**
     * Number Of People Table will have 2 columns:
     * 1. ID
     * 2. NUMBER_OF_PEOPLE
     */
    public static final String TABLE_GUESTS = "number_of_guests";
    public static final String GUESTS_COLUMN_ID = "id";
    public static final String GUESTS_COLUMN_NUMBER = "num_of_guests";

    /**
     * Table Number Table will have 2 columns:
     * 1. ID
     * 2. TABLE_NUMBER
     */
    public static final String TABLE_NUMBER_TABLE = "table_number";
    public static final String TABLE_NUMBER_COLUMN_ID = "id";
    public static final String TABLE_NUMBER_COLUMN_NUMBER = "number";



    /*
        CREATING TABLES
     */

    /**
     * CREATE THE TABLE NUMBER TABLE
     */
    public static final String CREATE_TABLE_NUMBER =
            "CREATE TABLE " + TABLE_NUMBER_TABLE + "(" +
                    TABLE_NUMBER_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    TABLE_NUMBER_COLUMN_NUMBER + " int, " +
                    "PRIMARY KEY(" + TABLE_NUMBER_COLUMN_ID + ")" +
            ")";

    /**
     * CREATE THE NUMBER OF PEOPLE TABLE
     */
    public static final String CREATE_TABLE_GUESTS =
            "CREATE TABLE " + TABLE_GUESTS + "(" +
                    GUESTS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    GUESTS_COLUMN_NUMBER + " int, " +
                    "PRIMARY KEY(" + GUESTS_COLUMN_ID + ")" +
            ")";

    /**
     * CREATE THE RESERVATIONS TABLE
     */
    public static final String CREATE_TABLE_RESERVATIONS =
            "CREATE TABLE " + TABLE_RESERVATIONS + "(" +
                    RESERVATIONS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    RESERVATIONS_COLUMN_NAME + " varchar(20) NOT NULL, " +
                    RESERVATIONS_COLUMN_DATE + " int(4) NOT NULL" +
                    RESERVATIONS_COLUMN_TABLE + " int NOT NULL" +
                    RESERVATIONS_COLUMN_GUESTS + " int NOT NULL" +
                    RESERVATIONS_COLUMN_PHONE + " int NOT NULL" +
                    "FOREIGN KEY (" + RESERVATIONS_COLUMN_TABLE + ")" +
                            " REFERENCES " + TABLE_NUMBER_TABLE + "(" + TABLE_NUMBER_COLUMN_ID + "),"+
                    "FOREIGN KEY (" + RESERVATIONS_COLUMN_GUESTS + ")" +
                            " REFERENCES " + TABLE_GUESTS + "(" + GUESTS_COLUMN_ID + "))";
}
