    // invertir un número entero dado.

	// Opción 1:

    public static int invertido(int n, int invertido){
       if(n == 0){
           return invertido;
       }else{
           return invertido(n / 10, (invertido * 10) + (n % 10) );
       }
    }

    // Opción 2:
    
    public static int invertido(int n){
    	int invertido = 0;

    	return invertido(n, invertido);
    }

    private static int invertido(int n, int invertido){
    	if(n == 0){
           return invertido;
       } else {
           return invertido(n / 10, (invertido * 10) + (n % 10) );
       }
    }