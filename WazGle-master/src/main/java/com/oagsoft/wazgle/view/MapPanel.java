package com.oagsoft.wazgle.view;

import com.oagsoft.grafo.data.BuscadorCaminos;
import com.oagsoft.grafo.data.Grafo;
import com.oagsoft.wazgle.data.GraphicCombo;
import com.oagsoft.wazgle.data.GraphicEdge;
import com.oagsoft.wazgle.data.GraphicNode;
import com.oagsoft.wazgle.data.GraphicObject;
import com.oagsoft.wazgle.data.GraphicTrack;
import com.oagsoft.wazgle.tools.FactoryCombo;
import com.oagsoft.wazgle.tools.Search;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author oarcila
 */
public class MapPanel extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage imageShow;
    private BufferedImage imageMap;
    private BufferedImage imageSat;
    private Grafo<GraphicNode> graphElement;
    LinkedList<GraphicNode> camino;
    private boolean grafoVisible;
    private GraphicTrack mouseIndicator;

    private GraphicCombo comboIni;
    private GraphicCombo comboFin;

    public MapPanel(String fileA, String fileB, Grafo<GraphicNode> graphElement) {
        try {
            imageMap = ImageIO.read(new File(fileA));
            imageSat = ImageIO.read(new File(fileB));
            imageShow = imageMap;
        } catch (IOException ex) {
            imageShow = null;
        }

        this.graphElement = graphElement;
        grafoVisible = false;

        mouseIndicator = new GraphicTrack(new Point(-50, -50));
        comboIni = comboFin = null;

        camino = null;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * Get the value of grafoVisible
     *
     * @return the value of grafoVisible
     */
    public boolean isGrafoVisible() {
        return grafoVisible;
    }

    /**
     * Set the value of grafoVisible
     *
     * @param mostrarNodos new value of grafoVisible
     */
    public void setGrafoVisible(boolean mostrarNodos) {
        this.grafoVisible = mostrarNodos;
    }

    public Dimension getMapSize() {
        return new Dimension(imageShow.getWidth(), imageShow.getHeight());
    }

    @Override
    protected void paintComponent(Graphics gd) {
        super.paintComponent(gd);

        Graphics2D g = (Graphics2D) gd;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (imageShow != null) {
            g.drawImage(imageShow, 0, 0, this);
            if (grafoVisible) //si ya se calculo el camino entonces se coloca otro if para que tape los ciclos de abajo y un else para que dibuje los nodos que estan en el camino.
            {
                for (Iterator<GraphicNode> it = graphElement.getDatos().keySet().iterator(); it.hasNext();) {
                    GraphicNode element = it.next();
//                    System.out.println("Los vecinos de " + element.getId() + " son:");
                    LinkedList<GraphicNode> veci = graphElement.getDatos().get(element);
                    for (Iterator<GraphicNode> it2 = veci.iterator(); it2.hasNext();) {
                        GraphicNode nodoaux = it2.next();
//                        System.out.println("      " + nodoaux.getId());
                        GraphicEdge edge = new GraphicEdge(element, nodoaux);
                        edge.draw(g);
                    }

                    element.draw(g);
                }
            }
            if (comboIni != null) {
                comboIni.draw(g);
            }
            if (comboFin != null) {
                comboFin.draw(g);
            }
            if (camino != null) {
                Iterator<GraphicNode> it = camino.iterator();
                GraphicNode camIni = it.next();
                camIni.draw(g);
                for (; it.hasNext();) {
                    GraphicNode camFin = it.next();
                    camFin.draw(g);
                    // TODO: Dibujar arista.
                    GraphicEdge edge = new GraphicEdge(camIni, camFin);
                    edge.draw(g);

                    camIni = camFin;
                }
            }
            mouseIndicator.draw(g);
        } else {
            g.drawString("No hay mapa", 200, 200);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (comboIni != null && comboFin == null) {
            Point p = new Point(e.getX(), e.getY());
            LinkedList l = new LinkedList();
            l.addAll(graphElement.getDatos().keySet());
            comboFin = FactoryCombo.create(1, p, l);
        } else if (comboIni == null) {
            Point p = new Point(e.getX(), e.getY());
            LinkedList l = new LinkedList();
            l.addAll(graphElement.getDatos().keySet());
            comboIni = FactoryCombo.create(1, p, l);
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        mouseIndicator.getP().setLocation(x, y);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseIndicator.getP().setLocation(-50, -50);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        mouseIndicator.getP().setLocation(x, y);
        LinkedList l = new LinkedList();
        l.addAll(graphElement.getDatos().keySet());
        procesarCercanias(l, mouseIndicator);
        repaint();
    }

    private void procesarCercanias(LinkedList<GraphicObject> graphElement, GraphicTrack mouseIndicator) {
        LinkedList<GraphicNode> l = new LinkedList<>();
        for (GraphicObject elem : graphElement) {
            if (elem instanceof GraphicNode) {
                l.add((GraphicNode) elem);
            }
        }

        for (Iterator<GraphicNode> it = l.iterator(); it.hasNext();) {
            GraphicNode elem = it.next();
            Point pI = elem.getP();
            Point pF = mouseIndicator.getP();
            if (Point.distance((double) pI.x, (double) pI.y, (double) pF.x, (double) pF.y) < 30) {
                elem.setSeleccionado(true);
            } else {
                elem.setSeleccionado(false);
            }
        }
    }

    public void setImagenPlano(boolean b) {
        if (b) {
            imageShow = imageSat;
        } else {
            imageShow = imageMap;
        }
    }

    public void busquedaEnAmplitud() {
        BuscadorCaminos<GraphicNode> finder = new BuscadorCaminos<>(graphElement);
        LinkedList lIni = new LinkedList();
        lIni.addAll(graphElement.getDatos().keySet());
        GraphicNode vIni = Search.buscarMasCercano(comboIni.getEdge().getvIni().getP(), lIni);
        LinkedList lFin = new LinkedList();
        lFin.addAll(graphElement.getDatos().keySet());
        GraphicNode vFin = Search.buscarMasCercano(comboFin.getEdge().getvIni().getP(), lFin);
        camino = finder.busquedaCaminoAmplitud(vIni, vFin);
        for (GraphicNode paso : camino) {
            System.out.println(paso.getId());
        }
        if (camino.size() == 0) {
            camino = null;
        }
    }

    public void busquedaEnProfundidad() {
        BuscadorCaminos<GraphicNode> finder = new BuscadorCaminos<>(graphElement);
        LinkedList lIni = new LinkedList();
        lIni.addAll(graphElement.getDatos().keySet());
        GraphicNode vIni = Search.buscarMasCercano(comboIni.getEdge().getvIni().getP(), lIni);
        LinkedList lFin = new LinkedList();
        lFin.addAll(graphElement.getDatos().keySet());
        GraphicNode vFin = Search.buscarMasCercano(comboFin.getEdge().getvIni().getP(), lFin);
        camino = finder.busquedaCaminoProfundidad(vIni, vFin);
        for (GraphicNode paso : camino) {
            System.out.println(paso.getId());
        }
        if (camino.size() == 0) {
            camino = null;
        }
    }

}
