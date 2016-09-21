package quarto;

/**
 *  O enum Quarto Factory e responsavel pela criacao de um quarto. 
 * 
 */
public enum QuartoFactory {
	INSTANCE;
	/**
	 * 
	 * @param id
	 * @param tipoDeQuarto
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 * @throws IllegalArgumentException
	 * 
	 */
	public Quarto create(String id, String tipoDeQuarto) {
		for(TipoDeQuarto t : TipoDeQuarto.values())
			if(tipoDeQuarto.equalsIgnoreCase(t.toString()))
				return Quarto.novoQuarto(id, t);
		throw new IllegalArgumentException("Tipo de quarto invalido.");
	}

}
