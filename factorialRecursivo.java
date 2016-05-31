public class Utilitaria {

  public int fact(int n) {

    if (n == 0) {
      return 1;
    } else {
      return fact(n - 1) * n;
    }

  }

}

// Recursión de cola

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