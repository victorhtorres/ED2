package App;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author vtorr_000
 */
public class Jugador extends Thread {

  private HashMap<String, LinkedList<Integer>> jugador;
  private boolean activo = true;
  private double valMin;
  private double valMax;
  private App conexion;
  private transient final PropertyChangeSupport propertyChangeSupport;

  public Jugador(String name, double valMin, double valMax, App conexion) {
    super(name);
    this.valMin = valMin;
    this.valMax = valMax;
    activo = true;
    jugador = new HashMap<>();
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  /**
   * Add PropertyChangeListener.
   *
   * @param listener
   */
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  /**
   * Remove PropertyChangeListener.
   *
   * @param listener
   */
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  /**
   * Get the value of valMax
   *
   * @return the value of valMax
   */
  public double getValMax() {
    return valMax;
  }

  /**
   * Set the value of valMax
   *
   * @param valMax new value of valMax
   */
  public void setValMax(double valMax) {
    this.valMax = valMax;
  }

  /**
   * Get the value of valMin
   *
   * @return the value of valMin
   */
  public double getValMin() {
    return valMin;
  }

  /**
   * Set the value of valMin
   *
   * @param valMin new value of valMin
   */
  public void setValMin(double valMin) {
    this.valMin = valMin;
  }

  /**
   * Get the value of activo
   *
   * @return the value of activo
   */
  public synchronized boolean isActivo() {
    return activo;
  }

  /**
   * Set the value of activo
   *
   * @param activo new value of activo
   */
  public synchronized void setActivo(boolean activo) {
    this.activo = activo;
  }

  public LinkedList<Integer> crearTablaBingo() {
    LinkedList<Integer> listNum = new LinkedList<>();
    double delta = valMax - valMin;
    Random r = new Random();
    while (listNum.size() < 26) {
      double valorNuevo = (r.nextDouble() * delta) + valMin;
      listNum.add((int) valorNuevo);
    }
    return listNum;
  }
  
  public synchronized LinkedList<String> crearJugador(){
    LinkedList<String> list = new LinkedList<>();
    int idJugador = 1;
    while(activo){
      list.add("Jugador " + idJugador);
      idJugador ++;
    }
    return list;
  }
  
  public synchronized HashMap<String, LinkedList<Integer>> compararTablasBingo(HashMap<String, LinkedList<Integer>> jugador, LinkedList<Integer> tablasCasino ){

    return jugador;
  }

  @Override
  public void run() {
    super.run();
    int cont = 1;
    LinkedList<Integer> bingoCasino = new LinkedList<>();
    while (activo) {
      jugador.put(crearJugador().get(cont), crearTablaBingo());
      conexion.recibir(compararTablasBingo(jugador, conexion.getBingoCasino()));
    }
  }

}
