
/*
*
* Objetivo: Realizar la recursión por pila y cola de la función de logaritmo de taylor:
* https://upload.wikimedia.org/math/c/4/1/c41d9a2e063e2589190aa5a79e723319.png
* Caso base: Cuando n == 1, retorna lo que resulte de la función cuando x está entre el rango: -1 < x <= 1;
* Caso general: La llamada recursiva del método, para conocer el anterior y dejando pendiente la suma de toda la ecuación de taylor.
*
*/


public class Logaritmo {

  // Recursión por pila
  public static double log(double x, double n) {
    if (x > -1 && x <= 1) {
      if (n == 1) {
        return (Math.pow(-1, n + 1) / n) * Math.pow(x, n);
      } else {
        return log(x, n-1) + (Math.pow(-1, n + 1) / n) * Math.pow(x, n);
      }
    } else {
      System.out.println("Error en x. Debe estar en el siguiente rango: -1 < X <= 1"); // Un mensaje de error para cuando X no esté en el rango.
      return -1; // Esto solo retorna cuando X no cumple con la condición, pero solo es parar detener la ejecución.
    }
  }
  
  // Recursión por cola
  
    public static double logCola(double x, double n){
    return logCola(x, n, 0.0);
  }

  private static double logCola(double x, double n, double r) {
    if (x > -1 && x <= 1){
      if(n == 1){
        return r + (Math.pow(-1, n + 1) / n) * Math.pow(x, n);
      } else {
        return logCola(x, n-1, r + (Math.pow(-1, n + 1) / n) * Math.pow(x, n));
      }
    } else {
      System.out.println("Error en x. Debe estar en el siguiente rango: -1 < X <= 1");
      return -1;
    }
  }

} // fin class








/*
* OJO: ESTA IMPLEMENTACIÓN ESTÁ PENDIENTE POR VALIDAR... NO ESTUDIAR ESTO.
*



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

*/
