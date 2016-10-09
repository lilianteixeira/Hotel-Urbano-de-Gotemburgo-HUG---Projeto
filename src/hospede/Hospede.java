package hospede;

import cartaoFidelidade.CartaoFidelidade;

public class Hospede {

	private String nome;
	private String email;
	private String dataNascimento;
	private CartaoFidelidade cartaoFidelidade;

	public Hospede(String nome, String email, String dataDeNascimento) throws Exception {

		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataDeNascimento;
		this.cartaoFidelidade = new CartaoFidelidade();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
				this.nome = nome;
	}

	public String getEmail() throws Exception {
		return email;
	}

	public void setEmail(String email) throws Exception {
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

}
