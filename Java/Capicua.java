// Validar si un número es capicua o no por método recursivo.

/*
*
* Capicua: Es un número que al leerlo de derecha a izquierda y de izquierda a derecha, tienen el mismo significado.
* Objetivo: Por medio de la operación módulo % podemos obtener la unidad del número (el último dígito) y convertirlo
* a centena, decena o la unidad que se necesite (invertirlo e irlo acumulando). Al final debemos ir descomponiendo el número y
* esto se hace por medio de la división, hasta llegar a cero.
* Caso base: Cuando el número ingresado sea igual a 0, retorna el número invertido.
* Caso general: Llamar de manera recursiva el método que descompone el número y lo invierte: esCapicua(n/10, #invertido, #resto).
*
*/

// Recursión de cola

public class Capicua {

  public static boolean esCapicua(int n) {
    int invertido = 0, resto = 0;
    return esCapicua(n, invertido, resto) == n; // al invertir el número, al final se va a comparar con el original y deberán ser iguales.
  }

  private static int esCapicua(int n, int invertido, int resto) {
    if (n == 0) {
      return invertido;
    } else {
      resto = n % 10;
      invertido = invertido * 10 + resto;
      return esCapicua(n / 10, invertido, resto);
    }
  }

}
