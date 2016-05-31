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

        int vIni = 4;
        int vFin = 6;
        LinkedList<Integer> caminoProf = finder.busquedaCaminoProfundidad(vIni, vFin);
        System.out.println("Camino en profundidad --> " + caminoProf);
        LinkedList<Integer> caminoAmp = finder.busquedaCaminoAmplitud(vIni, vFin);
        if (caminoAmp.isEmpty()){
          System.out.println("No existe camino para el dato ingresado.");
        } else {
          System.out.println("Camino en amplitud --> " + caminoAmp);
        }
        
    }

}
