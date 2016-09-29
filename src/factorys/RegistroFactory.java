package factorys;

import hospede.RegistroCheckOut;

public class RegistroFactory {
	
	public RegistroCheckOut criaRegistro(String nome, String id, double totalPago) {
		return new RegistroCheckOut(nome, id, totalPago);
	}
	
}
