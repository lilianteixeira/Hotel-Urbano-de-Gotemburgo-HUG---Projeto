package hotel;

/**
 *  O enum Quarto Factory e responsavel pela criacao de um quarto. 
 * 
 */
public class QuartoFactory {
	//INSTANCE;
	/**
	 * O metodo create retorna um novo quarto
	 */
	public Quarto create(String id, String tipoDeQuarto) {
		
		TipoDeQuarto tipo = null;
		if (tipoDeQuarto.equalsIgnoreCase("Simples")) {
			tipo = new QuartoSimples();
		} else if (tipoDeQuarto.equalsIgnoreCase("Luxo")) {
			tipo = new QuartoLuxo();
		} else if (tipoDeQuarto.equalsIgnoreCase("Presidencial")) {
			tipo = new QuartoPresidencial();
		}
		return new Quarto(id, tipo);
	}
	/*
	public Quarto create(String id, TipoDeQuarto tipoDeQuarto) {
		return new Quarto(id, tipoDeQuarto);
	}
	*/

}
