package hospedagem;

public enum TipoDeQuarto {
	SIMPLES(100.0),
	LUXO(250.0),
	PRESIDENCIAL(450.0);

	private double diaria;

	TipoDeQuarto(double diaria) {
		this.diaria = diaria;
	}

	public double getDiaria() {
		return diaria;
	}
}