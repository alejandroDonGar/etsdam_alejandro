En el desarrollo de software, antes de implementar pruebas automatizadas es necesario analizar el comportamiento esperado del programa y diseñar los casos de prueba que permitirán verificar su correcto funcionamiento.

En esta actividad trabajarás como parte de un equipo de control de calidad (QA) encargado de analizar una función desarrollada por otro programador.

Tu objetivo será identificar qué situaciones deben probarse y diseñar los casos de prueba necesarios.

# Programa a analizar

Un desarrollador ha implementado una función que calcula la nota media de un alumno a partir de una lista de calificaciones.

La función debe cumplir las siguientes condiciones:

Recibe una lista de números que representan las calificaciones de un alumno.

Cada calificación debe estar comprendida entre 0 y 10.

La función devuelve la media aritmética de las calificaciones.

Si la lista está vacía, la función debe indicar que no es posible calcular la media.

Si alguna de las notas no es numérica o está fuera del rango permitido, se debe producir un error de validación.

Ejemplo de funcionamiento esperado:

|   ENTRADA  | RESULTADO ESPERADO |
|:----------:|:------------------:|
|   [6,7,8]  |          7         |
| [10,9,8,7] |         8,5        |
|     []     |        Error       |
|   [5,12]   |        Error       |
|  [7,"a",5] |        Error       |



# Trabajo a realizar

Analiza el comportamiento esperado del programa y diseña una tabla de casos de prueba que permita verificar correctamente su funcionamiento.

Debes incluir al menos:

- 3 casos normales
- 2 casos límite
- 2 casos erróneos

Cada caso de prueba debe indicar:

identificador del caso
datos de entrada
resultado esperado

tipo de caso de prueba

Debes entregar una tabla con el siguiente formato:

|  ID  |            ENTRADA            | RESULTADO | TIPO DE CASO  |
|:----:|:-----------------------------:|:---------:|:-------------:|
| CP1  |  [5,6.3,7.8,9,2.3,6.7,4.21]   |   5.90    |  Caso normal  |
| CP2  |           [-2,12,3]           |   Error   | Caso erróneo |
| CP3  |          [10,10,10]           |   10.0    | Caso límite  |
| CP4  |              [0]              |    0.0    | Caso límite  |
| CP5  |              []               |   Error   | Caso erróneo |
| CP6  | [9.8,2.3,4.5,2.6,8.6,5.4,6.5] |   5.67    |  Caso normal  |
| CP7  |          [420,67,21]          |   Error   | Caso erróneo |
| CP8  | [8.9,7.8,9.9,10,8.6,6.7,9.8]  |   8.81    |  Caso normal  |
| CP9  |             [10]              |   10.0    | Caso límite  |
| CP10 |     [6.7,5.4,6.7,8.4,9.3]     |    7.3    |  Caso normal  |

Tipos de caso posibles:

- Caso normal
- Caso límite
- Caso erróneo

>Importante:
En esta tarea no se debe programar la función ni las pruebas.
El objetivo es diseñar los casos de prueba que permitirán comprobar su funcionamiento.