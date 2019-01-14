package nl.iprwc.util;

import java.sql.*;

public class DatabaseConnection {
    private final String url = "jdbc:postgresql://localhost/iprwc";
    private final String user = "postgres";
    private final String pass = "postgres";
    private static Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;



    /**
     * With this we can create a connection with the database
     * @author Yme Brugts
     */
    public void connect(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Database is connected.");
        } else {
            System.out.println("Couldn't connect with the database.");
        }
    }

    public Connection newConnection() throws SQLException {
        System.out.println("Connected");
        return DriverManager.getConnection(url, user, pass);

    }

    public DatabaseConnection getDatabase() {
        return this;
    }

    private boolean hasConnection(){
        if (conn != null) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This is for closing the connection
     * @author Yme Brugts
     */
    public void disconnect(){
        try{
            if(statement != null){
                statement.close();
            }
            if(rs != null){
                rs.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            System.out.println("Couldn't disconnect from the database");
        }
        System.out.println("Disconnected");

    }
}