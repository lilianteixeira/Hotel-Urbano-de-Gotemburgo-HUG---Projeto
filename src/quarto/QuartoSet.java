package quarto;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import exceptions.QuartoNotFoundException;

public class QuartoSet {
	private Set<Quarto> quartos;

	/**
	 * Construtor da classe
	 */
	public QuartoSet() {
		quartos = new HashSet<>();
	}

	/**
	 * adiciona um quarto a lista de quartos
	 * retorna um boolean informando se o quarto foi adicionado ou nao 
	 * @param q
	 * @return um boolean
	 */
	public boolean addQuarto(Quarto q) {
		if(q == null)
			throw new NullPointerException();
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
	 * @throws QuartoNotFoundException 
	 */
	public Quarto buscaQuarto(String id) throws QuartoNotFoundException {
		for(Quarto q : quartos)
			if(q.equals(id))
				return q;
		throw new QuartoNotFoundException();
	}

}
