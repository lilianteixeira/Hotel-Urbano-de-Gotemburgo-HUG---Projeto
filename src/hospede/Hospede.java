package hospede;

import cartaoFidelidade.CartaoFidelidade;
import exceptions.StringInvalidaException;
import validador.Validador;

public class Hospede {

	private String nome;
	private String email;
	private String dataNascimento;
	private CartaoFidelidade cartaoFidelidade;
	private Validador validador;

	public Hospede(String nome, String email, String dataDeNascimento) throws Exception {

		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataDeNascimento;
		this.cartaoFidelidade = new CartaoFidelidade();
		this.validador = new Validador();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		if (nome.contains("@"))
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede esta invalido.");
		this.nome = nome;
	}

	public String getEmail() throws Exception {
		if (email == null || email.trim().equals(""))
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
		if (!validador.isEmailValid(email))
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");

		return email;
	}

	public void setEmail(String email) throws Exception {
		if (email == null || email.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
		}
		if (!validador.isEmailValid(email)) {
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
		this.email = email;
	}

	public String getDataNascimento() {

		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws Exception {
		this.dataNascimento = dataNascimento;
	}

	public CartaoFidelidade getCartaoFidelidade() {
		return cartaoFidelidade;
	}

	public void setInfoCadastro(String atributo, String alteracao) throws Exception {
		if (atributo.equalsIgnoreCase("Nome")) {
			setNome(alteracao);

		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			setDataNascimento(alteracao);

		}
		if (atributo.equalsIgnoreCase("Email")) {
			setEmail(alteracao);

		}

	}

}
