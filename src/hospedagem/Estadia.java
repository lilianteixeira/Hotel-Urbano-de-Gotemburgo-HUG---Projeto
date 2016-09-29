package hospedagem;

import hospede.Hospede;

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
	private final Hospede hospede;

	/**Construtor de estadia
	 * 
	 * @param quarto
	 * @param dias
	 */
	public Estadia(Quarto quarto, int dias, Hospede hospede) throws Exception{
		// durante a validação dos argumentos, deve-se checar se o
		// objeto Quarto, está ocupado, usando o método quarto.isOcupado()

		if(dias <= 0){
			throw new Exception();
		}
		this.quarto = quarto;
		this.dias = dias;
		this.hospede = hospede;
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

	public Hospede getHospede() {
		return hospede;
	}

}
