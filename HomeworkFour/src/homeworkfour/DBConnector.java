/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homeworkfour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
            Statement stmt = conn.createStatement();
            String createDB = "CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";";
            stmt.executeUpdate(createDB);
            System.out.println("DB Created");
            stmt.execute("USE warehouse;");
            stmt.execute("CREATE TABLE IF NOT EXISTS products ("
                            + "id INT(10) NOT NULL PRIMARY KEY,"
                            + "Invoice INT(10),"
                            + "StockCode INT(10),"
                            + "Description VARCHAR(40),"
                            + "Quantity INT(4),"
                            + "InvoiceDate DATETIME,"
                            + "Price DECIMAL(15, 2),"
                            + "CustomerID INT(10),"
                            + "Country VARCHAR(40)"
                            + ");");
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
    public void addProduct(int id, int invoice, int stockCode, String description, int quantity, float price, String invoiceDate, int custID, String country) throws SQLException {
            Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASSWD);
            Statement stmt = conn.createStatement();
            
            //convert the String invoiceDate in datatime
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(invoiceDate, dateFormat);
            
            stmt.execute(String.format("INSERT INTO products ("
                + "id, Invoice, StockCode, Description, Quantity, Price, InvoiceDate,"
                + "CustomerID, Country) VALUES (%d, %d, %d, %s, %d, %.2f, %s, %d, %s)",
                id, invoice, stockCode, description, quantity, price, dateTime,custID, country));

            System.out.println("Product Created");
            
            // increment id 
            id++;
        }
}
