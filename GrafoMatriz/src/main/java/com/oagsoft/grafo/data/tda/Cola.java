package com.oagsoft.grafo.data.tda;

import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class Cola <T>
{
    private LinkedList<T> elems;
    
    public Cola ()
    {
        elems = new LinkedList<>();
    }
    
    public void encolar ( T e)
    {
        elems.addLast(e);
    }
    
    public T desencolar ()
    {
        return elems.removeFirst();
    }
    
    public boolean estaVacia ()
    {
        return elems.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder("[");
        for (T e : elems) {
            cad.append(" ").append(e.toString());
        }
        cad.append("]");
        
        return cad.toString();
    }
    
}
