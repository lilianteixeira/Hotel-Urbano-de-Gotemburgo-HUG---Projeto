package hotel;

import java.time.LocalDate;

public class RegistroCheckOut {
	private LocalDate data;
	private String nome;
	private String id;
	private double totalPago;

	public RegistroCheckOut(String nome, String id, double totalPago) {
		this.data = LocalDate.now();
		this.nome = nome;
		this.id = id;
		this.totalPago = totalPago;
	}

	public LocalDate getData() {
		return data;
	}

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

	public double getTotalPago() {
		return totalPago;
	}

}
