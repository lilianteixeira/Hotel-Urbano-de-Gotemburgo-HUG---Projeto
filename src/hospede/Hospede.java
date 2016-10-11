package hospede;

import cartaoFidelidade.CartaoFidelidade;

public class Hospede {

	private String nome;
	private String email;
	private String dataNascimento;
	private CartaoFidelidade cartaoFidelidade;

	public Hospede(String nome, String email, String dataDeNascimento) {

		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataDeNascimento;
		this.cartaoFidelidade = new CartaoFidelidade();
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

	public CartaoFidelidade getCartaoFidelidade() {
		return cartaoFidelidade;
	}

}
