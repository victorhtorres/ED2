package com.oagsoft.grafo.data;

import com.oagsoft.grafo.data.tree.Arbol;
import com.oagsoft.grafo.data.tda.Nodo;
import com.oagsoft.grafo.data.tda.Cola;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author oarcila
 */
public class BuscadorCaminos<T> {

    private Grafo grafo;

    public BuscadorCaminos(Grafo grafo) {
        this.grafo = grafo;
    }

    public LinkedList<Integer> busquedaCaminoProfundidad(int vInicial, int vFinal) {
        LinkedList<Integer> camino = new LinkedList<>();
        LinkedList<Integer> vecinosVisitados = new LinkedList<>();
        camino.add(vInicial);
        vecinosVisitados.add(vInicial);
        LinkedList<Integer> verticesAdyacentes = obtenerAdyacentes(grafo, vInicial);
        int vActual = obtenerVerticeSiguiente(verticesAdyacentes);
        return busquedaCaminoProfundidad(vActual, vFinal, camino, vecinosVisitados);
    }

    private LinkedList<Integer> busquedaCaminoProfundidad(int vIni, int vFin, LinkedList<Integer> camino, LinkedList<Integer> vecinosVisitados) {

        if (vIni == vFin) {
            camino.add(vFin);
            return camino;
        } else {
           
            LinkedList<Integer> verticesAdyacentes = obtenerAdyacentes(grafo, vIni);
            LinkedList<Integer> vecinosNoVisitados = obtenerVerticesNoVisitados(verticesAdyacentes, vecinosVisitados);

            if (!vecinosNoVisitados.isEmpty()) {

                int vActual = obtenerVerticeSiguiente(vecinosNoVisitados);

                camino.add(vIni);
                vecinosVisitados.add(vIni);

                return busquedaCaminoProfundidad(vActual, vFin, camino, vecinosVisitados);
            } else {

                camino.removeLast();
                vIni = camino.removeLast();

                return busquedaCaminoProfundidad(vIni, vFin, camino, vecinosVisitados);
            }

        }
    }

    public LinkedList<Integer> busquedaCaminoAmplitud(int vIni, int vFin) {
        Cola<Nodo<Integer>> cola = new Cola<>();
        LinkedList<Integer> vecinosVisitados = new LinkedList<>();
        Arbol<Integer> arbol = new Arbol(vIni);
        vecinosVisitados.add(vIni);
        
        LinkedList<Integer> verticesAdyacentes = obtenerAdyacentes(grafo, vIni);
        
        for (Integer vertice : verticesAdyacentes) {
            cola.encolar(new Nodo<>(vertice,vIni));
        }
        
        return busquedaCaminoAmplitud(vFin, cola, vecinosVisitados, arbol);
    }

    private LinkedList<Integer> busquedaCaminoAmplitud(int vFin, Cola<Nodo<Integer>> cola,  LinkedList<Integer> vecinosVisitados, Arbol<Integer> arbol) {

        if ( !cola.estaVacia())
        {
            Nodo<Integer> actual = cola.desencolar();
            Integer nodo = actual.getNodo();
            Integer padre = actual.getPadre();
            LinkedList<Integer> verticesAdyacentes = obtenerAdyacentes(grafo, nodo);
            LinkedList<Integer> vecinosNoVisitados = obtenerVerticesNoVisitados(verticesAdyacentes, vecinosVisitados);
            if ( !esVisitado(nodo, vecinosVisitados))
            {
                for (Integer vActual : vecinosNoVisitados) {
                    cola.encolar(new Nodo<>(vActual,nodo));
                }
                arbol.insertar(nodo,padre);
                if(!Objects.equals(nodo, verticesAdyacentes)){
                
                }
                vecinosVisitados.add(nodo);
//                System.out.println("Arbol creado --> " + arbol);
       
            }
            
            return busquedaCaminoAmplitud(vFin, cola,  vecinosVisitados, arbol);
        }
        else
        {
            com.oagsoft.grafo.data.tree.Nodo<Integer> n = arbol.buscar(vFin);
            LinkedList<Integer> camino= new LinkedList<>();
            while (n!=null){
            camino.addFirst(n.info);
            n=n.getPadre();
            }
            return  camino;
        }
    }
    
    private LinkedList<Integer> obtenerAdyacentes(Grafo grafo, int vInicial) {
        LinkedList<Integer> verticesAdyacentes = new LinkedList<>();

        for (int i = 0; i < grafo.getnVertices(); i++) {
            if (grafo.sonAdyacentes(vInicial, i)) {
                verticesAdyacentes.add(i);
            }
        }
        return verticesAdyacentes;
    }

    private LinkedList<Integer> obtenerVerticesNoVisitados(LinkedList<Integer> verticesAdyacentes, LinkedList<Integer> vecinosVisitados) {
        LinkedList<Integer> vecinosNoVisitados = new LinkedList<>();
        
        for (int i = 0; i < verticesAdyacentes.size(); i++) {
            if (!vecinosVisitados.contains(verticesAdyacentes.get(i))) {
                vecinosNoVisitados.add(verticesAdyacentes.get(i));
            }
        }
        return vecinosNoVisitados;
    }

    private int obtenerVerticeSiguiente(LinkedList<Integer> lista) {
        return lista.get((int) (Math.random() * lista.size()));
    }

    private boolean esVisitado(Integer v, LinkedList<Integer> vecinosVisitados) {
        return vecinosVisitados.contains(v);
    }

}
