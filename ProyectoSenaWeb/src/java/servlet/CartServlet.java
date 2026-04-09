/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.CartDAO;
import dao.ClienteDAO;
import modelo.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    
    private CartDAO cartDAO = new CartDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (usuario == null) {
            response.getWriter().write("NO_AUTH");
            return;
        }
        
        int idCliente = clienteDAO.obtenerIdCliente(usuario.getId_usuario());
        
        if ("añadir".equals(accion)) {
            try {
                int idProducto = Integer.parseInt(request.getParameter("id"));
                double precio = Double.parseDouble(request.getParameter("precio"));
                String tipoEmpaque = request.getParameter("tipo");
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                double subtotal = precio * cantidad;
                
                cartDAO.agregarAlCarrito(idCliente, idProducto, tipoEmpaque, precio, cantidad, subtotal);
                response.getWriter().write("OK");
                
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("ERROR: " + e.getMessage());
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (usuario == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        
        int idCliente = clienteDAO.obtenerIdCliente(usuario.getId_usuario());
        
        if ("eliminar".equals(accion)) {
            int idProducto = Integer.parseInt(request.getParameter("id_producto"));
            String tipoEmpaque = request.getParameter("tipo_empaque");
            int idCarrito = cartDAO.obtenerIdCarritoActivo(idCliente);
            cartDAO.eliminarDelCarrito(idCarrito, idProducto, tipoEmpaque);
            response.sendRedirect(request.getContextPath() + "/carrito.jsp");
            
        } else if ("vaciar".equals(accion)) {
            cartDAO.vaciarCarrito(idCliente);
            response.sendRedirect(request.getContextPath() + "/carrito.jsp");
        }
    }
}