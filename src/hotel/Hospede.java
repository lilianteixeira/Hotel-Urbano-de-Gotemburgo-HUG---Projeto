package hotel;
import exceptions.*;

public class Hospede {
	private String nome, email, dataNascimento;

	public Hospede(String nome, String email, String dataNascimento) throws Exception {
		validaDados(nome, email, dataNascimento);
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		
		//ver questao do hospede que tem uma lista de estadias
		
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


	private void validaDados(String nome, String email, String dataNascimento) throws Exception{
		ValidaDados.validaNomeException(nome);
		ValidaDados.validaEmailException(email);
		ValidaDados.validaDataNascimento(dataNascimento);// IMPLEMENTAR VALIDACAO
		
	}
	
}
