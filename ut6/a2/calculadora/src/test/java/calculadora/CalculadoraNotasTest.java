package calculadora.src.test.java.calculadora;
/**
 * @author AlejandroDonGar
 * @version 1.0.0
 * Clase CalculadoraNotasTest
 */
import calculadora.src.main.java.calculadora.CalculadoraNotas;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * Clase CalculadoraNotasTest donde probaremos distintos test para la seguridad del codigo
 */
public class CalculadoraNotasTest {
    @Test
    void testMediaSimple() {
    assertEquals(7.0, CalculadoraNotas.calcularMedia(new int[] { 6, 7, 8 }), 0.0001);
    }
    @Test
    void testMediaDecimal() {
    assertEquals(8.5, CalculadoraNotas.calcularMedia(new int[] { 10, 9, 8, 7 }), 0.0001);
    }
    /**
     * Este test salta cuando se detecta que el calculo de la nota media es vacio
     */
    @Test
    void testMediaListaVacia() {
    assertThrows(IllegalArgumentException.class, () -> CalculadoraNotas.calcularMedia(new int[] {}));
    }
    /**
     * Este test salta cuando se detecta que el calculo de la nota media es nulo
     */
    @Test
    void testMediaNull() {
    assertThrows(IllegalArgumentException.class, () -> CalculadoraNotas.calcularMedia(null));
    }
}