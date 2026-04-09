/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dao;

import conexion.conexion;
import java.sql.*;

public class ClienteDAO {
    
    public int obtenerIdCliente(int idUsuario) {
        try (Connection conn = conexion.getConexion()) {
            
            // 1. Buscar si ya existe el cliente vinculado
            String sql = "SELECT id_cliente FROM cliente WHERE id_usuario=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idUsuario);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_cliente");
                }
            }
            
            // 2. Si no existe, crearlo desde la tabla usuarios
            String sqlUsuario = "SELECT * FROM usuarios WHERE id_usuario=?";
            try (PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario)) {
                psUsuario.setInt(1, idUsuario);
                ResultSet rsUsuario = psUsuario.executeQuery();
                
                if (rsUsuario.next()) {
                    String sqlInsert = "INSERT INTO cliente (Nombre, Apellido, Cedula, Correo, Direccion, Telefono, id_usuario) " +
                                      "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
                        psInsert.setString(1, rsUsuario.getString("nombres"));
                        psInsert.setString(2, rsUsuario.getString("apellidos"));
                        psInsert.setString(3, rsUsuario.getString("numero_documento"));
                        psInsert.setString(4, rsUsuario.getString("correo"));
                        psInsert.setString(5, rsUsuario.getString("direccion") != null ? rsUsuario.getString("direccion") : "");
                        psInsert.setString(6, rsUsuario.getString("telefono") != null ? rsUsuario.getString("telefono") : "");
                        psInsert.setInt(7, idUsuario);
                        psInsert.executeUpdate();
                        
                        ResultSet keys = psInsert.getGeneratedKeys();
                        if (keys.next()) {
                            return keys.getInt(1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}