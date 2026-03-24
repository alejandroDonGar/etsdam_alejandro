package calculadora.src.test.java.calculadora;

import calculadora.src.main.java.calculadora.CalculadoraNotas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotasTest {

    @Test
    void testMediaSimple() {
    assertEquals(7.0, CalculadoraNotas.calcularMedia(new int[] { 6, 7, 8 }), 0.0001);
    }

    @Test
    void testMediaDecimal() {
    assertEquals(8.5, CalculadoraNotas.calcularMedia(new int[] { 10, 9, 8, 7 }), 0.0001);
    }

    @Test
    void testMediaListaVacia() {
    assertThrows(IllegalArgumentException.class, () -> CalculadoraNotas.calcularMedia(new int[] {}));
    }

    @Test
    void testMediaNull() {
    assertThrows(IllegalArgumentException.class, () -> CalculadoraNotas.calcularMedia(null));
    }
}