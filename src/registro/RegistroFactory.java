package registro;

/**
 *  O enum Registro Factory e responsavel pela criacao de um registro. 
 * 
 */
public enum RegistroFactory {
	INSTANCE;

	/**
	 * O metodo create retorna um novo registro
	 */
	public RegistroCheckOut create(String nome, String id, double totalPago) {
		return RegistroCheckOut.novoRegistro(nome, id, totalPago);
	}

}
