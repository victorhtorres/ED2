
package com.eda.app;

import com.eda.data.Arbol;

/**
 *
 * @author tp.aulas1
 */
public class Aplicacion
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Arbol<String> arbol = new Arbol<>();
        arbol.insertar("zaragoza");
        arbol.insertar("popayan");
        arbol.insertar("armenia");
        arbol.insertar("palmira");
        arbol.insertar("tulua");
        
        System.out.println("Imprimir arbol:" + arbol);
        System.out.println("Imprimir preOrder:" + arbol.preOrder());
        System.out.println("Imprimir postOrder:" + arbol.postOrder());
        
        String city = arbol.buscar("pitalito");
        if ( city == null) 
        {
            System.out.println("Ciudad no encontrada");
        }
        else
        {
            System.out.println("Encontrada " + city);
        }
    }
    
}
