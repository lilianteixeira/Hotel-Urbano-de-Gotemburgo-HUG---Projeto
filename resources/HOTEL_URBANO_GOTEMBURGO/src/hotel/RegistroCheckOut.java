package hotel;

public class RegistroCheckOut {
	private String nome;
	private String data;
	private String id;
	private double totalPago;
	
	
	public RegistroCheckOut(String nome, String data, String id, double totalPago) {
		this.nome = nome;
		this.data = data;
		this.id = id;
		this.totalPago = totalPago;
	}
	
	public String getNome() {
		return nome;
	}
	public String getData() {
		return data;
	}
	public String getId() {
		return id;
	}
	public double getTotalPago() {
		return totalPago;
	}
	
	

}
