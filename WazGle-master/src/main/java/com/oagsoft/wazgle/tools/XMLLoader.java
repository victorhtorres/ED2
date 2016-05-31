package com.oagsoft.wazgle.tools;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.oagsoft.grafo.data.Grafo;
import com.oagsoft.wazgle.data.GraphicNode;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author tp.aulas1
 */
public class XMLLoader {

    public static Grafo <GraphicNode> leerArchivoXml(String nomArch) {
        SAXBuilder builder = new SAXBuilder();
        Grafo<GraphicNode> g = null;
        try {
            Document document = (Document) builder.build(new File(nomArch));
            Element rootNode = document.getRootElement();
            Element nV = rootNode.getChild("numero-vertices");
            int numVertices = Integer.parseInt(nV.getValue().trim());
            g = new Grafo(numVertices);
            Element nodos = rootNode.getChild("nodos");
            List<Element> hijos = nodos.getChildren("nodo");
            for (Element hijo : hijos) {
                int id = Integer.parseInt(hijo.getChildTextTrim("id"));
                int coorX = Integer.parseInt(hijo.getChildTextTrim("coor-x"));
                int coorY = Integer.parseInt(hijo.getChildTextTrim("coor-y"));
                GraphicNode nodo = new GraphicNode(id, new Point(coorX, coorY), 10, false);
                g.adVertice(nodo);
                                           }
            Element adyacencias = rootNode.getChild("adyacencias");
            List<Element> ad = adyacencias.getChildren("adyacencia");
            for (Element hijo : ad) {
                int vIni = Integer.parseInt(hijo.getChildTextTrim("nodo-inicial"));
                int vFinal = Integer.parseInt(hijo.getChildTextTrim("nodo-final"));
                GraphicNode nIni = g.getVertice(vIni);
                GraphicNode nFin = g.getVertice(vFinal);
                
                g.adyacencia(nIni, nFin);

            }
//            System.out.println("Hay " + hijos.size()+ " adyacencias");
        } catch (JDOMException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return g;
    }

}
