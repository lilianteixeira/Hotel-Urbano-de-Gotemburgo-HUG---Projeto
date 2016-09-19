package cadastro;

public enum CadastroFactory {
	INSTANCE;

	public Cadastro create(String nome, String email, String dataDeNascimento) {
		return Cadastro.novoCadastro(nome, email, dataDeNascimento);
	}
}
