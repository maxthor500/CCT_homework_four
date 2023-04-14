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
//        
        String line = "";
        String commaSplit = ",";
        
        BufferedReader br = new BufferedReader(new FileReader("newData.csv"));
        
        line = br.readLine();

        String[] product = line.split(commaSplit);
            
        System.out.println(product[0]);
        System.out.println(product[1]);
        System.out.println(product[2]);
        System.out.println(product[3]);
        System.out.println(product[4]);
        System.out.println(product[5]);
        System.out.println(product[6]);

    }
    
}
