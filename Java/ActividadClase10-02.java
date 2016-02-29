
public class Utilitaria {
  
  //calcular potencia recursiva
  
  public static double calcularPotencia (double a, int b) {
    if (b == 0) {
      return 1;
    } else {
      return calcularPotencia(a, b-1) * a;
    }
  }
  
  
// Recursivo de cola para calcular potencia
  
  public static double calcularPotenciaCola(double a, int b) {
    double r = 1;
    return calcularPotenciaCola(a, b, r);
  }

  private static double calcularPotenciaCola(double a, int b, double r) {
    if ( b == 0) {
      return r;
    } else {
      return calcularPotenciaCola(a, b-1, r * 2);
    }
  }

// Calcular multiplicación recursiva pila
 
  public static int calcularMulti (int a, int b) {
    if (b == 0) {
      return 0;
    } else {
      return calcularMulti(a, b-1) + a;
    }
  }
 
 // Calcular multiplicación recursiva cola
 
 public static int calcularMultiCola(int a, int b) {
   int r = 0;
   return calcularMultiCola(a, b, r);
 } 

  private static int calcularMultiCola(int a, int b, int r) {
    if (b == 0) {
      return r;
    } else {
      return calcularMultiCola(a, b-1, r + a);
    }
  }
  
  // Fusionar los métodos de potencia y multiplicación
  
      public static int fusion(int a, int b) {
        
        if ( b == 0 ) {
            return 1;
        } else {
            return  calcularMultiCola(calcularPotenciaCola(a, b-1), a);
        }
    }
  
} // fin class
