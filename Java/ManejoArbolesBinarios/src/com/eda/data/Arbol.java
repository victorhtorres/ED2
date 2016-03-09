package com.eda.data;

/**
 *
 * @author tp.aulas1
 * @param <T>
 */
public class Arbol<T extends Comparable<T>>
{
    private Nodo<T> raiz;
    
    public Arbol ()
    {
        raiz = null;
    }
    
    public void insertar(T info)
    {
        if ( raiz != null)
        {
            raiz = new Nodo<>(info);
        }
        else
        {
            raiz.insertar(info);
        }
    }
}
