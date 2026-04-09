/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.UsuarioDAO;
import modelo.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibir datos del formulario
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String tipo_documento = request.getParameter("tipo_documento");
        String numero_documento = request.getParameter("numero_documento");
        String ciudad = request.getParameter("ciudad");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String confirmar_contrasena = request.getParameter("confirmar_contrasena");
        
        // 2. Validaciones
        if (contrasena == null || !contrasena.equals(confirmar_contrasena)) {
            request.setAttribute("error", "Las contraseñas no coinciden");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);  
            return;
        }
        
        if (usuarioDAO.correoExiste(correo)) {
            request.setAttribute("error", "El correo ya está registrado");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);  
            return;
        }
        
        // 3. Crear objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombres(nombres);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setTipo_documento(tipo_documento);
        nuevoUsuario.setNumero_documento(numero_documento);
        nuevoUsuario.setCiudad(ciudad);
        nuevoUsuario.setDireccion(direccion);
        nuevoUsuario.setTelefono(telefono);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setContrasena(contrasena);
        
        // 4. Registrar en BD
        boolean registrado = usuarioDAO.registrar(nuevoUsuario);
        
        // 5. Redirigir según resultado
        if (registrado) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?registro=exitoso"); 
        } else {
            request.setAttribute("error", "Error al registrar. Intente nuevamente.");
            request.getRequestDispatcher("/registro.jsp").forward(request, response); 
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/registro.jsp").forward(request, response); 
    }
}