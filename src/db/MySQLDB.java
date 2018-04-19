/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import citizenofthestars2d.Spieler;
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

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static void main(String args[]) {

        MySQLDB mydb = new MySQLDB();
        try {

            mydb.readDB();
            mydb.insterLogin(null);
            mydb.updateLogin(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Statement connect() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/starcitizen?"
                        + "user=rudi&password=12bnt89");
        Statement statement = connect.createStatement();
        return statement;
    }

    public void readDB() throws Exception {
        String selectStatement = "select * from starcitizen.login";
        resultSet = connect().executeQuery(selectStatement);

        writeResultSet(resultSet);
    }

    public void updateLogin(Spieler sp) throws Exception {

        String updateStatement = "UPDATE `login` SET `name` = 'Peter', `email` = 'Peter@gmail.com', `passwort` = 'test' WHERE `login`.`id` = 2";
        connect().executeUpdate(updateStatement);
    }

    public void insterLogin(Spieler sp) throws Exception {
        String insertStatement = "INSERT INTO `login` (`id`, `name`, `email`, `passwort`)"
                + "VALUES (NULL, 'Werner', 'Werner@roehrig.com', 'TODO')";
        connect().execute(insertStatement);
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
