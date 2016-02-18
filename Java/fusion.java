
public class Utilitaria {

  //calcular potencia recursiva
    public static int calcularPotencia(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return calcularPotencia(a, b - 1) * a;
        }
    }

    public static int calcularMulti(int a, int b) {
        if (b == 0) {
            return 0;
        } else {
            return calcularMulti(a, b - 1) + a;
        }
    }

    public static int fusion (int a, int b) {
        
        if ( b == 0 ) {
            return 1;
        } else {
            return  calcularMulti (calcularPotencia(a, b-1), a);
        }
    }
    
}
