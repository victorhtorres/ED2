
public class Consonantes {

  public static String extraerConsonantes(String cadena) {
    
    if (cadena.isEmpty()) {
      
      return "";
      
    } else {
      
      char temp = cadena.toUpperCase().charAt(cadena.length()-1);
      if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
        
        return extraerConsonantes(cadena.substring(0, cadena.length()-1));
        
      }
      
      return extraerConsonantes(cadena.substring(0, cadena.length()-1)) + cadena.charAt(cadena.length()-1);
      
    }
    
  }
 
}
