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