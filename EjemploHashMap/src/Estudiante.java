
public class Estudiante {

  private String name;
  private int id;

  public Estudiante(String name, int id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public String toString() {
    return name + " " + id;
  }

  @Override
  public boolean equals(Object estudianteRepetido) {
    System.out.println("rhs --> " + estudianteRepetido);
    System.out.println("getClass() --> " + getClass());
    if (estudianteRepetido == null || getClass() != estudianteRepetido.getClass()) {
      return false;
    }

    Estudiante otro = (Estudiante) estudianteRepetido;

    return name.equals(otro.name);

  }
  
  @Override
  public int hashCode(){
    return name.hashCode();
  }
  

}
