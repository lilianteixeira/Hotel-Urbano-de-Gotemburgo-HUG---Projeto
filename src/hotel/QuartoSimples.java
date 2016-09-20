package hotel;

public class QuartoSimples implements TipoDeQuarto {
	private static final double diaria = 100;

	@Override
	public double getDiaria() {
		return diaria;
	}
}
