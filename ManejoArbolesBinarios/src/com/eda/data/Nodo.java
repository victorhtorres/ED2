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

    public T buscar(T info) 
    {
      System.out.println(this.info + "" + info);
        if ( this.info.compareTo(info) == 0)
        {
          
            return this.info;
        }
        else if (this.info.compareTo(info) > 0)
        {
            if ( izq == null)
            {
                return null;
            }
            else
            {
                return izq.buscar(info);
            }
        }
        else
        {
            if ( der == null)
            {
                return null;
            }
            else
            {
                return der.buscar(info);
            }
        }
    }
    
    public String inOrder() 
    {
        String cadInOrder = "";
        
        if(izq!=null)
        {
            cadInOrder += izq.inOrder();
        }
        cadInOrder += " " + info.toString();
        if ( der != null)
        {
            cadInOrder += der.inOrder();
        }
        
        return cadInOrder;
    }

    public String preOrder() {
        String cadPreOrder = "";
        
        cadPreOrder += " " + info.toString();
        if(izq!=null)
        {
            cadPreOrder += izq.preOrder();
        }
        if ( der != null)
        {
            cadPreOrder += der.preOrder();
        }
        
        return cadPreOrder;
    }

    public String postOrder() {
        String cadPostOrder = "";
        
        if(izq!=null)
        {
            cadPostOrder += izq.postOrder();
        }
        if ( der != null)
        {
            cadPostOrder += der.postOrder();
        }
        cadPostOrder += " " + info.toString();
        
        return cadPostOrder;
    }

}
