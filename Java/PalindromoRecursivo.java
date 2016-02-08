
public class Palindromo {

  public static boolean esPalindromo(String cadena) {
    if (cadena.equals(" ") || cadena.length() < 2) {
      return true;
    }
    char compare1 = cadena.charAt(0);
    char compare2 = cadena.charAt(cadena.length()-1);
    if (compare1 == (compare2)) {
      return esPalindromo(cadena.substring(1, cadena.length() - 2));

    } else {
      return false;
    }
  }

}
