
// Método cola

public class Logaritmo {
  
  public static double log(double x, double xsub, int n) {
    
    int cont = 1;
    double a = xsub, r = 0;
    return log(x, a, n, cont, r);
    
  }

  private static double log(double x, double a, int n, int cont, double r) {
    
    if( cont == n ){
      return Math.log10(a) + r;
    } else {
      return log( x, a, n, cont+1, r + (Math.pow(-1, cont+1)*(Math.pow(x-a, cont))) / cont*Math.pow(a, Math.pow(a, cont)) );
    }
    
  }
  
}
