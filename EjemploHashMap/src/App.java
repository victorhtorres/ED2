
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class App {
  public static void main(String[] args) {
    
    ArrayList<Estudiante> est1 = new ArrayList<>();
    
    est1.add(new Estudiante("Victor", 2116124));
    est1.add(new Estudiante("Harry", 2116134));
    est1.add(new Estudiante("Santiago", 2116144));
    est1.add(new Estudiante("Luis", 2116154));
    est1.add(new Estudiante("Caro", 2116164));
    est1.add(new Estudiante("Stefany", 2116174));
    est1.add(new Estudiante("Sergio", 2116184));
    est1.add(new Estudiante("Victor", 2116124));
    
    Set<Estudiante> est2 = new HashSet<>(est1);
    
    System.out.println("est --> " + est1 + " size --> " + est1.size());
    System.out.println("est2 --> " + est2 + " size --> " + est2.size());

    
  }
  
}
