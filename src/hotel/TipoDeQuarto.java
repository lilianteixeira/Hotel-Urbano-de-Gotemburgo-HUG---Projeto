package hotel;

public interface TipoDeQuarto {

	public double getDiaria();


	/*
	 * SIMPLES(100.0), LUXO(250.0), PRESIDENCIAL(450.0);
	 * 
	 * private double diaria;
	 * 
	 * TipoDeQuarto(double diaria) { this.diaria = diaria; }
	 * 
	 * public double getDiaria() { return diaria; }
	 */

}

/*package hotel;

/**
 * O enum Tipo de Quarto informa os tres tipos de quartos que existem no hotel
 *
public enum TipoDeQuarto {
	SIMPLES(100.0), LUXO(250.0), PRESIDENCIAL(450.0);

	private double diaria;

	/**
	 * Construtor da classe
	 
	TipoDeQuarto(double diaria) {
		this.diaria = diaria;
	}

	/**
	 * 
	 * O metodo abaixo informa uma diaria 
	 * @return um double 
	 *
	public double getDiaria() {
		return diaria;
	}

}*/
