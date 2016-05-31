
public class SerieSenoTaylor {

  public static double serieSeno(double x, int n) {

    if (n == 0) {
      return x;
    } else {
      return serieSeno(x, n - 1) + (Math.pow(-1, n) / fact(2 * n + 1) ) * Math.pow (x, 2 * n + 1);
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

}

// Version mejorada como cola recursiva:

  public static double serieSenoCola(double x, int n) {

    return serieSenoColaExtend(x, n, 0);

  }

  private static double serieSenoColaExtend(double x, int n, double r) {
    
    if ( n == 0) {
      
      return r + (Math.pow(-1, n) / fact(2 * n + 1)) * Math.pow(x, 2 * n + 1);
      
    } else {
      
      return serieSenoColaExtend (x, n - 1, r + (Math.pow(-1, n) / fact(2 * n + 1)) * Math.pow(x, 2 * n + 1));
      
    }
    
  }
  
}