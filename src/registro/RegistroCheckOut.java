package registro;

import java.time.LocalDate;

/**
 *
 * A classe Registro checkout informa a saida de um hospede do hotel
 * 
 * Um objeto Registra Checkou, encapsula informacoes da pessoa que vai fazer o checkout 
 * Taisinformacoes sao:
 * 
 * Nome
 * Id do quarto
 * Total que vai ser pago
 * A data de saida do hospede
 *
 */
public class RegistroCheckOut {
	private LocalDate data;
	private String nome;
	private String id;
	private double totalPago;

	private RegistroCheckOut(String nome, String id, double totalPago) {
		this.data = LocalDate.now();
		this.nome = nome;
		this.id = id;
		this.totalPago = totalPago;
	}
	
	static RegistroCheckOut novoRegistro(String nome, String id, double totalPago) {
		return new RegistroCheckOut(nome, id, totalPago);
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
