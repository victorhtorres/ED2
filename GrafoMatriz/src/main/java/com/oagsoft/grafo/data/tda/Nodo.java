package com.oagsoft.grafo.data.tda;

/**
 *
 * @author oarcila
 */
public class Nodo<T> {
    
    private T nodo;

    private T padre;

    public Nodo(T nodo, T padre) {
        this.nodo = nodo;
        this.padre = padre;
    }

    /**
     * Get the value of padre
     *
     * @return the value of padre
     */
    public T getPadre() {
        return padre;
    }

    /**
     * Set the value of padre
     *
     * @param padre new value of padre
     */
    public void setPadre(T padre) {
        this.padre = padre;
    }

    /**
     * Get the value of nodo
     *
     * @return the value of nodo
     */
    public T getNodo() {
        return nodo;
    }

    /**
     * Set the value of nodo
     *
     * @param nodo new value of nodo
     */
    public void setNodo(T nodo) {
        this.nodo = nodo;
    }

    @Override
    public String toString() {
        return "<" + nodo + ": " + padre + ">";
    }

}
