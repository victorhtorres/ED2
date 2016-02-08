// Validar si un número es capicua o no por método recursivo.

public class Capicua {

  public static boolean esCapicua(int n) {
    int invertido = 0, resto = 0;
    return esCapicuaExtend(n, invertido, resto) == n;
  }

  private static int esCapicuaExtend(int n, int invertido, int resto) {
    if (n == 0) {
      return invertido;
    } else {
      resto = n % 10;
      invertido = invertido * 10 + resto;
      return esCapicuaExtend(n / 10, invertido, resto);
    }
  }

}
