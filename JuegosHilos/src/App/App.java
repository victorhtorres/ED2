package App;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author vtorr_000
 */
public class App {
  
  private int cont = 0;
  Casino c;
  Jugador j;
  boolean activo = true;
  LinkedList<Integer> bingoCasino = new LinkedList<>();
  
  public synchronized boolean lanzar(LinkedList<Integer> bingoCasino)  {
    cont++;
    this.bingoCasino = bingoCasino;
    System.out.println("Tablas del casino: " + bingoCasino);
    if (cont == 30){
      activo = false;
    }
    return activo;
  }
  
  
  public synchronized LinkedList<Integer> getBingoCasino(){
    return bingoCasino;
  }
  
  
  public synchronized  void recibir(HashMap<String, LinkedList<Integer>> ganador) {

     System.out.println("Ganadores\n" + ganador);
   
  }
  
  
  public static void main(String[] args) {
    new Casino("casino", 1, 50, new App()).start();
  }
  
}
