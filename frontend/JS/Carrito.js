// Lógica del carrito de compras 

let carritoGuardado = JSON.parse(localStorage.getItem("carrito"));
let carrito = Array.isArray(carritoGuardado) ? carritoGuardado : [];

const botonesAgregar = document.querySelectorAll('.btn-secundary');

if (botonesAgregar.length > 0) {

    botonesAgregar.forEach(boton => {

        boton.addEventListener('click', function() {

            const card = boton.closest('.producto-card');

            const nombre = boton.dataset.nombre;
            const select = card.querySelector('.form-select');
            const cantidadInput = card.querySelector('.cantidad');

            const precio = parseInt(select.value);
            const cantidad = parseInt(cantidadInput.value);
            const tipo = select.options[select.selectedIndex].text;

            agregarAlCarrito(nombre, precio, cantidad, tipo);
        });

    });
}

const listaCarrito = document.getElementById('lista-carrito');
const totalCompra = document.getElementById('total-compra');
const productosVacios = document.getElementById('productos-vacios');
const contadorCarrito = document.getElementById('contador-carrito');


function actualizarCarrito() {

    if (listaCarrito && totalCompra) {

        if (carrito.length === 0) {

            if (productosVacios) {
                productosVacios.style.display = 'block';
            }

            listaCarrito.innerHTML = "";
            totalCompra.textContent = "0.00";

        } else {

            if (productosVacios) {
                productosVacios.style.display = 'none';
            }

            listaCarrito.innerHTML = "";

            let total = 0;

            carrito.forEach(producto => {

                total += producto.precio * producto.cantidad;

                listaCarrito.innerHTML += `
                    <p>
                        ${producto.nombre} (${producto.tipo}) - 
                        ${producto.cantidad} x $${producto.precio}
                    </p>
                `;
            });

            totalCompra.textContent = total.toFixed(2);
        }
    }

    // Actualizar contador
    if (contadorCarrito) {

        let cantidadTotal = 0;

        carrito.forEach(producto => {
            cantidadTotal += producto.cantidad;
        });

        contadorCarrito.textContent = `(${cantidadTotal})`;
    }

    localStorage.setItem("carrito", JSON.stringify(carrito));
}



function agregarAlCarrito(nombre, precio, cantidad, tipo) {

    // 🔥 VALIDACIÓN DE CANTIDAD
    if (cantidad <= 0 || isNaN(cantidad)) {
        alert("La cantidad debe ser mayor a 0");
        return;
    }

    const productoExistente = carrito.find(
        p => p.nombre === nombre && p.tipo === tipo
    );

    if (productoExistente) {
        productoExistente.cantidad += cantidad;
    } else {
        carrito.push({
            nombre: nombre,
            tipo: tipo,
            precio: precio,
            cantidad: cantidad
        });
    }

    actualizarCarrito();
}

function vaciarCarrito() {
    carrito = [];
    actualizarCarrito();
}

actualizarCarrito();


