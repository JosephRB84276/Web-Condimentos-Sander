/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dao;

import conexion.conexion;
import modelo.CartItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    
    public void agregarAlCarrito(int idCliente, int idProducto, String tipoEmpaque, 
                               double precioUnitario, int cantidad, double subtotal) {
        try (Connection conn = conexion.getConexion()) {
            
            Integer idCarrito = obtenerIdCarritoActivo(conn, idCliente);
            if (idCarrito == null) return;
            
            String sqlCheck = "SELECT cantidad, subtotal FROM detalle_carrito " +
                             "WHERE id_carrito=? AND id_producto=? AND tipo_empaque=?";
            try (PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {
                psCheck.setInt(1, idCarrito);
                psCheck.setInt(2, idProducto);
                psCheck.setString(3, tipoEmpaque);
                ResultSet rs = psCheck.executeQuery();
                
                if (rs.next()) {
                    int cantActual = rs.getInt("cantidad");
                    double subActual = rs.getDouble("subtotal");
                    
                    String sqlUpdate = "UPDATE detalle_carrito SET cantidad=?, subtotal=? " +
                                      "WHERE id_carrito=? AND id_producto=? AND tipo_empaque=?";
                    try (PreparedStatement psUpd = conn.prepareStatement(sqlUpdate)) {
                        psUpd.setInt(1, cantActual + cantidad);
                        psUpd.setDouble(2, subActual + subtotal);
                        psUpd.setInt(3, idCarrito);
                        psUpd.setInt(4, idProducto);
                        psUpd.setString(5, tipoEmpaque);
                        psUpd.executeUpdate();
                    }
                } else {
                    String sqlInsert = "INSERT INTO detalle_carrito " +
                                      "(id_carrito, id_producto, tipo_empaque, precio_unitario, cantidad, subtotal) " +
                                      "VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement psIns = conn.prepareStatement(sqlInsert)) {
                        psIns.setInt(1, idCarrito);
                        psIns.setInt(2, idProducto);
                        psIns.setString(3, tipoEmpaque);
                        psIns.setDouble(4, precioUnitario);
                        psIns.setInt(5, cantidad);
                        psIns.setDouble(6, subtotal);
                        psIns.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<CartItem> obtenerCarrito(int idCliente) {
        List<CartItem> items = new ArrayList<>();
        try (Connection conn = conexion.getConexion()) {
            
            Integer idCarrito = obtenerIdCarritoActivo(conn, idCliente);
            if (idCarrito == null) return items;
            
            String sql = "SELECT dc.*, p.Nombre FROM detalle_carrito dc " +
                        "INNER JOIN producto p ON dc.id_producto = p.id_producto " +
                        "WHERE dc.id_carrito=?";
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idCarrito);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    CartItem item = new CartItem();
                    item.setIdProducto(rs.getInt("id_producto"));
                    item.setNombreProducto(rs.getString("Nombre"));
                    item.setTipoEmpaque(rs.getString("tipo_empaque"));
                    item.setPrecioUnitario(rs.getDouble("precio_unitario"));
                    item.setCantidad(rs.getInt("cantidad"));
                    item.setSubtotal(rs.getDouble("subtotal"));
                    items.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public void eliminarDelCarrito(int idCarrito, int idProducto, String tipoEmpaque) {
        try (Connection conn = conexion.getConexion()) {
            String sql = "DELETE FROM detalle_carrito " +
                        "WHERE id_carrito=? AND id_producto=? AND tipo_empaque=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idCarrito);
                ps.setInt(2, idProducto);
                ps.setString(3, tipoEmpaque);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void vaciarCarrito(int idCliente) {
        try (Connection conn = conexion.getConexion()) {
            Integer idCarrito = obtenerIdCarritoActivo(conn, idCliente);
            if (idCarrito != null) {
                String sql = "DELETE FROM detalle_carrito WHERE id_carrito=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, idCarrito);
                    ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Integer obtenerIdCarritoActivo(Connection conn, int idCliente) throws SQLException {
        String sql = "SELECT id_carrito FROM carrito WHERE id_cliente=? AND estado='activo' ORDER BY fecha_creacion DESC LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_carrito");
            }
        }
        
        String sqlInsert = "INSERT INTO carrito (id_cliente, fecha_creacion, estado) VALUES (?, CURDATE(), 'activo')";
        try (PreparedStatement ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idCliente);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        }
        return null;
    }
    
    public int obtenerIdCarritoActivo(int idCliente) {
        try (Connection conn = conexion.getConexion()) {
            Integer id = obtenerIdCarritoActivo(conn, idCliente);
            return id != null ? id : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}