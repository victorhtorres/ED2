/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oagsoft.grafo.util;

import com.oagsoft.grafo.data.Grafo;
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
public class XMLLoader
{

    public static Grafo leerArchivoXml(String nomArch)
    {
        SAXBuilder builder = new SAXBuilder();
        Grafo g = null;
        try
        {
            Document document = (Document) builder.build(new File(nomArch));
            Element rootNode = document.getRootElement();
            Element nV = rootNode.getChild("numero-vertices");
            int numVertices = Integer.parseInt(nV.getValue().trim());
            g = new Grafo(numVertices);
            Element ad = rootNode.getChild("adyacencias");
            List<Element> hijos = ad.getChildren("adyacencia");
            for (Element hijo : hijos)
            {
                int nIni = Integer.parseInt(hijo.getChildTextTrim("nodo-inicial"));
                int nFin = Integer.parseInt(hijo.getChildTextTrim("nodo-final"));
                g.adyacencia(nIni, nFin);
            }
//            System.out.println("Hay " + hijos.size()+ " adyacencias");
        }
        catch (JDOMException | IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return g;
    }

}
