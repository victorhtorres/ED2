/*
* Autores:
* Victor Hugo Torres Manrique
* Harry Barrera
* Santiago Paz Cortes
*/

package ed2.promedio;

import java.io.File;
import java.io.IOException;
import java.util.List; // importa el paquete LinkedList
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.util.LinkedList;

public class Aplicacion {

  public static void main(String[] args) {
    LinkedList<Persona> gente = leerArchivo("personas.xml");
      System.out.println("promedio "+promedioEdad(gente));

  }

//Método para lectura de archivo. 
  public static LinkedList<Persona> leerArchivo(String nomArch) {
    //Crea la lista 
    LinkedList<Persona> l = new LinkedList<>();
    // parsear la lista
    SAXBuilder builder = new SAXBuilder();
    try {
      // Se crea el documento a traves del archivo
      Document document = (Document) builder.build(new File(nomArch));
      // Se obtiene la raiz <personas> del xml
      Element rootNode = document.getRootElement();
      // Se obtiene la lista de hijos de la raíz <personas>
      List<Element> list = rootNode.getChildren("persona");
      // Se recorre la lista de hijos de la raíz <personas> del xml
      for (Element item : list) {
        String nombre = item.getChildTextTrim("nombre");
        String identificacion = item.getChildTextTrim("identificacion");
        int edad = Integer.parseInt(item.getChildTextTrim("edad"));
        l.add(new Persona(nombre, edad, identificacion));

      }

    } catch (JDOMException | IOException ex) {
//      System.out.println(ex);
    }

    return l;

  } //fin leerArchivo()

  //Calcular promedio recursivo
  public static double promedioEdad(LinkedList<Persona> gente) {
    return promedioEdad(0,0, gente);
  }

  private static double promedioEdad(int acum, int totalNodos, LinkedList<Persona> gente) {
//      System.out.println(gente.size());
    if(gente.isEmpty()){
        return (double)acum / (double)totalNodos;
      //System.out.println("Promedio de edad: " + acum / totalNodos);
    }else{
        Persona p = gente.removeFirst();
      return promedioEdad(acum + p.getEdad(), totalNodos + 1, gente);
    }
  }

} // fin class
