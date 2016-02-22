// Revertir una lista de manera recursiva

import java.util.ArrayList;


public class RevertirLista {
  
  public static String revertirLista(ArrayList miLista) {
    
    if (miLista.isEmpty()) {
      return "";
    } else {
      String temp;
      temp = (String) miLista.get(miLista.size()-1);
      miLista.remove(miLista.size()-1);
      return temp + " " + revertirLista(miLista);
    }
    
  }
  
}
