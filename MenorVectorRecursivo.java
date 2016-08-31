// EL menor de un vector.

    public static int menorRec(int[] v){
        int i = v.length-1;
        int menor = v[i];
        return menorRec(v, i, menor);
    }
    
    private static int menorRec(int[] v, int i, int menor){
        if(i == 0){
            if(menor > v[i]){
                return v[i];
            } else{
                return menor;
            }
        }else{
            if(menor < v[i]){
                return menorRec(v, i-1, menor);
            }else{
                return menorRec(v, i-1, v[i]);
            }
        }
    } 
}