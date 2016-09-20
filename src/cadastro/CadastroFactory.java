package cadastro;

/**
 *  O enum Cadastro Factory e responsavel pela criacao de um cadastro. 
 * 
 */
public enum CadastroFactory {
	INSTANCE;


	/**
	 * O metodo create retorna um novo cadastro
	 */
	public Cadastro create(String nome, String email, String dataDeNascimento) {
		return Cadastro.novoCadastro(nome, email, dataDeNascimento);
	}
}
