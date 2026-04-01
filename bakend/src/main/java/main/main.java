/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.productoDAO;
import modelo.producto;
import java.util.List;

/**
 *
 * @author RYZEN
 */

    
public class main {
    public static void main(String[] args) {
        productoDAO dao = new productoDAO();
        
        
        /*insert
        System.out.println("=== Probando INSERTAR ===");
        producto nuevo = new producto();
        nuevo.setNombre("Pasta de aji");
        nuevo.setDescripcion("Six-Pack");
        nuevo.setPrecio(10000.0);
        nuevo.setCantidad_empaque(30);
        nuevo.setStock(100);
        
        dao.insertar(nuevo);
        
        
        // select
        System.out.println("\n=== Probando LISTAR ===");
        List<producto> productos = dao.listar();
        for (producto prod : productos) {
            System.out.println(prod.getid_producto() + " | " + 
                             prod.getNombre() + " | $" + prod.getPrecio());
        }
        
        //update
        System.out.println("\n=== Probando ACTUALIZAR ===");
        producto editar = dao.buscarPorId(1);  
        if (editar != null) {
            editar.setNombre("Pasta de aji");
            editar.setDescripcion("copa");
            editar.setPrecio(2000.0);
            dao.actualizar(editar);
        }
        */
        //delete
        dao.eliminar(2);
    
    }
}
 

