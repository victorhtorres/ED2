
public class InvertirCadena {

  public static String revertir(String palabra) {
    if (palabra.length() == 1) {
      return palabra;
    } else {
      return revertir(palabra.substring(1)) + palabra.charAt(0);
    }
  }

  
// Recursiva de cola

public static String revertirCola (String palabra) {
  String invertido = "";
  return invertirColaExtend (palabra, invertido);
}

  private static String invertirColaExtend(String palabra, String invertido) {
    if (palabra.length() == 1){
      return palabra + invertido;
    } else {
      return invertirColaExtend(palabra.substring(1), palabra.charAt(0) + invertido);
    }
  }
  
}

