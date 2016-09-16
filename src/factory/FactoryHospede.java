package factory;

import exceptions.EmailInvalidoException;
import exceptions.StringInvalidaException;
import hotel.Hospede;

public class FactoryHospede {

	public Hospede criaHospede(String nome, String email, String dataNascimento)
			throws EmailInvalidoException, StringInvalidaException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		}
		if (email == null || email.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
		} else if (!email.contains("@")) {
			throw new EmailInvalidoException("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
		if (dataNascimento == null || dataNascimento.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException(
					"Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
		}

		return new Hospede(nome, email, dataNascimento);

	}
}
