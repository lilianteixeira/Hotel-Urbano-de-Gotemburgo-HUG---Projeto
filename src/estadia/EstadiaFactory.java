package estadia;

import cadastro.Cadastro;
import exceptions.QuartoOcupadoException;
import quarto.Quarto;

/**
 *  O enum Estadia Factory e responsavel pela criacao de uma estadia. 
 * 
 */
public enum EstadiaFactory {
	INSTANCE;

	/**
	 * O metodo create retorna uma nova estadia
	 * @throws QuartoOcupadoException 
	 */
	public Estadia create(Quarto quarto, int dias, Cadastro hospede) throws QuartoOcupadoException {
		return Estadia.novaEstadia(quarto, dias, hospede);
	}

}
