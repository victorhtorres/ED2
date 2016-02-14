
public class PalindromoRecursivo {

  public static boolean esPalindromo(String s) {
    if (s.charAt(0) == s.charAt(0)-32 || s.charAt(0) == ' ' || s.length() == 0) {
      return false;
    }
    if (s.length() == 1) {
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
