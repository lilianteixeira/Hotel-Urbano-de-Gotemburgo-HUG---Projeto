package hotel;

import quarto.Quarto;

/**
 *  O enum Estadia Factory e responsavel pela criacao de uma estadia. 
 * 
 */
public enum EstadiaFactory {
	INSTANCE;

	/**
	 * O metodo create retorna uma nova estadia
	 */
	public Estadia create(Quarto quarto, int dias) {
		return new Estadia(quarto, dias);
	}

}
