
/*
* OJO: ESTA IMPLEMENTACIÓN ESTÁ PENDIENTE POR VALIDAR....
*
*/


// Método cola


public class Logaritmo {
  
  public static double log(double x, double xsub, int n) {
    
    double a = xsub, r = 0;
    return log(x, a, n, r);
    
  }

  private static double log(double x, double a, int n, double r) {
    
    if( n == 0 ){
      return Math.log10(a) + r;
    } else {
      return log( x, a, n-1, r + (Math.pow(-1, n)*(Math.pow(x-a, n))) / n*Math.pow(a, Math.pow(a, n)) );
    }
    
  }
  
} // fin class
