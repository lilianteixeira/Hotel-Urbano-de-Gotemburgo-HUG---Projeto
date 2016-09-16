package hotel;

import java.util.HashSet;
import java.util.Map;

import exceptions.EmailInvalidoException;
import exceptions.StringInvalidaException;
import factory.FactoryHospede;

public class Hotel {

	private HashSet<Hospede> hospedesCadastrados;
	private FactoryHospede factoryHospede;
	private Map<Estadia, Hospede> apartamentos;

	public Hotel() {

		this.hospedesCadastrados = new HashSet<Hospede>();
		this.factoryHospede = new FactoryHospede();
	}

	public String cadastraHospede(String nome, String email, String dataNascimento)
			throws EmailInvalidoException, StringInvalidaException {
		
		Hospede hospede = factoryHospede.criaHospede(nome, email, dataNascimento);
		hospedesCadastrados.add(hospede);
		return hospede.getEmail();
	}

	public boolean removeHospede(String email) {
		return hospedesCadastrados.remove(buscaHospede(email));
	}

	private Hospede buscaHospede(String email) {
		for (Hospede hospede : hospedesCadastrados) {
			if (hospede.getEmail().equals(email)) {
				return hospede;
			}
		}
		return null;
	}

	public boolean checkIn(Estadia quarto, String email) {
		if (apartamentos.put(quarto, buscaHospede(email)) != null) {
			return true;
		}
		return false;
	}
}
