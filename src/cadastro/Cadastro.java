package cadastro;

import exceptions.StringInvalidaException;

/**
 *
 * A classe Cadastro e uma representacao do cadastro de uma pessoa.
 * 
 * Um objeto Cadastro, encapsula informacoes de uma pessoa cadastrada. Tais
 * informacoes sao:
 * 
 * Nome
 * Email de contato.
 * Data de nascimento
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

<<<<<<< HEAD
	final static Cadastro novoCadastro(String nome, String email, String dataDeNascimento) {
		return new Cadastro(nome, email, dataDeNascimento);
	}
	
	private Cadastro(String nome, String email, String dataDeNascimento) {
=======
	/**
	 * Construtor
	 * 
	 * @param nome, representa o nome da pessoa a qual o cadastro se refere.
	 * 
	 * @param email, representa o e-mail da pessoa a qual o cadastro se refere.
	 * 
	 * @param dataDeNascimento, representa a data de nascimento da pessoa a qual o cadastro se refere.
	 * 
	 * @throws StringInvalidaException 
	 */
	public Cadastro(String nome, String email, String dataDeNascimento) throws Exception {

>>>>>>> javaDoc
		if (nome == null)
			throw new StringInvalidaException("nome não pode ser null");
		
		if (nome.trim().equals(""))
			throw new StringInvalidaException("nome não pode ser vazio");
		
		if (email == null)
			throw new StringInvalidaException("email não pode ser null");
		
		if (email.trim().equals(""))
			throw new StringInvalidaException("email não pode ser vazio");
		
		if (dataDeNascimento == null)
			throw new StringInvalidaException("data de nascimento não pode ser null");
		
		if (dataDeNascimento.trim().equals(""))
			throw new StringInvalidaException("data de nascimento não pode ser vazia");

		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}

	/**
	 * Abaixo os acessadores(get's) e os modificadores(set's) das informacoes
	 */
	/**
	 * @return uma String que representa do hospede
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome
	 *            the nome to set
	 */
	//é realmente necessário verificar aqui tambem ?
	public void setNome(String nome) {
		if (nome == null)
			throw new IllegalArgumentException(new NullPointerException("nome não pode ser null"));
		if (nome.trim().equals(""))
			throw new IllegalArgumentException("nome não pode ser vazio");
		this.nome = nome;
	}

	/**
	 * @return uma String que representa um e-mail
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
	 * @return uma String que representa a data de nascimento 
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
	
	
	
	
	