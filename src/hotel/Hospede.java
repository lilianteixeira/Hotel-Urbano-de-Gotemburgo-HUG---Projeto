package hotel;

import java.time.LocalDate;

import exceptions.EmailInvalidoException;
import exceptions.StringInvalidaException;

public class Hospede {

	private String nome;
	private String email;
	private String dataNascimento;

	public Hospede(String nome, String email, String dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Hospede) {
			Hospede hospede = (Hospede) obj;
			return hospede.getNome().equals(this.getNome())
					&& hospede.getDataNascimento().equals(this.getDataNascimento())
					&& hospede.getEmail().equalsIgnoreCase(this.getEmail());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Hospede [nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + "]";
	}

}
