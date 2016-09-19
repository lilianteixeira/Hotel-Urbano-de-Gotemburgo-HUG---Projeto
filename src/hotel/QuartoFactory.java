package hotel;

/**
 *  O enum Quarto Factory e responsavel pela criacao de um quarto. 
 * 
 */
public enum QuartoFactory {
	INSTANCE;

	/**
	 * O metodo create retorna um novo quarto
	 */
	public Quarto create(String id, TipoDeQuarto tipoDeQuarto) {
		return new Quarto(id, tipoDeQuarto);
	}

}
