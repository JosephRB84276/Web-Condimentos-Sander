/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Producto {
    
    private int id_producto;
    private String Nombre;
    private String Descripcion;
    private double Precio;
    private String Cantidad_empaque;
    private int Stock;
    
    public Producto() {}
    
    public int getId_producto() { return id_producto; }
    public void setid_producto(int id_producto) { this.id_producto = id_producto; }
    
    public String getNombre() { return Nombre; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    
    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String Descripcion) { this.Descripcion = Descripcion; }
    
    public double getPrecio() { return Precio; }
    public void setPrecio(double Precio) { this.Precio = Precio; }
    
    public String getCantidad_empaque() { return Cantidad_empaque; }
    public void setCantidad_empaque(String Cantidad_empaque) { this.Cantidad_empaque = Cantidad_empaque; }
    
    public int getStock() { return Stock; }
    public void setStock(int Stock) { this.Stock = Stock; }
}