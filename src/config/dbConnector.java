/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class dbConnector {
    

           private Connection connect;
            
       // constructor to connect to our database
        public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db.residentialconstruction", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
     
}
        //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
             
//Function to save data
        public int insertData(String sql){
            int result;
            try{
                try (PreparedStatement pst = connect.prepareStatement(sql)) {
                    pst.executeUpdate();
                    System.out.println("Inserted Successfully!");
                }
                result =1;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
                result =0;
            }
            return result;
        }

    
    

}



     