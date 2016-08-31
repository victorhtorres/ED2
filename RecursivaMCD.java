// método recursivo para MCD (máximo común divisor)
// En matemáticas, se define el máximo común divisor (MCD) de dos o más números enteros al mayor número entero que los divide sin dejar resto.

public int mcd(int p, int q){
	if(q == 0){
		return p;
	} else{
		return mcd(q, p % q);
	}
}