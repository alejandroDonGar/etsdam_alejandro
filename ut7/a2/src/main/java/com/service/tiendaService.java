package com.service;
/**
 * @author Juan Pablo, Jorge y Alejandro
 * @version 1.0.0
 */
import java.util.ArrayList;
import java.util.List;
import com.model.Producto;
/**
 * Clase tiendaService donde se implementan los metodos para calcular el subtotal de un producto, el total del pedido y si el cliente es vip o no.
 */
public class tiendaService {
    private List<Producto> productos;
    /**
     * Constructor vacio de tiendaService donde inicializamos la lista de productos.
     */
    public tiendaService() {
        this.productos = new ArrayList<>();
    }
    /**
     * Metodo para agregar un producto a la lista de productos.
     * @param producto Parametro producto a agregar a la lista de productos.
     */
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }
    /**
     * Metodo para obtener la lista de productos.
     * @return
     */
    public List<Producto> getProductos() {
        return productos;
    }
    /**
     * Metodo para calcular el subtotal de un producto.
     * @param producto Parametro producto para calcular el subtotal.
     * @return Devuelve el subtotal del producto.
     */
    public double calcularSubtotalProducto(Producto producto) {
        double subtotal = producto.getPrecio() * producto.getComplemento();
        if (producto.getComplemento() > 2) {
            subtotal -= subtotal * 0.10;
        }
        return subtotal;
    }
    /**
     * Metodo para calcular el total del pedido.
     * @return Devuelve el total del pedido.
     */
    public double calcularTotalPedido() {
        double total = 0;
        for (Producto producto : productos) {
            double subtotal = calcularSubtotalProducto(producto);
            if (subtotal <= 100) {
                subtotal += 5;
            }
            total += subtotal;
        }
        return total;
    }
    /**
     * Metodo para verificar si el cliente es vip.
     * @return Devuelve true si el cliente es vip, false en caso contrario.
     */
    public boolean esClienteVip() {
        return calcularTotalPedido() > 500;
    }
}