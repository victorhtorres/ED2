package org.hilos.app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 *
 * @author oarcila
 */
public class Hilo extends Thread {

  private int tiempoMuerto;
  private boolean activo;
  private double valMin;
  private double valMax;
  private transient final PropertyChangeSupport propertyChangeSupport;

  public Hilo(int tiempoMuerto, String name, double valMin, double valMax) {
    super(name);
    this.tiempoMuerto = tiempoMuerto;
    this.valMin = valMin;
    this.valMax = valMax;
    activo = true;
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

  /**
   * Get the value of tiempoMuerto
   *
   * @return the value of tiempoMuerto
   */
  public synchronized int getTiempoMuerto() {
    return tiempoMuerto;
  }

  /**
   * Set the value of tiempoMuerto
   *
   * @param tiempoMuerto new value of tiempoMuerto
   */
  public synchronized void setTiempoMuerto(int tiempoMuerto) {
    this.tiempoMuerto = tiempoMuerto;
  }

  @Override
  public void run() {
    super.run();
    Random r = new Random();
    double delta = valMax - valMin;

    while (activo) {
      try {
        sleep(tiempoMuerto);
        double valorNuevo = (r.nextDouble() * delta) + valMin;
        //System.out.println("Este es el hilo " + getName() + " valor " + valorNuevo);
        propertyChangeSupport.firePropertyChange(getName(), null, valorNuevo);
      } catch (InterruptedException ex) {
      }
    }
  }

}
