package cadastro;

import exceptions.StringInvalidaException;

/**
 * Esse <code>Enum</code> tem como objetivo, fornecer um método público para
 * instanciar objetos da classe <code>Cadastro</code>.
 * 
 * @author laersonsv
 * @see Cadastro
 *
 */
public enum CadastroFactory {
	/*
	 * Uso do enum para implementar o padrão singleton, é a melhor maneira, de
	 * acordo com Joshua Bloch, no livro "Effective Java".
	 */
	INSTANCE;

	/**
	 * Retorna uma nova instância de <code>Cadastro</code>, que tem como
	 * atributos os argumentos passados para este método.
	 * <p>
	 * Os argumentos são <code>Strings</code> que não podem guardar referência
	 * null, ou não terem nenhum caractere gráfico.
	 * 
	 * @param nome
	 *            nome a ser armazenado no cadastro
	 * @param email
	 *            email a ser armazenado no cadastro
	 * @param dataDeNascimento
	 *            data de nascimento a ser armazenada no cadastro
	 * @return Uma nova instância de <code>Cadastro</code>, que tem como
	 *         atributos os argumentos passados para este método.
	 * @throws NullPointerException se algum dos argumentos tiver referência null.
	 * @throws IllegalArgumentException se algum dos argumentos for composto só por espaço em brancos
	 */
	public Cadastro create(String nome, String email, String dataDeNascimento) throws StringInvalidaException {
		return Cadastro.novoCadastro(nome, email, dataDeNascimento);
	}
}