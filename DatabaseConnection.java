/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreInventory;

import java.sql.*;


public class DatabaseConnection {
        private static final String databaseURL = "jdbc:sqlite:foodStore.sqlite";

    public static Connection createLink() {
        try {
            return DriverManager.getConnection(databaseURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
