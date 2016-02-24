// Revertir una lista de manera recursiva

import java.util.ArrayList;


public class RevertirLista {
  
  public static String revertir(ArrayList miLista) {
    if (miLista.isEmpty()) {
      return "";
    } else {
      return miLista.remove(miLista.size()-1) + " " + revertir(miLista);
    }
    
  }
  
}
