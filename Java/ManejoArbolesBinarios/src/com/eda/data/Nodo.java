package com.eda.data;

/**
 *
 * @author tp.aulas1
 * @param <T>
 */
public class Nodo <T extends Comparable<T>>
{
    
    private T info;

    private Nodo<T> izq;

    private Nodo<T> der;

    public Nodo(T info)
    {
        this.info = info;
        der = null;
        izq = null;
    }

    /**
     * Get the value of der
     *
     * @return the value of der
     */
    public Nodo<T> getDer()
    {
        return der;
    }

    /**
     * Set the value of der
     *
     * @param der new value of der
     */
    public void setDer(Nodo<T> der)
    {
        this.der = der;
    }

    /**
     * Get the value of izq
     *
     * @return the value of izq
     */
    public Nodo<T> getIzq()
    {
        return izq;
    }

    /**
     * Set the value of izq
     *
     * @param izq new value of izq
     */
    public void setIzq(Nodo<T> izq)
    {
        this.izq = izq;
    }

    /**
     * Get the value of info
     *
     * @return the value of info
     */
    public T getInfo()
    {
        return info;
    }

    /**
     * Set the value of info
     *
     * @param info new value of info
     */
    public void setInfo(T info)
    {
        this.info = info;
    }

    public void insertar ( T info)
    {
        if ( this.info.compareTo(info) > 0)
        {
            if ( izq == null)
            {
                izq = new Nodo<>(info);
            }
            else
            {
                izq.insertar(info);
            }
        }
        else
        {
            if ( der == null)
            {
                der = new Nodo<>(info);
            }
            else
            {
                der.insertar(info);
            }
        }
    }
}
