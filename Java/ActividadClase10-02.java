
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
  
  public static double calcularPotenciaCola (double a, int b) {
    double r = 1;
    return calcularPotenciaColaExtend (a, b, r);
  }

  private static double calcularPotenciaColaExtend(double a, int b, double r) {
    if ( b == 0) {
      return r;
    } else {
      return calcularPotenciaColaExtend (a, b-1, r * 2);
    }
  }

 
  public static int calcularMulti (int a, int b) {
    if (b == 0) {
      return 0;
    } else {
      return calcularMulti(a, b-1) + a;
    }
  }
 
 public static int calcularMultiCola (int a, int b) {
   int r = 0;
   return calcularMultiColaExtend (a, b, r);
 } 

  private static int calcularMultiColaExtend(int a, int b, int r) {
    if (b == 0) {
      return r;
    } else {
      return calcularMultiColaExtend (a, b-1, r + a);
    }
  }
 
  
} // fin class
