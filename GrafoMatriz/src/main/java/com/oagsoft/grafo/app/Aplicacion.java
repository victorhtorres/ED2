package com.oagsoft.grafo.app;

import com.oagsoft.grafo.data.BuscadorCaminos;
import com.oagsoft.grafo.data.Grafo;
import com.oagsoft.grafo.util.XMLLoader;
import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class Aplicacion
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Grafo g = XMLLoader.leerArchivoXml("grafo.xml");
        BuscadorCaminos<Integer> finder = new BuscadorCaminos(g);
        System.out.println(g);

        LinkedList<Integer> caminoProf = finder.busquedaCaminoProfundidad(4, 6);
        System.out.println("Camino en profundidad --> " + caminoProf);
        LinkedList<Integer> caminoAmp = finder.busquedaCaminoAmplitud(4, 6);
        if (caminoAmp.isEmpty()){
          System.out.println("No existe camino para el dato ingresado.");
        } else {
          System.out.println("Camino en amplitud --> " + caminoAmp);
        }
        
    }

}
