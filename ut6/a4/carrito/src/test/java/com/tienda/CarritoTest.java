package com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CarritoTest {

    @Test
    void testSubtotalVariosProductos() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 30, 2),
            new Producto("raton", 10, 1)
        );

        assertEquals(70, CarritoService.calcularSubtotal(carrito));
    }

    @Test
    void testSubtotalUnProducto() {
        List<Producto> carrito = List.of(
            new Producto("monitor", 100, 1)
        );

        assertEquals(100, CarritoService.calcularSubtotal(carrito));
    }

    @Test
    void testSubtotalCarritoVacio() {
        List<Producto> carrito = List.of();

        assertEquals(0, CarritoService.calcularSubtotal(carrito));
    }

    @Test
    void testDescuento0() {
        assertEquals(100, CarritoService.aplicarDescuento(100, 0));
    }

    @Test
    void testDescuentoValido() {
        assertEquals(90, CarritoService.aplicarDescuento(100, 10));
    }

    @Test
    void testDescuento100() {
        assertEquals(0, CarritoService.aplicarDescuento(100, 100));
    }

    @Test
    void testDescuentoInvalidoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarritoService.aplicarDescuento(100, -5);
        });
    }

    @Test
    void testDescuentoInvalidoMayor100() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarritoService.aplicarDescuento(100, 120);
        });
    }

    @Test
    void testEnvioMenor100() {
        assertEquals(5, CarritoService.calcularEnvio(50));
    }

    @Test
    void testEnvioMayorIgual100() {
        assertEquals(0, CarritoService.calcularEnvio(100));
    }

    @Test
    void testTotalSinDescuento() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 50, 1)
        );

        assertEquals(55, CarritoService.calcularTotal(carrito, 0));
    }

    @Test
    void testTotalConDescuento() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 100, 1)
        );

        assertEquals(90, CarritoService.calcularTotal(carrito, 10));
    }

    @Test
    void testTotalEnvioGratis() {
        List<Producto> carrito = List.of(
            new Producto("teclado", 120, 1)
        );

        assertEquals(120, CarritoService.calcularTotal(carrito, 0));
    }
}