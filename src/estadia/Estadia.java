package estadia;

import cadastro.Cadastro;
import exceptions.QuartoOcupadoException;
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
public class Estadia implements Comparable<Estadia> {
	private Quarto quarto;
	private int dias;
	private final Cadastro hospede;

	private Estadia(Quarto quarto, int dias, Cadastro hospede) throws QuartoOcupadoException {
		if(quarto == null)
			throw new NullPointerException();
		if(dias <= 0) {
			throw new IllegalArgumentException();
		}
		if(quarto.isOcupado())
			throw new QuartoOcupadoException(quarto.getId());
		if(hospede == null)
			throw new NullPointerException();
		
		quarto.setOcupadoState();
		this.quarto = quarto;
		this.dias = dias;
		this.hospede = hospede;
	}
	
	static Estadia novaEstadia(Quarto quarto, int dias, Cadastro hospede) throws QuartoOcupadoException {
		return new Estadia(quarto, dias, hospede);
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
	
	public Cadastro getHospede() {
		return hospede;
	}

	@Override
	public int compareTo(Estadia e) {
		return quarto.getId().compareToIgnoreCase(e.getId());
	}

}
