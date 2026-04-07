package calculadora;
/**
 * @author AlejandroDonGar
 * @version 1.0.0
 * Clase Main para probar el funcionamiento de la clase CalculadoraNotas
 */
public class Main {
    public static void main(String[] args) {
        //<--------------------------------------------------------------------------------------> Caso 1: varias notas
        System.out.println("Caso 1: varias notas");

        try {
            double media1 = CalculadoraNotas.calcularMedia(new int[]{6, 7, 8});
            System.out.println("Media: " + media1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        //<--------------------------------------------------------------------------------------> > Caso 2: una sola nota
        System.out.println("Caso 2: una sola nota");

        try {
            double media2 = CalculadoraNotas.calcularMedia(new int[]{9});
            System.out.println("Media: " + media2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        //<--------------------------------------------------------------------------------------> caso 3: lista vacía
        System.out.println("Caso 3: lista vacía");

        try {
            double media3 = CalculadoraNotas.calcularMedia(new int[]{});
            System.out.println("Media: " + media3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        //<--------------------------------------------------------------------------------------> Caso 4: nota fuera de rango
        System.out.println("Caso 4: nota fuera de rango");

        try {
            double media4 = CalculadoraNotas.calcularMedia(new int[]{5, 12, 8});
            System.out.println("Media: " + media4);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        //<--------------------------------------------------------------------------------------> Fin de los casos
    }
}
