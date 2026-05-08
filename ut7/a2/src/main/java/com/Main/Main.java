package com.Main;
/**
 * @author Juan Pablo, Jorge y Alejandro
 * @version 1.0.0
 */
import com.model.Producto;
import com.service.tiendaService;
import com.Utils.Validaciones;
/**
 * Clase Main donde se ejecuta el programa y se crean los productos, se agregan a la tienda y se muestran los resultados.
 */
public class Main {
    public static void main(String[] args) {
        tiendaService tienda = new tiendaService();
        /**
         * Creamos tres productos con sus respectivos id, nombre, precio y cantidad, y los agregamos a la tienda si son validos.
         */
        Producto producto1 = new Producto(1L, "Teclado", 30.0, 2);
        Producto producto2 = new Producto(2L, "Raton", 20.0, 3);
        Producto producto3 = new Producto(3L, "Monitor", 2.0, 1);
        /**
         * Agregamos los productos a la tienda si son validos, utilizando el metodo agregarSiEsValido que valida cada producto antes de agregarlo a la tienda.
         * Si el producto no es valido, se muestra un mensaje indicando que el producto no es valido.
         */
        agregarSiEsValido(tienda, producto1);
        agregarSiEsValido(tienda, producto2);
        agregarSiEsValido(tienda, producto3);
        /**
         * Mostramos los detalles de cada producto, su subtotal, el costo de envio y el total del pedido.
         */
        for (Producto producto : tienda.getProductos()) {
            double subtotal = tienda.calcularSubtotalProducto(producto);

            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getComplemento());
            System.out.println("Subtotal: " + subtotal);
            /**
             * Si el subtotal es mayor que 100, el envio es gratis, de lo contrario, el envio cuesta 5 euros.
             */
            if (subtotal > 100) {
                System.out.println("Envio gratis");
            } else {
                System.out.println("Envio: 5 euros");
            }
            System.out.println("-------------------");
        }
        /**
         * Calculamos el total del pedido utilizando el metodo calcularTotalPedido de la tienda, y mostramos el total del pedido. Si el cliente es VIP, se muestra un mensaje indicando que el cliente es VIP.
         */
        double total = tienda.calcularTotalPedido();
        System.out.println("TOTAL PEDIDO: " + total);
        /**
         * Si el total del pedido es mayor que 500, el cliente es VIP, y se muestra un mensaje indicando que el cliente es VIP. De lo contrario, no se muestra nada.
         */
        if (tienda.esClienteVip()) {
            System.out.println("Cliente VIP");
        }
    }
    /**
     * Metodo para agregar un producto a la tienda si es valido.
     * @param tienda tienda a la que se agregara el producto
     * @param producto producto a agregar a la tienda
     */
    public static void agregarSiEsValido(tiendaService tienda, Producto producto) {
        if (Validaciones.validarId(producto.getId()) &&
            Validaciones.validarNombre(producto.getNombre()) &&
            Validaciones.validarPrecio(producto.getPrecio()) &&
            Validaciones.validarCantidad(producto.getComplemento())) {
            tienda.agregarProducto(producto);
        } else {
            System.out.println("Producto no valido: " + producto);
        }
    }
}