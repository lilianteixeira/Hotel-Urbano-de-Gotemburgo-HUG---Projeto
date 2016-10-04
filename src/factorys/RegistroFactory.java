package factorys;

import hospedagem.RegistroOperacoes;

public class RegistroFactory {
	
	public RegistroOperacoes criaRegistro(String nome, String id, double totalPago) {
		return new RegistroOperacoes(nome, id, totalPago);
	}
	
}
