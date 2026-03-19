package calculadora.src.test.java;
import calculadora.src.main.java.com.example.CalculadoraNotas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculadoraNotasTest {
    @Test
    void testMediaSimple(){
        assertEquals(7, CalculadoraNotas.calcularMedia(new int[]{6,7,8}));
    }
    @Test
    void testMediaListaVacia(){
        assertEquals(new IllegalArgumentException(), CalculadoraNotas.calcularMedia(new int[]{}));
    }
}
