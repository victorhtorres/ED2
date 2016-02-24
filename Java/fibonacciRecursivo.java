public class Fibonacci {

  public static int fibo(int n) {

    if (n == 0 || n == 1) {     
      return 1;     
    } else {   
      return fibo((n - 1)) + fibo((n - 2));   
    }
    
  }
  
  //cola [pendiente por terminar....]
  
  public static int fiboCola(int n) {
    return fiboCola(n, 1);
  }
  
  private static int fiboCola(int n, int r) {
    if (n == 0 || n == 1) {     
      return r;
  } else {
    return fiboCola(n-1, (n-1) + (n-2));
  }
  
}
