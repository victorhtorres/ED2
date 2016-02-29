/*
* Palindromo: Palabra que al leerse de izquierda a derecha y viceversa, tendrá el mismo significado.
* Posible solución: Primero se debe validar que la cadena no tenga MAYUS, sin espacios y si no está vacia. Si la cadena cumple
* con lo mínimo para evaluar, entonces se compara el primer caracter con el último caracter de la cadena y si son iguales entonces,
* se debe eliminar dichos caracteres y llamar recursivamente el método enviandole la nueva cadena reducida, de tal forma que al haber hecho está comparación y sólo
* quede el caracter del medio de la cadena, entonces se sabrá que es palindrome.
* Caso base: Cuando la cadena sea de tamaño 1.
* Caso general: Llamada recursiva, sustrayendo el primer caracter con el último.
*/


public class PalindromoRecursivo {

  public static boolean esPalindromo(String s) {
    if (s.charAt(0) == s.charAt(0)-32 || s.charAt(0) == ' ' || s.length() == 0) { // la cadena no puede estar en MAYUS, con espacios o vacia.
      return false;
    }
    if (s.length() == 1) { // Cuando ya no quedan más caracteres por extraer y sólo queda el caracter que está en el centro de la cadena.
      return true;
    }
    if (s.charAt(0) == s.charAt(s.length() - 1)) 
    {
      return esPalindromo(s.substring(1, s.length() - 1));
    } else {
      return false;
    }
  }

}
