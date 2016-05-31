package com.oagsoft.grafo.data.tree;

import java.util.LinkedList;

/**
 *
 * @author oarcila
 */
public class Nodo<T> {

  public T info;
  Nodo<T> padre;
  private LinkedList<Nodo<T>> ady;

  public Nodo(T info, Nodo<T> padre) {
    this.info = info;
    this.padre = padre;
    ady = new LinkedList<>();
  }

  public void insertar(T info) {
    ady.add(new Nodo<>(info, this));
  }

//    //METODO TAREA
//    public Nodo<T> buscar(T info){
//        Nodo<T> encontrado = null;
//        if(this.info != info){
//             for (Nodo<T> nodoHijo:ady){
//                    if(nodoHijo.info==info){
//                    encontrado = nodoHijo;
//                }
//             }
//        }else{
//           return this;
//        }
//        return encontrado;
//  }
  
  public Nodo<T> buscar(T info) {
    Nodo<T> encontrado = null;
    return buscar(info, encontrado);
  }

  private Nodo<T> buscar(T info, Nodo<T> encontrado) {
    if(this.info == info){
      encontrado = this;
      return encontrado;
    } else {
      for (Nodo<T> nodoHijo : ady){
        encontrado = nodoHijo.buscar(info, encontrado);
      }
    }
    
    return encontrado;
  }

  @Override
  public String toString() {
    String cad = info.toString() + ":[";
    for (Nodo<T> hijo : ady) {
      cad += " " + hijo.toString();
    }
    return cad + "]";
  }

  public Nodo getPadre() {

    return (Nodo) padre;

  }

}
