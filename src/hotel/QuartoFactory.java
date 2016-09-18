package hotel;

public enum QuartoFactory {
	INSTANCE;

	public Quarto create(String id, TipoDeQuarto tipoDeQuarto) {
		return new Quarto(id, tipoDeQuarto);
	}

}
