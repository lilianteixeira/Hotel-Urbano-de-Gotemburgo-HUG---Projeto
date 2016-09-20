package cadastro;

public enum CadastroFactory {
	INSTANCE;

	public Cadastro create(String nome, String email, String dataDeNascimento) throws Exception {
		return new Cadastro(nome, email, dataDeNascimento);
	}
}