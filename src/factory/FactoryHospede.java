package factory;

import hotel.Hospede;

public class FactoryHospede {
	
	private Hospede hospede;

	public Hospede criaHospede(String nome, String email, String dataNascimento) throws Exception {
		return this.hospede = new Hospede(nome, email, dataNascimento);
	}
}
