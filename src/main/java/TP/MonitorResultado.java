package TP;

import java.math.BigInteger;
import java.util.ArrayList;

public class MonitorResultado {
	
	private ArrayList<BigInteger> resultado = new ArrayList<BigInteger>();

	public ArrayList<BigInteger> getResultado() {
		return resultado;
	}

	public synchronized void addResultado(BigInteger resultado) {
		resultado.add(resultado);
	}
	
	
	
	
}
