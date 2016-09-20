package quarto;

/**
 * A classe Quarto e uma representacao do quarto do hotel.
 * 
 * Um objeto Quarto, encapsula informacoes que um quarto contem. Tais
 * informacoes sao:
 * 
 * Id Tipo do quarto E se o quarto esta ocupado
 * 
 */
public class Quarto implements Comparable<Quarto> {
	private String id;
	private TipoDeQuarto tipoDeQuarto;
	private boolean isOcupado;
	/**
	 * 
	 * @return
	 */
	public boolean isOcupado() {
		return isOcupado;
	}
	/**
	 * 
	 */
	public void setOcupadoState() {
		// A idéia é que o método mude o estado do quarto, a partir do seu
		// estado atual.
		isOcupado = !isOcupado;
	}
	/**
	 * @return um id que representa o numero do quarto
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @return um double que informa o valor da diaria do quarto
	 */
	public double getDiaria() {
		return tipoDeQuarto.getDiaria();
	}
	/**
	 * O metodo abaixo compara se os quartos sao do mesmo tipo
	 */
	@Override
	public int compareTo(Quarto q) {
		return this.id.compareToIgnoreCase(q.getId());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/**
	 * O metodo abaixo compara se dois objetos sao iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	private Quarto(String id, TipoDeQuarto tipoDeQuarto) {
		validaArgumento(id);
		if(tipoDeQuarto == null)
			throw new NullPointerException("tipo de quarto não pode ser null");
		this.id = id;
		this.tipoDeQuarto = tipoDeQuarto;
		this.isOcupado = false;
	}
	
	private static void validaArgumento(String... strings) {
		for (String s : strings) {
			if (s == null)
				throw new NullPointerException("string não pode ser null");
			if (s.trim().equals(""))
				throw new IllegalArgumentException("string não pode ser vazia");
		}
	}

	static Quarto novoQuarto(String id, TipoDeQuarto tipoDeQuarto) {
		return new Quarto(id, tipoDeQuarto);
	}

}
