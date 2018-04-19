/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author MarcR
 */
public class MySQLDB {
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
        
    public static void main (String args[]){
        
        MySQLDB mydb = new MySQLDB();
        try{
        mydb.readDB();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void readDB() throws Exception{
     
        Class.forName("com.mysql.jdbc.Driver");
       
        connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/starcitizen?"
                            + "user=rudi&password=12bnt89");        
        statement = connect.createStatement();
            
        // Result set get the result of the SQL query            
            
            String insertStatement = "INSERT INTO `login` (`id`, `name`, `email`, `passwort`)"+
                                     "VALUES (NULL, 'Werner', 'Werner@roehrig.com', 'TODO')";
            statement
                    .execute(insertStatement);
            
            String updateStatement = "UPDATE `login` SET `name` = 'Peter', `email` = 'Peter@gmail.com', `passwort` = 'test' WHERE `login`.`id` = 2";
            statement.executeUpdate(updateStatement);
            
            resultSet = statement
                    .executeQuery("select * from starcitizen.login");
            writeResultSet(resultSet);
    }
        private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            String user = resultSet.getString("name");
            String mail = resultSet.getString("email");
            String password = resultSet.getString("passwort");
            
            System.out.println("name: " + user);
            System.out.println("email: " + mail);
            System.out.println("password: " + password);
            
        }    
            
    }
}
