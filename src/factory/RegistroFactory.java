package hotel;

public enum RegistroFactory {
	INSTANCE;

	public RegistroCheckOut create(String nome, String id, double totalPago) {
		return new RegistroCheckOut(nome, id, totalPago);
	}

}
