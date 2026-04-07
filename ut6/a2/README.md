# UT6-A2 Introducción a las pruebas en Java con JUnit

### Objetivo de la práctica

El objetivo de esta práctica es aprender a comprobar el funcionamiento de un programa utilizando diferentes técnicas de prueba:

1. pruebas manuales
2. comprobaciones con de resultados
3. pruebas automatizadas con `JUnit`

### Descripción del programa

Se proporciona una función que calcula la **nota media de un alumno** a partir de una lista de calificaciones.

Las reglas que debe cumplir la función son:

- Recibe una lista de números.
- Cada nota debe estar entre **0 y 10**.
- Devuelve la **media aritmética** de las notas.
- Si la lista está vacía se debe producir un **error**.
- Si una nota no es válida se debe producir un **error**.

```java
public class CalculadoraNotas {

    public static double calcularMedia(int[] notas) {

        if(notas.length == 0){
            throw new IllegalArgumentException("Lista vacía");
        }

        int suma = 0;

        for(int nota : notas){

            if(nota < 0 || nota > 10){
                throw new IllegalArgumentException("Nota fuera de rango");
            }

            suma += nota;
        }

        return suma / notas.length;
    }
}
```

### Pruebas manuales

Crea un pequeño programa llamado `Main.java` que utilice la función `calcular_media` y prueba distintos casos.

Debes comprobar al menos:

- varias notas

- una sola nota

- lista vacía

- nota fuera de rango

Usa la función `System.out.println()` para observar los resultados. Ejemplo:

```java
if(CalculadoraNotas.calcularMedia(new int[]{6,7,8}) != 7){
    System.out.println("Error en el cálculo de la media");
}
```


Inserta el código del programa aquí:

```java
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
```

Adjunta una captura de pantalla de la terminal de:

## Varias notas:

![V.Notas](img/Varias%20Notas.png)

## Una sola nota:

![U.Nota](img/Una%20Nota%20Sola.png)

## Lista vacía

![L.Vacia](img/Lista%20Vacia.png)

## Nota fuera de rango

![F.Rango](img/Nota%20Fuera%20de%20Rango.png)

### Tests con **JUnit**

Crea una clase llamada `CalculadoraNotasTest.java`, debes implementar **al menos 5 tests**, incluyendo:

+ cálculo correcto de media

+ media con decimales

+ lista vacía

+ nota fuera de rango

Ejemplo de test:

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotasTest {

    @Test
    void testMediaSimple(){
        assertEquals(7, CalculadoraNotas.calcularMedia(new int[]{6,7,8}));
    }

}
```

Inserta el código del programa aquí con todos los tests:

```java
package calculadora;
/**
 * @author AlejandroDonGar
 * @version 1.0.0
 * Clase CalculadoraNotas que usamos para calcular notas 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
/**
 * Clase CalculadoraNotasTest donde probaremos distintos test para la seguridad del codigo
 */
public class CalculadoraNotasTest {
    /**
     * Este test comprueba que el calculo de la nota media es correcto
     */
    @Test
    void testMediaSimple() {
        assertEquals(7.0, CalculadoraNotas.calcularMedia(new int[]{6, 7, 8}));
    }
    /**
     * Este test comprueba que el calculo de la nota media es correcto con decimales
     */
    @Test
    void testMediaDecimal() {
        assertEquals(8.5, CalculadoraNotas.calcularMedia(new int[]{10, 9, 8, 7}));
    }
    /**
     * Este test comprueba que el calculo de la nota media es correcto con una sola nota
     */
    @Test
    void testUnaSolaNota() {
        assertEquals(9.0, CalculadoraNotas.calcularMedia(new int[]{9}));
    }
    /**
     * Este test salta cuando se detecta que el calculo de la nota media es vacio
     */
    @Test
    void testListaVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[]{});
        });
    }
    /**
     * Este test salta cuando se detecta que el calculo de la nota media es nulo
     */
    @Test
    void testNotaFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraNotas.calcularMedia(new int[]{5, 12, 8});
        });
    }
}
```


Ejecuta los tests desde tu **IDE**, si todos los tests son correctos debe aparecer un resultado similiar a:

### Ejecución de los tests

Para poder ejecutar los tests debes tener **JUnit** configurado en tu proyecto.

Puedes ejecutar los tests desde tu IDE (IntelliJ, Eclipse o Visual Studio Code) usando la opción "Run Test" o el panel de testing.

> En Visual Studio Code, asegúrate de tener instalada la extensión "Extension Pack for Java". 
Los tests se pueden ejecutar desde el botón "Run Test" que aparece encima de cada método.


```
Tests run: 5
Tests passed: 5
```
### Reflexión final

Responde a las siguientes preguntas:

- ¿Todos tus tests pasan correctamente?
- En caso de que alguno falle, explica por qué.
- ¿Has detectado algún error en el código proporcionado? Explica cuál es.

### Entrega

Debes entregar a traves de tu repositorio de **GitHub** los siguientes archivos:

- Este archivo `README.md` con las capturas de pantalla e inserciones de  solicitadas.
- El archivo `CalculadoraNotas.java`
- El archivo `Main.java`
- El archivo `CalculadoraNotasTest.java`

