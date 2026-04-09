/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author RYZEN
 */
public class producto {
    
    private int id_producto;
    private String Nombre;
    private String Descripcion;
    private double Precio;
    private int Cantidad_empaque;
    private int Stock;
    
    public producto() {}
    
    public producto(String Nombre, String Descripcion, double Precio, int Cantidad_empaque, int Stock ) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Cantidad_empaque = Cantidad_empaque;
        this.Stock = Stock;
    }
    
        public producto(int id_producto, String Nombre, String Descripcion, double Precio, int Cantidad_empaque, int Stock ) {
        this.id_producto = id_producto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Cantidad_empaque = Cantidad_empaque;
        this.Stock = Stock;
    }
        
    public int getid_producto() { return id_producto;}
    public String getNombre() { return Nombre;}
    public String getDescripcion() { return Descripcion;}
    public double getPrecio() { return Precio;}
    public int getCantidad_empaque() { return Cantidad_empaque;}
    public int getStock() { return Stock;}
    
    public void setid_producto(int id_producto) {this.id_producto = id_producto;}
    public void setNombre(String Nombre) {this.Nombre = Nombre;}
    public void setDescripcion(String Descripcion) {this.Descripcion = Descripcion;}
    public void setPrecio(double Precio) {this.Precio = Precio;}
    public void setCantidad_empaque(int Cantidad_empaque) {this.Cantidad_empaque = Cantidad_empaque;}
    public void setStock(int Stock) {this.Stock = Stock;}
}
