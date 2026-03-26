package com.tienda;
/**
 * @author AlejandroDonGar
 * @version 1.0.0
 * Clase Producto
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    /**
     * Constructor completo de la clase Producto
     * @param nombre
     * @param precio
     * @param cantidad
     */
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    /**
     * Getter del parametro nombre
     * @return El valor del parametro nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del parametro precio
     * @return El valor del parametro precio
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Getter del parametro cantidad
     * @return El valor del parametro cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
}