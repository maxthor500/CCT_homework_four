/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homeworkfour;

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
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        DBConnector dbconn = new DBConnector();
        dbconn.createDB();
        
    }
    
}
