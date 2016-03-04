/*
* Autores:
* Victor Hugo Torres Manrique
* Harry Barrera
* Santiago Paz Cortes
*/
package ed2.promedio;

import java.util.HashMap;


public class Persona extends HashMap<String, Object> implements Comparable<Persona> 
{
    public static final String NOMBRE = "nombre";
    public static final String EDAD = "edad";
    public static final String IDENTIFICACION = "identificacion";
    
    public static String CRITERIO = NOMBRE;

    public Persona ( String nombre, int edad, String identificacion)
    {
        this.put(NOMBRE,nombre);
        this.put(EDAD,edad);
        this.put(IDENTIFICACION,identificacion);
    }

    public String getNombre ()
    {
        return (String) this.get(NOMBRE);
    }
    
    public int getEdad ()
    {
        return (int) this.get(EDAD);
    }
    
    public String getIdentificacion ()
    {
        return (String) this.get(IDENTIFICACION);
    }
    
    @Override
    public int compareTo(Persona o) {
        int valor = 0;
        switch(CRITERIO)
        {
            case NOMBRE: valor = ((String)get(NOMBRE)).compareTo((String)o.get(NOMBRE)); break;
            case EDAD: valor = (int)get(EDAD) - (int)o.get(EDAD); break;
            case IDENTIFICACION: valor = ((String)get(IDENTIFICACION)).compareTo((String)o.get(IDENTIFICACION)); break;
        }
        return valor;
    }
}
