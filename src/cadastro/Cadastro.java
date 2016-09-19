//Falta validar os atributos por meio de exceptions
package cadastro;

/**
 * Cadastro é uma representação do cadastro de uma pessoa.
 * <p>
 * Um objeto Cadastro, encapsula informações de uma pessoa cadastrada. Tais
 * informações são:
 * <ul>
 * <li>Nome
 * <li>Email de contato.
 * <li>Data de nascimento
 * </ul>
 * 
 * @author Laerson Verissimo
 *
 */
public class Cadastro {
	/**
	 * nome da pessoa cadastrada.
	 */
	private String nome;
	/**
	 * email de contato da pessoa cadastrada.
	 */
	private String email;
	/**
	 * data de nascimento da pessoa cadastrada.
	 */
	private String dataDeNascimento;

	final static Cadastro novoCadastro(String nome, String email, String dataDeNascimento) {
		return new Cadastro(nome, email, dataDeNascimento);
	}
	
	private Cadastro(String nome, String email, String dataDeNascimento) {
		if (nome == null)
			throw new IllegalArgumentException(new NullPointerException("nome não pode ser null"));
		if (nome.trim().equals(""))
			throw new IllegalArgumentException("nome não pode ser vazio");
		if (email == null)
			throw new IllegalArgumentException(new NullPointerException("email não pode ser null"));
		if (email.trim().equals(""))
			throw new IllegalArgumentException("email não pode ser vazio");
		if (dataDeNascimento == null)
			throw new IllegalArgumentException(new NullPointerException("data de nascimento não pode ser null"));
		if (dataDeNascimento.trim().equals(""))
			throw new IllegalArgumentException("data de nascimento não pode ser vazia");

		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}

	/**
	 * @return o nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		if (nome == null)
			throw new IllegalArgumentException(new NullPointerException("nome não pode ser null"));
		if (nome.trim().equals(""))
			throw new IllegalArgumentException("nome não pode ser vazio");
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		if (email == null)
			throw new IllegalArgumentException(new NullPointerException("email não pode ser null"));
		if (email.trim().equals(""))
			throw new IllegalArgumentException("email não pode ser vazio");
		this.email = email;
	}

	/**
	 * @return the dataDeNascimento
	 */
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	/**
	 * @param dataDeNascimento
	 *            the dataDeNascimento to set
	 */
	public void setDataDeNascimento(String dataDeNascimento) {
		if (dataDeNascimento == null)
			throw new IllegalArgumentException(new NullPointerException("data de nascimento não pode ser null"));
		if (dataDeNascimento.trim().equals(""))
			throw new IllegalArgumentException("data de nascimento não pode ser vazia");
		this.dataDeNascimento = dataDeNascimento;
	}

}
