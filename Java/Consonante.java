
/*
* Consonantes: Son todas las letras del alfabeto a excepción de las vocales (a, e, i, o, u).
* Objetivo: Dado una cadena, extraer todas las vocales y devolver sólo las consonantes.
* Posible solución: Extraer el último caracter y verificar si es una vocal o no. Si es vocal, entonces se debe eliminar
* de la cadena dicho caracter y volver a llamar recursivamente el método. Si no es vocal, entonces se debe eliminar
* dicho caracter para la próxima llamada recursiva del método, pero se deja pendiente una concatenación de la consonante,
* para que, cuando llegue al caso base, empiece a concatenar todos los caracteres que si son consonates y devuelva dicha cadena.
* Caso base: Cuando la cadena esté vacia.
* Caso general: Validar si el último caracter es vocal o no y llamar recursivamente el método con la cadena más reducida.
*/

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
