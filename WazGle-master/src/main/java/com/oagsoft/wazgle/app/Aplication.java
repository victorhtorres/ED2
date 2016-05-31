package com.oagsoft.wazgle.app;

import com.oagsoft.grafo.data.Grafo;
import com.oagsoft.wazgle.data.GraphicNode;
import com.oagsoft.wazgle.data.GraphicObject;
import com.oagsoft.wazgle.view.MapPanel;
import com.oagsoft.wazgle.tools.FactoryItem;
import com.oagsoft.wazgle.tools.XMLLoader;
import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author oarcila
 */
public class Aplication extends JFrame implements ActionListener {

  private MapPanel panel;
//  private LinkedList<GraphicObject> elementsGraph;
  private Grafo<GraphicNode> g;

  public Aplication(String title) {
    super(title);

    createGUI();
  }

  /**
   * Metodo que permite craer la interfaz grafica de usuario.
   */
  //<editor-fold defaultstate="collapsed" desc="Metodo :: 'createGUI()'">
  private void createGUI() {
    // TODO: Esta linea se debe reemplazar por la lectura del archivo xml.
    this.g = XMLLoader.leerArchivoXml("grafo.xml");
    //elementsGraph = FactoryGraph.create();
    panel = new MapPanel("ImgMap.png", "ImgSat.png", this.g);
    add(BorderLayout.CENTER, panel);
    setJMenuBar(createBarMenu());
    setSize(panel.getMapSize());
    setResizable(false);
  }
  //</editor-fold>

  /**
   * Creación de menu
   *
   * @return El Menu que se le asigna a la aplicación.
   */
  // <editor-fold defaultstate="collapsed" desc="Metodo :: 'createBarMenu ()'">
  private JMenuBar createBarMenu() {
    JMenuBar miBarraMenu = new JMenuBar();
    JMenu subMenu = null;

    subMenu = new JMenu("Opciones");
    subMenu.add(FactoryItem.createMenuItem("Búsqueda Amplitud", "busquedaAmplitud", this, KeyEvent.VK_A));
    subMenu.addSeparator();
    subMenu.add(FactoryItem.createMenuItem("Búsqueda Profundidad", "busquedaProfundidad", this, KeyEvent.VK_P));
    subMenu.addSeparator();
    subMenu.add(FactoryItem.createMenuItem("Salir", "salir", this, KeyEvent.VK_S));
    miBarraMenu.add(subMenu);

    subMenu = new JMenu("Herramientas");
    subMenu.add(FactoryItem.createMenuItem("Mostrar Grafo", "mostrarGrafo", this, KeyEvent.VK_M));
    subMenu.add(FactoryItem.createMenuItem("Imagen Satelite", "imagenSatelite", this, KeyEvent.VK_I));
    miBarraMenu.add(subMenu);

    return miBarraMenu;
  }
  // </editor-fold>

  /**
   * Este metodo se lanza cada vez que se activa una opción del menú.
   *
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    switch (command) {
      case "busquedaAmplitud":
        busquedaAmplitud((JMenuItem) e.getSource());
        break;
      case "busquedaProfundidad":
        busquedaProfundidad((JMenuItem) e.getSource());
        break;
      case "mostrarGrafo":
        mostrarGrafo((JMenuItem) e.getSource());
        break;
      case "ocultarGrafo":
        ocultarGrafo((JMenuItem) e.getSource());
        break;
      case "imagenSatelite":
        imagenSatelite((JMenuItem) e.getSource());
        break;
      case "imagenPlano":
        imagenPlano((JMenuItem) e.getSource());
        break;
      case "salir":
        salir();
        break;
    }
  }

  /**
   * Este metodo es el encargado de realizar la búsqueda por amplitud.
   *
   */
  private void busquedaAmplitud(JMenuItem b) {
    panel.busquedaEnAmplitud();
    panel.repaint();
  }

  /**
   * Este metodo es el encargado de realizar la búsqueda por amplitud.
   *
   */
  private void busquedaProfundidad(JMenuItem b) {
    panel.busquedaEnProfundidad();
    panel.repaint();
  }

  /**
   * Este metodo es el encargado de cerrar el puerto serial cuando se cierra
   * también la aplicación.
   */
  // <editor-fold defaultstate="collapsed" desc="Metodo :: 'salir ()'">
  private void salir() {
    dispose();
  }
  // </editor-fold>

  /**
   * Este metodo es el encargado de ocultar el grafo del area visible. Ademas
   * actualiza la opcion del menu.
   */
  // <editor-fold defaultstate="collapsed" desc="Metodo :: 'ocultarGrafo ()'">
  private void ocultarGrafo(JMenuItem b) {
    b.setText("Mostrar Grafo");
    b.setActionCommand("mostrarGrafo");
    panel.setGrafoVisible(!panel.isGrafoVisible());
    panel.repaint();
  }
  // </editor-fold>

  /**
   * Este metodo es el encargado de mostrar el grafo del area visible. Ademas
   * actualiza la opcion del menu.
   */
  // <editor-fold defaultstate="collapsed" desc="Metodo :: 'mostrarNodos ()'">
  private void mostrarGrafo(JMenuItem b) {
    b.setText("Ocultar Grafo");
    b.setActionCommand("ocultarGrafo");
    panel.setGrafoVisible(true);
    panel.repaint();
  }
  // </editor-fold>

  private void imagenSatelite(JMenuItem b) {
    b.setText("Imagen Plano");
    b.setActionCommand("imagenPlano");
    panel.setImagenPlano(true);
    panel.repaint();
  }

  private void imagenPlano(JMenuItem b) {
    b.setText("Imagen Satelite");
    b.setActionCommand("imagenSatelite");
    panel.setImagenPlano(false);
    panel.repaint();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Aplication app = new Aplication("WazGle - Buscador de Caminos");
    app.setVisible(true);
  }

}
