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

	@Override
	public String toString() {
		return "Cadastro [nome=" + nome + ", email=" + email + ", dataDeNascimento=" + dataDeNascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	final static Cadastro novoCadastro(String nome, String email, String dataDeNascimento) {
		validaArgumento(nome, "nome");
		validaArgumento(email, "email");
		validaArgumento(dataDeNascimento, "data de nascimento");		
		return new Cadastro(nome, email, dataDeNascimento);
	}

	void setNome(String nome) {
		validaArgumento(nome, "nome");
		this.nome = nome;
	}

	void setEmail(String email) {
		validaArgumento(email, "email");
		this.email = email;
	}

	void setDataDeNascimento(String dataDeNascimento) {
		validaArgumento(dataDeNascimento, "data de nascimento");
		this.dataDeNascimento = dataDeNascimento;
	}

	private Cadastro(String nome, String email, String dataDeNascimento) {
		validaArgumento(nome, "nome");
		validaArgumento(email, "email");
		validaArgumento(dataDeNascimento, "data de nascimento");
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}

	private static void validaArgumento(String string, String identifier) {
			if (string == null)
				throw new NullPointerException(identifier + " nao pode ser null");
			if (string.trim().equals(""))
				throw new IllegalArgumentException(identifier + " nao pode ser vazio");
	}
}