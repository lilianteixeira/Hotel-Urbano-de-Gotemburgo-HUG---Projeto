package hotel;

public class Quarto {

	private String id;
	private double valorDiaria;
	private TipoQuarto tipoQuarto; //rever
	public Quarto(String id, double valorDiaria) {

		this.id = id;
		this.valorDiaria = valorDiaria;
	
	}

	
	//modificadores e acessadores
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}


	@Override
	public String toString() {
		return "Quarto [id=" + id + ", valorDiaria=" + valorDiaria + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDiaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(valorDiaria) != Double
				.doubleToLongBits(other.valorDiaria))
			return false;
		return true;
	}
	
	
	
}
