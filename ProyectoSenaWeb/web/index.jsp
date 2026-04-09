<%-- 
    Document   : index
    Created on : 9/04/2026, 10:49:13 a. m.
    Author     : RYZEN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 🔐 Verificar si el usuario está logueado (SEGURIDAD)
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
    // Obtener datos del usuario logueado
    modelo.Usuario usuario = (modelo.Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Condimentos Sander - Inicio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home_estilo_nuevo.css">
</head>
<body>
    <!-- NAVBAR -->
    <nav class="navbar">
        <div class="nav-container">
            <div class="nav-logo">
                Condimentos Sander 👋 <%= usuario.getNombres() %>
            </div>
            <ul class="nav-menu">
                <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                <li><a href="#quienes">¿Quiénes somos?</a></li>
                <li><a href="${pageContext.request.contextPath}/tienda.jsp">Tienda</a></li>
                <li class="carrito-nav">
                    <a href="${pageContext.request.contextPath}/carrito.jsp">
                        🛒 Mi carrito 
                        <span id="contador-carrito" class="contador">(0)</span>
                    </a>
                </li> 
                <li>
                    <a href="${pageContext.request.contextPath}/LoginServlet?accion=logout" 
                       style="color: #e74c3c; font-weight: bold;">
                        Salir
                    </a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- HERO PRINCIPAL -->
    <header id="home" class="hero">
        <div class="hero-content">
            <h1>Condimentos Sander</h1>
            <p>"El sazón lo ponemos nosotros"</p>
            <a href="${pageContext.request.contextPath}/tienda.jsp" class="btn btn-primary">Ver Tienda</a>
        </div>
    </header>

    <!-- SECCION PRODUCTOS -->
    <section id="productos" class="productos">
        <h2 class="section-title">Nuestros productos</h2>

        <div class="productos-grid">
            <div class="producto-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen2.PNG" alt="Pasta de ají">
                <h3>Pasta de Ají</h3>
            </div>

            <div class="producto-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen4.PNG" alt="Pasta de ajo">
                <h3>Pasta de Ajo</h3>
            </div>

            <div class="producto-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen6.PNG" alt="Adobo">
                <h3>Adobo</h3>
            </div>

            <div class="producto-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen5.PNG" alt="Miel">
                <h3>Miel</h3>
            </div>

            <div class="producto-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen3.PNG" alt="Jugo de limón">
                <h3>Jugo de Limón</h3>
            </div>
        </div>
    </section>

    <!-- SECCION DESTACADOS -->
    <section class="destacados">
        <h2 class="section-title">Productos Destacados</h2>

        <div class="destacados-grid">
            <div class="destacado-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen2.PNG" alt="Pasta de ají">
                <h3>Pasta de Ají</h3>
                <p>Pasta ideal para darle un poco de picor a tus comidas</p>
                <a href="${pageContext.request.contextPath}/tienda.jsp" class="btn btn-secondary">Añadir al carrito</a>
            </div>

            <div class="destacado-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen4.PNG" alt="Pasta de ajo">
                <h3>Pasta de Ajo</h3>
                <p>Perfecta para sazonar tus comidas con un sabor único</p>
                <a href="${pageContext.request.contextPath}/tienda.jsp" class="btn btn-secondary">Añadir al carrito</a>
            </div>

            <div class="destacado-card">
                <img src="${pageContext.request.contextPath}/imagenes/imagen6.PNG" alt="Adobo">
                <h3>Adobo</h3>
                <p>El adobo que le da el toque especial a tus platillos</p>
                <a href="${pageContext.request.contextPath}/tienda.jsp" class="btn btn-secondary">Añadir al carrito</a>
            </div>
        </div>
    </section>

    <!-- QUIENES SOMOS -->
    <section id="quienes" class="quienes-somos">
        <div class="qs-container">
            <div class="qs-imagen">
                <img src="${pageContext.request.contextPath}/imagenes/imagen1.PNG" alt="productos">
            </div>
            <div class="qs-texto">
                <h2>¿Quiénes somos?</h2>
                <p>
                    En Condimentos Sander, llevamos más de 15 años deleitando paladares con productos 100% naturales,
                    elaborados con ingredientes seleccionados y recetas transmitidas de generación en generación.
                    Nuestra pasión por los sabores auténticos y nuestro compromiso con la calidad nos han convertido en
                    referentes en la producción de condimentos artesanales en Colombia.
                </p>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/quienes_somos.jsp">Conocer más</a>
            </div>
        </div>
    </section>

    <!-- FOOTER -->
    <footer class="footer">
        <div class="footer-container">
            <div class="footer-section">
                <h3>Contáctanos</h3>
                <p>Teléfono: +57 123 456 7890</p>
                <p>Email: info@condimentossander.com</p>
            </div>

            <div class="footer-section">
                <h3>Horarios de atención</h3>
                <p>Lunes a Viernes: 8:00 AM - 6:00 PM</p>
                <p>Sábados: 9:00 AM - 2:00 PM</p>
                <p>Domingo: Cerrado</p>
            </div>

            <div class="footer-section">
                <h3>Ubicación</h3>
                <p>Calle Principal #123</p>
                <p>Bogotá D.C, Cundinamarca</p>
                <p>Colombia</p>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2026 Condimentos Sander. Todos los derechos reservados.</p>
        </div>
    </footer>
</body>
</html>