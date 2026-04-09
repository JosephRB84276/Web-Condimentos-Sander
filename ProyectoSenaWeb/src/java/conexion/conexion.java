/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/condimentos_sander";
    private static final String USER = "root";
    private static final String PASSWORD = "IvanRB84276"; // ⚠️ Ajusta si tu contraseña es otra

    public static Connection getConexion() {
        Connection conn = null;
        try {
            // Cargar el driver (necesario en algunas versiones)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la BD: condimentos_sander");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver MySQL no encontrado - " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error de conexión a la BD: " + e.getMessage());
            System.err.println("   SQL State: " + e.getSQLState());
            System.err.println("   Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
        return conn;
    }
}
