/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homeworkfour;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Carmine Pastena
 * student ID sba22057
 */
public class HomeworkFour {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.InstantiationException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, FileNotFoundException, IOException {
//        DBConnector dbconn = new DBConnector();
//        dbconn.createDB();
      
        //support variable
        String line = "";
        String commaSplit = ",";
        String headerLine = "";
 
        // inizialize the file reader
        BufferedReader br = new BufferedReader(new FileReader("newData.csv"));
        
        // read the first line
        headerLine = br.readLine();
        
        while ((line = br.readLine()) != null)  {
            String[] product = line.split(commaSplit);
            
            int invoice = Integer.parseInt(product[0]);
            int stockCode = Integer.parseInt(product[1]);
            String description = product[2];
            int quantity = Integer.parseInt(product[3]);
            String invoiceDate = product[4];
            float price = Float.parseFloat(product[5]);
            int custID = Integer.parseInt(product[6]);
            String country = product[7];
            
            System.out.println(invoice + stockCode + description + quantity + invoiceDate + price + custID + country);
        }

        

    }
    
}
