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

	/**
	 * Construtor
	 * 
	 * @param nome
	 *            <code>String</code> a ser armazenada com a representação do
	 *            nome da pessoa a qual o cadastro se refere.
	 * @param email
	 *            <code>String</code> a ser armazenada com a representação do
	 *            email da pessoa a qual o cadastro se refere.
	 * @param dataDeNascimento
	 *            <code>String</code> a ser armazenada com a representação da
	 *            data de nascimento da pessoa a qual o cadastro se refere.
	 */
	public Cadastro(String nome, String email, String dataDeNascimento) {
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
		this.dataDeNascimento = dataDeNascimento;
	}

}
