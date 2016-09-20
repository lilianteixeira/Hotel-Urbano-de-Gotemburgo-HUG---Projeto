package cadastro;

/**
 * Essa classe é a representação do cadastro de uma pessoa, em algum possível
 * sistema que gerência uma coleção de cadastros. Cada objeto do tipo Cadastro
 * se refere às informações de uma única pessoa.
 * <p>
 * O objetivo dessa classe é encapsular informações pessoais, representadas pela
 * classe <code>String</code>, e gerenciar tais informações com o auxílio de
 * <code>CadastroSet</code>.
 * <p>
 * A única maneira de instanciar essa classe, é fazendo uso do
 * <code>CadastroFactory</code>, e a única maneira de alterar as informações de
 * uma instância de cadastro, é pelos métodos de <code>CadastroSet</code>,
 * contanto que a instância faça parte de <code>CadastroSet</code>.
 * <p>
 * Dois cadastros podem ser considerados iguais, se pelo menos uma das
 * informações, únicas para cada pessoa, que ele encapsula forem iguais.
 * 
 * @version 1.0
 * @see CadastroFactory
 * @see CadastroSet
 */
public class Cadastro {
	// Não precisa fazer a documentação de membros com acesso private ou
	// package, já que durante o processamento dos comentários, eles são
	// ignorados
	private String nome;
	private String email;
	private String dataDeNascimento;
	/**
	 * Retorna o nome da pessoa cadastrada.
	 * 
	 * @return o nome da pessoa cadastrada.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o email da pessoa cadastrada.
	 * 
	 * @return o email da pessoa cadastrada.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna a data de nascimento da pessoa cadastrada.
	 * 
	 * @return a data de nascimento da pessoa cadastrada.
	 */
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	final static Cadastro novoCadastro(String nome, String email, String dataDeNascimento) {
		validaArgumento(nome, email, dataDeNascimento);
		return new Cadastro(nome, email, dataDeNascimento);
	}

	void setNome(String nome) {
		validaArgumento(nome);
		this.nome = nome;
	}

	void setEmail(String email) {
		validaArgumento(email);
		this.email = email;
	}

	void setDataDeNascimento(String dataDeNascimento) {
		validaArgumento(dataDeNascimento);
		this.dataDeNascimento = dataDeNascimento;
	}
	
	private Cadastro(String nome, String email, String dataDeNascimento) {
		validaArgumento(nome, email, dataDeNascimento);
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	private static void validaArgumento(String...strings) {
		for(String s : strings) {
			if(s == null)
				throw new NullPointerException("string não pode ser null");
			if(s.trim().equals(""))
				throw new IllegalArgumentException("string não pode ser vazia");
		}
	}
}
