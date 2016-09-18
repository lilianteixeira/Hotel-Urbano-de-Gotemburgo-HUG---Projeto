package hotel;

public enum EstadiaFactory {
	INSTANCE;

	public Estadia create(Quarto quarto, int dias) {
		return new Estadia(quarto, dias);
	}

}
