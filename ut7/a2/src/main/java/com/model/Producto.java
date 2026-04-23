package com.model;
/**
 * @author Juan Pablo, Jorge y Alejandro
 * @version 1.0.0
 */
import java.util.Objects;
/**
 * Clase que representa un producto de la tienda.
 */
public class Producto {
    private Long id;
    private String nombre;
    private Double precio;
    private int complemento;
    /**
     * Constructor vacío.
     */
    public Producto() {}
    /**
     * Constructor con id.
     * @param id identificador del producto
     */
    public Producto(Long id) {
        this.id = id;
    }
    /**
     * Constructor completo.
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param cantidad cantidad del producto
     */
    public Producto(Long id, String nombre, Double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.complemento = cantidad;
    }
    /**
     * Metodo para obtener el id del producto.
     * @return Devuelve el id del producto.
     */
    public Long getId() {
        return id;
    }
    /**
     * Metodo para establecer el id del producto.
     * @param id Parametro id para establecer el id del producto.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Metodo para obtener el nombre del producto.
     * @return Devuelve el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para establecer el nombre del producto.
     * @param nombre Parametro nombre para establecer el nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para obtener el precio del producto.
     * @return Devuelve el precio del producto.
     */
    public Double getPrecio() {
        return precio;
    }
    /**
     * Metodo para establecer el precio del producto.
     * @param precio Parametro precio para establecer el precio del producto.
     */

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    /**
     * Metodo para obtener el complemento del producto.
     * @return Devuelve el complemento del producto.
     */
    public int getComplemento() {
        return complemento;
    }
    /**
     * Metodo para establecer el complemento del producto.
     * @param complemento Parametro complemento para establecer el complemento del producto.
     */
    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }
    /**
     * Metodo toString para representar el producto como una cadena de texto.
     * @return Devuelve una cadena de texto que representa el producto.
     */
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", complemento=" + complemento + "]";
    }
    /**
     * Metodo hashCode para generar un código hash del producto basado en su id.
     * @return Devuelve un código hash del producto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /**
     * Metodo equals para comparar dos productos basados en su id.
     * @param obj Objeto a comparar con el producto actual.
     * @return Devuelve true si los productos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) obj;
        return Objects.equals(id, other.id);
    }
}