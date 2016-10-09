package registros;

import java.time.LocalDate;

public class RegistroOperacoes {

	private LocalDate data;
	private String nome;
	private String id;
	private double totalPago;

	public RegistroOperacoes(String nome, String id, double totalPago) {
		this.data = LocalDate.now();
		this.nome = nome;
		this.id = id;
		this.totalPago = totalPago;
	}
	
	static RegistroOperacoes novoRegistro(String nome, String id, double totalPago) {
		return new RegistroOperacoes(nome, id, totalPago);
	}

	/**
	 *Informa a data do dia  
	 * @return um localDate 
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * Informa o nome do hospede
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Informa o id do quarto 
	 * @return String 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Informa o total que o hospede ira pagar
	 * @return double
	 */
	public double getTotalPago() {
		return totalPago;
	}
	
}
