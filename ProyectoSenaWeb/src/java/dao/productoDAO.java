/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.conexion;
import modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    public void insertar(Producto p){
        String sql = "INSERT INTO producto (Nombre, Descripcion, Precio, Cantidad_empaque, Stock) VALUES (?,?,?,?,?)";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setString(4, p.getCantidad_empaque());
            ps.setInt(5, p.getStock());
            
            ps.executeUpdate();
            System.out.println("Producto insertado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Producto p = new Producto();
                p.setid_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("Nombre"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setCantidad_empaque(rs.getString("Cantidad_empaque"));
                p.setStock(rs.getInt("Stock"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
    
    public void actualizar(Producto p) {
        String sql = "UPDATE producto SET Nombre=?, Descripcion=?, Precio=?, Cantidad_empaque=?, Stock=? WHERE id_producto=?";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setString(4, p.getCantidad_empaque());
            ps.setInt(5, p.getStock());
            ps.setInt(6, p.getId_producto()); 
            
            ps.executeUpdate();
            System.out.println("Producto actualizado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void eliminar(int id_producto) {
        String sql = "DELETE FROM producto WHERE id_producto=?";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id_producto);
            ps.executeUpdate();
            System.out.println("Producto eliminado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Producto buscarPorId(int id_producto) {
        Producto p = null;
        String sql = "SELECT * FROM producto WHERE id_producto=?";
        
        try (Connection conn = conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id_producto);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                p = new Producto();
                p.setid_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("Nombre"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setCantidad_empaque(rs.getString("Cantidad_empaque"));
                p.setStock(rs.getInt("Stock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}