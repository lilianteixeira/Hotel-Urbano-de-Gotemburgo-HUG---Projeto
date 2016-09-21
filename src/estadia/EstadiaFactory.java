package estadia;

import exceptions.InvalidQuartoStateException;
import quarto.Quarto;

/**
 *  O enum Estadia Factory e responsavel pela criacao de uma estadia. 
 * 
 */
public enum EstadiaFactory {
	INSTANCE;

	/**
	 * O metodo create retorna uma nova estadia
	 * @throws InvalidQuartoStateException 
	 */
	public Estadia create(Quarto quarto, int dias) throws InvalidQuartoStateException {
		return Estadia.novaEstadia(quarto, dias);
	}

}
