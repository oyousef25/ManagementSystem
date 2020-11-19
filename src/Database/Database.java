package Database;

import java.sql.*;

public class Database {

    private static Database instance = null;
    private Connection connection = null;

    private Database() {
        if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); //using the new driver format
                connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                        + Login.DB_NAME + "?serverTimezone=UTC", Login.DB_USER, Login.DB_PASSWORD);
                System.out.println("Connection successful");
                //create tables
            }catch(Exception e){
                e.printStackTrace();
            }
            try {
                createTable(DBConst.TABLE_NUMBER_TABLE, DBConst.CREATE_TABLE_NUMBER, connection);
                createTable(DBConst.TABLE_GUESTS, DBConst.CREATE_TABLE_GUESTS, connection);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

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
