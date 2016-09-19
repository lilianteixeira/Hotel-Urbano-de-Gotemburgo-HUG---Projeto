package hotel;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class QuartoSet {
	private SortedSet<Quarto> quartos;

	/**
	 * Construtor da classe
	 */
	public QuartoSet() {
		quartos = new TreeSet<>();
	}

	/**
	 * O metodo abaixo adiciona um quarto a lista de quartos
	 * retorna um boolean informando se o quarto foi adicionado ou nao 
	 * @param q
	 * @return um boolean
	 */
	public boolean addQuarto(Quarto q) {
		return quartos.add(q);
	}

	/**
	 * O metodo abaixo remove um quarto da lista de quartos
	 * retorna um boolean informando se o quarto foi removido ou nao 
	 * @param q
	 * @return um boolean
	 */
	public boolean removeQuarto(Quarto q) {
		return quartos.remove(q);
	}

	/**
	 * O metodo abaixo busca um quarto atraves do seu id
	 * se o quarto for encontrado ele o retorna o objeto que o representa
	 * @param id
	 * @return um objeto Quarto 
	 */
	public Quarto buscaQuarto(String id) {
		Quarto q = null;
		Iterator<Quarto> i = quartos.iterator();

		while (i.hasNext()) {
			q = i.next();
			if (q.getId().equals(id))
				return q;
		}
		return null;
	}

}
