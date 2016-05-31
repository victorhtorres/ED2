package com.oagsoft.grafo.data.tree;

/**
 *
 * @author oarcila
 */
public class Arbol<T> {

    public Nodo<T> raiz;
    public T info;

    public Arbol(T info) {
       
        raiz = new Nodo<>(info,null);
    }

    public void insertar(T info, T val) {
        Nodo<T> encontrado = raiz.buscar(val);
        encontrado.insertar(info);
//        raiz.buscar(padre).insertar(info);
    }
    public Nodo<T> buscar ( T info)
    {
        return raiz.buscar(info);
    }
    @Override
    public String toString ()
    {
        return raiz.toString();
    }
    
     public Nodo getPadre() {
       
        return (Nodo) info;
    
    }
    
}
