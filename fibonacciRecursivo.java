public class Fibonacci {

  public static int fibo(int n) {

    if (n == 0 || n == 1) {     
      return 1;     
    } else {   
      return fibo((n - 1)) + fibo((n - 2));   
    }
    
  }
  
  //cola
  

public class Fibo {
    
    public static int fibonacci(int n) {
        int r = 1, k = 1;
        return fibonacci(n, r , k);
    }

    private static int fibonacci(int n, int r, int k ) {
        if (n == 0 || n == 1) {
            return r;
        } else {
            return fibonacci(n-1, r + k, r);
        }
    }
    
}

