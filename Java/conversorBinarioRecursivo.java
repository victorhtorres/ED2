public class ConversorBinario {

    public static String funcionRecursiva(int n) {
        String cadena;

        if (n == 0) {
            return "0";
        } else {
            return funcionRecursiva_rec(n);
        }
        
    }

    private static String funcionRecursiva_rec(int n) {
        String cadena;

        if (n == 0) {
            cadena = "";
        } else {
            cadena = funcionRecursiva(n / 2) + "" + (n % 2);
        }
        return cadena;
    }

}