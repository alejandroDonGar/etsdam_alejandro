package calculadora;
/**
 * @author AlejandroDonGar
 * @version 1.0.0
 * Clase Main donde probaremos distintos casos para la seguridad del codigo
 */
public class Main {
    public static void main(String[] args) {
        //<------------------------------------------------------------------------>
        // Caso 1: varias notas
        System.out.println("Caso 1: varias notas");
        System.out.println(CalculadoraNotas.calcularMedia(new int[]{6, 7, 8}));

        System.out.println();
        //<------------------------------------------------------------------------>
        // Caso 2: una sola nota
        System.out.println("Caso 2: una sola nota");
        System.out.println(CalculadoraNotas.calcularMedia(new int[]{9}));

        System.out.println();
        //<------------------------------------------------------------------------>
        // Caso 3: lista vacía
        System.out.println("Caso 3: lista vacía");
        try {
            System.out.println(CalculadoraNotas.calcularMedia(new int[]{}));
        } catch (Exception e) {
            System.out.println("Error");
        }

        System.out.println();
        //<------------------------------------------------------------------------>
        // Caso 4: nota fuera de rango
        System.out.println("Caso 4: nota fuera de rango");
        try {
            System.out.println(CalculadoraNotas.calcularMedia(new int[]{5, 12, 8}));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}