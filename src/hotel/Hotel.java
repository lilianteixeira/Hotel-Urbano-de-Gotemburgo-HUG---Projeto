package hotel;

import java.util.HashSet;
import java.util.Map;

import exceptions.ObjetoInvalidoException;
import factory.FactoryHospede;

public class Hotel {
	private HashSet<Hospede> hospedesCadastrados;
	private FactoryHospede factoryHospede;
	private Map<Estadia, Hospede> apartamentos;

	public Hotel() {

		this.hospedesCadastrados = new HashSet<>();
		this.factoryHospede = new FactoryHospede();
		
	}

	/**
	 * Metodo que cadastra um hospede no hotel, armazenando o hospede na lista
	 * de hospedeCadastrados
	 * 
	 * @param nome
	 *            - nome do hospede
	 * @param email
	 *            - email o hospede
	 * @param dataNascimento
	 *            - data de nascimento do hospede
	 * @return
	 * @throws Exception
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws Exception {

		Hospede hospede = factoryHospede.criaHospede(nome, email, dataNascimento);
		hospedesCadastrados.add(hospede);
		return hospede.getEmail();
	}

	public void removeHospede(String email) {
		hospedesCadastrados.remove(buscaHospede(email));
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

	public String getInfoHospede(String email, String atributo) throws ObjetoInvalidoException {
		if (buscaHospede(email) == null) {
			throw new ObjetoInvalidoException(
					"Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");
		}
		Hospede hospede = buscaHospede(email);

		if (atributo.equalsIgnoreCase("Nome")) {
			return hospede.getNome();
		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			return hospede.getDataNascimento();
		}
		if (atributo.equalsIgnoreCase("Email")) {
			return hospede.getEmail();
		}
		return null;
	}

	public void atualizaCadastro(String email, String atributo, String novoAtributo) {
		Hospede hospede = buscaHospede(email);
		if (atributo.equalsIgnoreCase("Nome")) {
			hospede.setNome(novoAtributo);
		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			hospede.setDataNascimento(novoAtributo);
		}
		if (atributo.equalsIgnoreCase("Email")) {
			hospede.setEmail(novoAtributo);
		}
	}
}
