/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author RYZEN
 */
public class Usuario {
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private String tipo_documento;
    private String numero_documento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo;
    private String contrasena;
    
    // Constructor vacío
    public Usuario() {}
    
    // Constructor completo
    public Usuario(int id_usuario, String nombres, String apellidos, String tipo_documento, 
                   String numero_documento, String ciudad, String direccion, String telefono, 
                   String correo, String contrasena) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    // Getters y Setters (genera con Alt+Insert en NetBeans)
    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
    
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getTipo_documento() { return tipo_documento; }
    public void setTipo_documento(String tipo_documento) { this.tipo_documento = tipo_documento; }
    
    public String getNumero_documento() { return numero_documento; }
    public void setNumero_documento(String numero_documento) { this.numero_documento = numero_documento; }
    
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}