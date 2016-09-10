package hotel;

import java.util.HashSet;

public class Hotel {

	private HashSet<Hospede> hospedesCadastrados;

	public Hotel() {
		this.hospedesCadastrados = new HashSet<Hospede>();
	}
	
	public void cadastraHospede(String nome, String email, String dataNascimento) throws Exception {
		Hospede hospede = new Hospede(nome, email, dataNascimento);
		hospedesCadastrados.add(hospede);
	}
	
	public void removeHospede(String email){
		hospedesCadastrados.remove(buscaHospede(email));
	}
	
	private Hospede buscaHospede(String email){
		for (Hospede hospede : hospedesCadastrados) {
			if (hospede.getEmail().equals(email)) {
				return hospede;
			}
		}
		return null;
	}
}
