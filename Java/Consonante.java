
public class Consonantes {


// Recursiva de pila
  
  public static String extraerConsonantes(String cadena) {
    cadena = cadena.toUpperCase();
    if (cadena.isEmpty()) {
      return "";
    } else {
      char temp = cadena.charAt(cadena.length()-1);
      if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
        return extraerConsonantes(cadena.substring(0, cadena.length()-1));
      } 
      return extraerConsonantes(cadena.substring(0, cadena.length()-1)) + cadena.charAt(cadena.length()-1);
    }
  }
 
  
}
