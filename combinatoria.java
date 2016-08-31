// Combinatoria recursivo.

public int combinatoriaR(int n, int k){
	if(k == 0 || k == n){
		return 1;
	} else{
		return combinatoriaR(n-1, k-1) + combinatoriaR(n-1, k);
	}
}