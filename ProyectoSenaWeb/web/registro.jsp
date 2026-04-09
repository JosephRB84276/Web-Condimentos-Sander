<%-- 
    Document   : registro
    Created on : 9/04/2026, 10:08:27 a. m.
    Author     : RYZEN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estiloRegister.css">
</head>
<body>
    <section class="Form-register">
        <h4>Formulario Registro</h4>
        
        <% if (request.getAttribute("error") != null) { %>
            <p style="color: red; text-align: center; margin-bottom: 10px;">
                <%= request.getAttribute("error") %>
            </p>
        <% } %>
        
        <form action="${pageContext.request.contextPath}/RegistroServlet" method="POST">
            <input class="controls" type="text" name="nombres" placeholder="Nombres" required>
            <input class="controls" type="text" name="apellidos" placeholder="Apellidos" required>
            
            <select class="controls" name="tipo_documento" required>
                <option value="" disabled selected>Seleccione su documento</option>
                <option value="CC">Cédula de ciudadanía</option>
                <option value="CE">Cédula de extranjería</option>
                <option value="TI">Tarjeta de identidad</option>
            </select>
            
            <input class="controls" type="text" name="numero_documento" placeholder="Numero de documento" required>
            <input class="controls" type="text" name="ciudad" placeholder="Ciudad">
            <input class="controls" type="text" name="direccion" placeholder="Direccion">
            <input class="controls" type="text" name="telefono" placeholder="Telefono">
            <input class="controls" type="email" name="correo" placeholder="Correo" required>
            <input class="controls" type="password" name="contrasena" placeholder="Contraseña" required>
            <input class="controls" type="password" name="confirmar_contrasena" placeholder="Confirmar contraseña" required>
            
            <p>Estoy de acuerdo con <a href="#">Términos y condiciones</a></p>
            <input class="buttons" type="submit" value="Registrarse">
            <p><a href="login.jsp">¿Ya tienes una cuenta? Inicia sesión</a></p>
        </form>
    </section> 
</body>
</html>