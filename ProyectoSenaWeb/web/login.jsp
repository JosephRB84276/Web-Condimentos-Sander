<%-- 
    Document   : login
    Created on : 9/04/2026, 10:11:54 a. m.
    Author     : RYZEN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloLogin.css">
</head>
<body>
    <section class="Form-login">
        <h4>Iniciar Sesión</h4>
        
        <% if (request.getParameter("registro") != null) { %>
            <p style="color: green; text-align: center; margin-bottom: 10px;">
                ✅ Registro exitoso. Ahora puedes iniciar sesión.
            </p>
        <% } %>
        
        <% if (request.getAttribute("error") != null) { %>
            <p style="color: red; text-align: center; margin-bottom: 10px;">
                <%= request.getAttribute("error") %>
            </p>
        <% } %>
        
        <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
            <input class="controls" type="email" name="correo" placeholder="Correo" required>
            <input class="controls" type="password" name="contrasena" placeholder="Contraseña" required>
            <input class="buttons" type="submit" value="Ingresar">
            <p><a href="registro.jsp">¿No tienes cuenta? Regístrate</a></p>
        </form>
    </section>
</body>
</html>