# El código refactorizado es el siguiente

### Clase *Main*

```java
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
        Producto producto2 = new Producto(2L, "Raton", 15.0, 3);
        Producto producto3 = new Producto(3L, "Monitor", 200.0, 1);
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
```

### Clase *Producto*

```java
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
```

### Clase *tiendaService*

```java
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
```

### Clase *Validaciones*

```java
package com.Utils;
/**
 * @author Juan Pablo, Jorge y Alejandro
 * @version 1.0.0
 */
public class Validaciones {
    private Validaciones() {
        // Evita instancias de una clase utilitaria
    }
    /**
     * Valida que el nombre no sea nulo ni esté vacío.
     * @param nombre nombre del producto
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.isBlank();
    }
    /**
     * Valida que la cantidad sea mayor que 0.
     * @param cantidad cantidad del producto
     * @return true si es válida, false en caso contrario
     */
    public static boolean validarCantidad(int cantidad) {
        return cantidad > 0;
    }
    /**
     * Valida que el id no sea nulo y sea mayor que 0.
     * @param id identificador del producto
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarId(Long id) {
        return id != null && id > 0;
    }
    /**
     * Valida que el precio sea mayor que 0.
     * @param precio precio del producto
     * @return true si es válido, false en caso contrario
     */
    public static boolean validarPrecio(Double precio) {
        return precio != null && precio > 0;
    }
}
```
