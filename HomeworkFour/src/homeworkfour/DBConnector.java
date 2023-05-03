/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homeworkfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sba22057
 */
public class DBConnector {
    private final String DB_URL = "jdbc:mysql://localhost";
    private final String USER = "pooa";
    private final String PASSWD = "H0mework4";
    private final String DB_NAME = "warehouse";
    public static int idProduct = 0;
    
    public void createDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // set up the DB
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            //  Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
           
            // Execute a Query
            Statement stmt = conn.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS products "
                    + " id INT(10) NOT NULL,"
                    + " invoice INT(10) NOT NULL,"
                    + " stockCode INT(10) NOT NULL,"
                    + " description VARCHAR(255),"
                    + " quantity INT(10) NOT NULL,"
                    + " InvoiceDate DATETIME NOT NULL,"
                    + " Price DECIMAL(15,2) NOT NULL,"
                    + " CustomerID INT(10),"
                    + " Country VARCHAR(50)"
                    + " PRIMARY KEY (id));";
            
            String createDB = "CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";";
            stmt.executeUpdate(createDB);
            System.out.println("DB Created");
            stmt.execute("USE warehouse;");
            stmt.executeUpdate(sql);
            System.out.println("Created Table products!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    /**
     *
     * @param invoice
     * @param stockCode
     * @param description
     * @param invoiceDate
     * @param quantity
     * @param price
     * @param custID
     * @param country
     * @throws SQLException
     */
    public void addProduct(int invoice, int stockCode, String description, int quantity, double price, String invoiceDate, int custID, String country) throws SQLException {
            Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
            Statement stmt = conn.createStatement();

            String sqlInsert;
            sqlInsert = "INSERT INTO newData VALUES (" 
                    + idProduct + ", " + invoice + ", " + stockCode + ", " + description + ", " 
                    + quantity + ", " + price + ", " + invoiceDate + ", " + custID + ", " + country + ");";
            stmt.executeUpdate(sqlInsert);
            
            // increment id 
            idProduct++;
        }
}
