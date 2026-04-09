/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexion;
import modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    // REGISTRAR nuevo usuario
    public boolean registrar(Usuario u) {
        String sql = "INSERT INTO usuarios (nombres, apellidos, tipo_documento, numero_documento, ciudad, direccion, telefono, correo, contrasena) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getTipo_documento());
            ps.setString(4, u.getNumero_documento());
            ps.setString(5, u.getCiudad());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getTelefono());
            ps.setString(8, u.getCorreo());
            ps.setString(9, u.getContrasena()); 
            
            int filas = ps.executeUpdate();
            return filas > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // VALIDAR login
    public Usuario validarLogin(String correo, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE correo=? AND contrasena=?";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setCorreo(rs.getString("correo"));
                // ... más campos si los necesitas ...
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;  // Credenciales inválidas
    }
    
    // VERIFICAR si correo ya existe
    public boolean correoExiste(String correo) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo=?";
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}