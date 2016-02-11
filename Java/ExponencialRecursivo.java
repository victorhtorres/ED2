public class Exponencial {
  public static double ex(double x, double n){
    if(n == 0){
      return 1;
    } else {
      return ex(x, n-1) + Math.pow(x, n) / fact(n);
    }
  }

  private static double fact(double n) {
    if (n == 0) {
      return 1;
    } else {
      return fact(n-1)*n;
    }
  }
}