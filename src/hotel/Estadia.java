package hotel;

public class Estadia {
	private Quarto quarto;
	private int dias;

	public Estadia(Quarto quarto, int dias) {
		// durante a validação dos argumentos, deve-se checar se o
		// objeto Quarto, está ocupado, usando o método quarto.isOcupado()

		this.quarto = quarto;
		this.dias = dias;
	}

	public String getId() {
		return quarto.getId();
	}

	public int getDias() {
		return dias;
	}

	public double getPrecoTotal() {
		return quarto.getDiaria() * dias;
	}

}
