================================================================================
                    CONDIMENTOS SANDER - E-COMMERCE WEB
                         Sistema de Ventas Online
================================================================================

DESCRIPCIÓN DEL PROYECTO:
-------------------------
Plataforma web para la venta de condimentos artesanales. Permite a los 
clientes registrarse, iniciar sesión,浏览 productos, añadir al carrito 
y gestionar sus compras.

================================================================================
REQUERIMIENTOS PREVIOS:
================================================================================

1. Java Development Kit (JDK) 17 o superior
   Descargar: https://www.oracle.com/java/technologies/downloads/

2. Apache Tomcat 10.1 o superior
   Descargar: https://tomcat.apache.org/

3. MySQL 8.0 o superior
   Descargar: https://dev.mysql.com/downloads/

4. NetBeans IDE 18 o superior
   Descargar: https://netbeans.apache.org/

5. MySQL Connector/J (Driver JDBC)
   Descargar: https://dev.mysql.com/downloads/connector/j/

================================================================================
INSTALACIÓN PASO A PASO:
================================================================================

PASO 1: CONFIGURAR BASE DE DATOS
---------------------------------
1. Abre MySQL Workbench o phpMyAdmin
2. Inicia sesión con tu usuario root
3. Ejecuta el archivo: bd/condimentos_sander.sql
4. Verifica que se hayan creado las tablas:
   - usuarios
   - producto
   - cliente
   - carrito
   - detalle_carrito

PASO 2: ABRIR PROYECTO EN NETBEANS
-----------------------------------
1. Abre NetBeans IDE
2. Click en: File → Open Project
3. Busca la carpeta: ProyectoSenaWeb
4. Click en "Open"

PASO 3: AGREGAR DRIVER DE MYSQL
--------------------------------
1. En NetBeans, expande el proyecto "ProyectoSenaWeb"
2. Click derecho en "Libraries"
3. Selecciona: "Add JAR/Folder..."
4. Busca y selecciona: mysql-connector-j-9.6.0.jar
5. Click en "Open"

PASO 4: VERIFICAR CONEXIÓN
---------------------------
1. Abre el archivo: src/java/conexion/conexion.java
2. Verifica que los datos coincidan con tu MySQL:
   - URL: jdbc:mysql://localhost:3306/condimentos_sander
   - USER: root (o tu usuario)
   - PASSWORD: [tu contraseña]
3. Si tu contraseña es diferente, actualízala en el archivo

PASO 5: COMPILAR Y EJECUTAR
----------------------------
1. Click derecho en el proyecto "ProyectoSenaWeb"
2. Selecciona: "Clean and Build"
3. Espera a que diga: "BUILD SUCCESSFUL"
4. Click derecho nuevamente
5. Selecciona: "Run"
6. El navegador se abrirá automáticamente

================================================================================
URLS DEL SISTEMA:
================================================================================

Página Principal:     http://localhost:8080/ProyectoSenaWeb/index.jsp
Login:                http://localhost:8080/ProyectoSenaWeb/login.jsp
Registro:             http://localhost:8080/ProyectoSenaWeb/registro.jsp
Tienda:               http://localhost:8080/ProyectoSenaWeb/tienda.jsp
Carrito:              http://localhost:8080/ProyectoSenaWeb/carrito.jsp

================================================================================
USUARIOS DE PRUEBA:
================================================================================

USUARIO CLIENTE:
----------------
Correo:     ivanjoseph.ruizbarajas@gmail.com
Contraseña: IvanRB84276

NOTA: Puedes registrar nuevos usuarios desde la opción "¿No tienes cuenta? 
Regístrate" en la página de login.

================================================================================
FUNCIONALIDADES IMPLEMENTADAS:
================================================================================

✅ Módulo de Autenticación
   - Registro de nuevos usuarios
   - Inicio de sesión con validación
   - Cierre de sesión
   - Protección de páginas por sesión

✅ Módulo de Tienda
   - Catálogo de productos
   - Visualización de precios y empaques
   - Selección de cantidad

✅ Módulo de Carrito
   - Añadir productos al carrito
   - Ver resumen de compra
   - Eliminar productos individuales
   - Vaciar carrito completo
   - Contador de productos en navbar

✅ Base de Datos
   - Usuarios registrados en MySQL
   - Productos almacenados en MySQL
   - Relaciones entre tablas configuradas

