<%-- 
    Document   : carrito
    Created on : 9/04/2026, 1:11:06 p. m.
    Author     : RYZEN
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito de Compras</title>
    <link rel="stylesheet" href="css/carrito.css">
</head>
<body>

    <!-- NAVBAR -->
    <nav class="navbar">
        <div class="nav-container">
            <div class="nav-logo">condimentos Sander</div>
            <ul class="nav-menu">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="quienes_somos.jsp">¿Quienes somos?</a></li>
                <li><a href="tienda.jsp">Tienda</a></li>
                <li class="carrito-nav"><a href="carrito.jsp">
                    🛒 Mi carrito 
                    <span id="contador-carrito" class="contador">(0)</span>
                </a></li> 
            </ul>
        </div>
    </nav>
    
    <header class="hero">
        <h1>Carrito de Compras</h1>
    </header>

    <section id="carrito" class="carrito-container">
        <div class="carrito-grid">
            <!-- lado izquierda -->
            <div id="carrito-productos" class="carrito-productos">
                <h2>Productos en tu carrito</h2>
                <div id="productos-vacios" class="carrito-vacio">
                    <p>Tu carrito está vacío.</p>
                    <a href="tienda.jsp" class="btn btn-primary">Volver a la tienda</a>
                </div>
        
            <!-- lista de productos en el carrito -->

                <div id="lista-carrito" class="lista-productos"></div>
                <button onclick="vaciarCarrito()" class="btn btn-danger">
                    Vaciar carrito
                </button>
            </div>

            <!-- lado derecho -->
            <div id="resumen-compra" class="resumen-compra">
                <h2>Resumen de Compra</h2>
                <p>Total: $<span id="total-compra">0.00</span></p>
                <button id="finalizar-compra" class="btn btn-success">Finalizar Compra</button>
            </div>
        </div>
    </section>

    <!-- FOOTER -->
    <footer class="footer">
        <div class="footer-container">
            <div class="footer-section">
                <h3>Contactanos</h3>
                <p>Telefono: +57 123 456 7890</p>
                <p>Email: info@condimentossander.com</p>
            </div>

            <div class="footer-section">
                <h3>Horarios de atencios</h3>
                <p>Lunes a Viernes: 8:00 AM - 6:00 PM</p>
                <p>Sabados: 9:00 AM - 2:00 PM</p>
                <p>Domingo: Cerrado</p>
            </div>

            <div class="footer-section">
                <h3>Ubicación</h3>
                <p>Calle Principal #123</p>
                <p>Bogota D.C, Cundinamarca</p>
                <p>Colombia</p>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2026 Condimentos Sander. Todos los derechos reservados.</p>
        </div>
    </footer>
    <script src="JS/Carrito.js"></script>
</body>
</html>