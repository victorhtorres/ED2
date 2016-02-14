
public class SerieCosenoTaylor {

  public static double serieCoseno(double x, int n) {

    if (n == 0) {
      return (Math.pow(-1, n) / fact(2 * n) ) * Math.pow (x, 2 * n);
    } else {
      return serieCoseno(x, n - 1) + (Math.pow(-1, n) / fact(2 * n) ) * Math.pow (x, 2 * n);
    }

  }

 public static int fact(int n) {

    return factExtend(n, 1);

  }
  
  private static int factExtend(int n, int r) {
    if (n == 0) {
      return r;
    } else {
      return factExtend(n - 1, n * r);
    }
  }
  
  
  // Version mejorada como cola recursiva:

  public static double serieCosenoCola(double x, int n) {

    return serieCosenoColaExtend(x, n, 0);

  }

  private static double serieCosenoColaExtend(double x, int n, double r) {
    
    if ( n == 0) {
      
      return r + (Math.pow(-1, n) / fact(2 * n)) * Math.pow(x, 2 * n);
      
    } else {
      
      return serieCosenoColaExtend (x, n - 1, r + (Math.pow(-1, n) / fact(2 * n)) * Math.pow(x, 2 * n));
      
    }
    
  }
  
}

