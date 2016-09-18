package hotel;

public class Quarto implements Comparable<Quarto> {
	private String id;
	private TipoDeQuarto tipoDeQuarto;
	private boolean isOcupado;

	public Quarto(String id, TipoDeQuarto tipoDeQuarto) {
		this.id = id;
		this.tipoDeQuarto = tipoDeQuarto;
		this.isOcupado = false;
	}

	/**
	 * @return the isOcupado
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public double getDiaria() {
		return tipoDeQuarto.getDiaria();
	}

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

}
