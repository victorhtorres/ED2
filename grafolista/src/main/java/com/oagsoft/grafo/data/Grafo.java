package com.oagsoft.grafo.data;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class Grafo<T> {

    private HashMap<T, LinkedList<T>> datos;
//    private int m[][];
//    private int nVertices;

    public Grafo(int nVertices) {
        datos = new HashMap<>();
    }

    public int getnVertices() {
        return datos.size();

    }

    public void adyacencia(T vIni, T vFin) {
        LinkedList<T> lista = new LinkedList<>();

//        m[vIni][vFin] = 1;
//        m[vFin][vIni] = 1;
        if (datos.containsKey(vIni)) {
            lista = datos.get(vIni);
            lista.add(vFin);
            datos.put(vIni, lista);
        } else {
            lista.add(vFin);
            datos.put(vIni, lista);
        }
        
        if ( !datos.containsKey(vFin))
        {
            datos.put(vFin, new LinkedList<T>());
        }

    }
    //</editor-fold>

    public boolean sonAdyacentes(T vIni, T vFin) {
//        return m[vIni][vFin] == 1;
//        LinkedList<T> lista = new LinkedList<>();
//        boolean ady = false;
//        if(datos.containsKey(vIni)){
//           LinkedList<T> lista = datos.get(vIni);
//            if(lista.contains(vFin)){
//                ady = true;
//            }
//        }
        return datos.get(vIni).contains(vFin);
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for (T key : datos.keySet()) {
            string.append(key).append(":").append(datos.get(key)).append("\n");
        }
        return string.toString();
    }

}
