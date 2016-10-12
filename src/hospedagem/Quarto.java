package hospedagem;

import java.io.Serializable;

import hospedagem.Quarto;
import hospedagem.TipoDeQuarto;

/**
 * A classe Quarto e uma representacao do quarto do hotel.
 * 
 * Um objeto Quarto, encapsula informacoes que um quarto contem. 
 * Tais informacoes sao:
 * 
 * Id
 * Tipo do quarto 
 * E se o quarto esta ocupado
 * 
 */
public class Quarto implements Comparable<Quarto>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1824610590453029060L;
	private String id;
	private TipoDeQuarto tipoDeQuarto;
	private boolean isOcupado;

	/**
	 * Construtor da classe Quarto
	 * @param id
	 * @param tipoDeQuarto
	 */
	public Quarto(String id, TipoDeQuarto tipoDeQuarto) {
		
		this.id = id;
		this.tipoDeQuarto = tipoDeQuarto;
		this.isOcupado = false;
	}

	/**
	 * @return um boolean que informa se o quarto esta com um hospede ou nao 
	 */
	public boolean isOcupado() {
		return isOcupado;
	}

	/**
	 * modifica se um quarto esta ocupado, passa a ser desocupado e vice-versa
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

}
