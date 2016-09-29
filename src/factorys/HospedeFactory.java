package factorys;

import hospede.Hospede;

public class HospedeFactory {

	public Hospede criaHospede(String nome, String email, String dataDeNascimento) throws Exception {
		return new Hospede(nome, email, dataDeNascimento);
	}
}
	