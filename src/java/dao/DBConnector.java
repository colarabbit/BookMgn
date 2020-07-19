package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector extends DB{
    
    public static DBConnector connector;
    
    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL, dbuser, dbpass);
    }

    public Connection openConnection(){
        return this.conn;
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
    public static DBConnector getConnector() throws ClassNotFoundException, SQLException{
        if(connector ==null){
            connector = new DBConnector();
        }
        return connector;
    }
    
}