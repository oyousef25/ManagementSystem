package Database;

import java.sql.*;

/**
 * Database class
 * This class will use the Singleton design pattern
 * We do this through
 *  - Creating a private constructor
 *  - Create a private static instance variable
 *  - Create a public static getInstance() method

 * @author Farzana Moury
 * @version 1.0
 * @since Nov 18th 2020
 */

public class Database {

    //properties
    private static Database instance = null; //create an instance variable
    private Connection connection = null;

    /**
     * The private constructor which creates a connection
     * And creates the individual tables using tableName, sql query and connection
     */
    private Database() {
        //setup connection
        if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); //using the new driver format
                connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                        + Login.DB_NAME + "?serverTimezone=UTC", Login.DB_USER, Login.DB_PASSWORD);
                System.out.println("Connection successful");
            }catch(Exception e){
                e.printStackTrace();
            }
            try {
                //create tables
                createTable(DBConst.TABLE_NUMBER_TABLE, DBConst.CREATE_TABLE_NUMBER, connection);
                createTable(DBConst.TABLE_GUESTS, DBConst.CREATE_TABLE_GUESTS, connection);
                createTable(DBConst.TABLE_RESERVATIONS, DBConst.CREATE_TABLE_RESERVATIONS, connection);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * public static method getInstance() creates an instance of Database
     * @return Database instance
     */
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    /**
     * public method createTable() - executes the table queries only once
     * @param tableName
     * @param tableQuery
     * @param connection
     * @throws SQLException
     */
    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTables;
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(Login.DB_NAME, null, tableName, null);

        //will check to see if table exists in the database
        if(resultSet.next()) {
            System.out.println(tableName + " table already exists");
        }
        //otherwise we create a table
        else{
            createTables = connection.createStatement();
            createTables.execute(tableQuery);
            System.out.println(tableName + " table created");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}


