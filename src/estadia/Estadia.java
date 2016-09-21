package estadia;

import exceptions.InvalidQuartoStateException;
import quarto.Quarto;

/**
 *
 * A classe Estadia e uma representacao de uma estadia de um quarto
 * 
 * Um objeto Estadia,  encapsula informacoes. 
 * Tais informacoes sao:
 * 
 * O quarto que o hospede esta 
 * A quantidade de dias que ele vai ficar hospedado
 *
 */
public class Estadia {
	private Quarto quarto;
	private int dias;

	private Estadia(Quarto quarto, int dias) throws InvalidQuartoStateException {
		if(quarto == null)
			throw new NullPointerException();
		if(dias <= 0) {
			throw new IllegalArgumentException();
		}
		if(quarto.isOcupado())
			throw new InvalidQuartoStateException("Quarto " + quarto.getId() + " ja esta ocupado.");

		this.quarto = quarto;
		this.dias = dias;
	}
	
	static Estadia novaEstadia(Quarto quarto, int dias) throws InvalidQuartoStateException {
		return new Estadia(quarto, dias);
	}

	/**
	 * Informa o id de um quarto
	 * @return uma String
	 */
	public String getId() {
		return quarto.getId();
	}

	/**
	 * Informa a quantidade de dias 
	 * @return um int
	 */
	public int getDias() {
		return dias;
	}

	/**
	 * Informa o preco que o hospede ira pagar
	 * @return um double
	 */
	public double getPrecoTotal() {
		return quarto.getDiaria() * dias;
	}

}
