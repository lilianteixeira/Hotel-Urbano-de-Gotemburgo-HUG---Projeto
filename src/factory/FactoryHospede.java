package factory;

import java.time.DateTimeException;
import java.time.LocalDate;

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
		if (dataNascimento == null || dataNascimento.trim().equalsIgnoreCase("")){
			throw new StringInvalidaException("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
		
		LocalDate data = converteData(dataNascimento);

		return new Hospede(nome, email, data);
	}

	private LocalDate converteData(String data) {

		try {

			String[] array = data.split("/");

			LocalDate ld = LocalDate.of(Integer.parseInt(array[2]),
					Integer.parseInt(array[1]), Integer.parseInt(array[0]));

			return ld;

		} catch (DateTimeException e) {
			throw new DateTimeException(
					"Erro no cadastro de hospede. Data invalida.");
		}

	}

}
