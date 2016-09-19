package cadastro;

public enum CadastroFactory {
	INSTANCE;

	public Cadastro create(String nome, String email, String dataDeNascimento) {
		return new Cadastro(nome, email, dataDeNascimento);
	}
}
