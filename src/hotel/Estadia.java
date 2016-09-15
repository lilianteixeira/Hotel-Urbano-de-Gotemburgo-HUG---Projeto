package hotel;

public class Estadia {

	private int qtdDias;
	private Quarto quarto;
	
	public Estadia(int qtdDias) {
	
		this.qtdDias = qtdDias;
		
		
	}

	
	
	//acessadores e modificadores
	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}


	@Override
	public String toString() {
		return "Estadia [qtdDias=" + qtdDias + ", quarto=" + quarto + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qtdDias;
		result = prime * result + ((quarto == null) ? 0 : quarto.hashCode());
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
		Estadia other = (Estadia) obj;
		if (qtdDias != other.qtdDias)
			return false;
		if (quarto == null) {
			if (other.quarto != null)
				return false;
		} else if (!quarto.equals(other.quarto))
			return false;
		return true;
	}
	
	
	
	
}
