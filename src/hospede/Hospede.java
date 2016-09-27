package hospede;

import exceptions.StringInvalidaException;

public class Hospede {

	private String nome;
	private String email;
	private String dataNascimento;

	public Hospede(String nome, String email, String dataDeNascimento) throws StringInvalidaException {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
