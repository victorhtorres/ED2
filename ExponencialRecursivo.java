/*
* Realizar recursición de pila y cola para la función de exponencial de taylor: 
* https://upload.wikimedia.org/math/8/0/c/80cb4629da06fbbfa7e2e13e8d9ea85d.png
* Caso base: Cuando n == 0 retorna 1, porque cuando n=1 en la formula, da 1.
* Caso general: El llamado recursivo del método con una operación pendiente que sería la formula de exponencial.
*/

// Por pila

public class Exponencial{
  
  public static double ex(double x, double n) {
    
    if(n == 0){
      return 1;
    } else {
      return ex(x, n-1) + Math.pow(x, n) / fact(n);
    }
    
  }

// factorial recursivo en pila para resolver la parte del denominador.
  private static double fact(double n) {
    
    if (n == 0) {
      return 1;
    } else {
      return fact(n-1)*n;
    }
  }


// Por cola recursiva optimizada

  public static double ex_v2(double x, int n) {
    return exExtend(x, 1, n, 1, 1, 0);
  }

  private static double exExtend(double x, int c, int n, double potx, double factn, double r) {
    if (n == 0) {
      return potx / factn + r;
    } else {
      return exExtend(x, c + 1, n - 1, (potx * x), (factn * c), r + (potx/factn) );
    }
  }
  
  // Por cola recursiva normal
  
  public static double exCola(double x, double n) {
    
    double r = 1;
    return exCola(x, n, r);
    
  }
  
  private static double exCola(double x, double n, double r) {
    
    if(n == 0) {
      return r;
    } else {
      return exCola(x, n-1, r + Math.pow(x,n) / fact(n));
    }
    
  }
  

} // fin class
