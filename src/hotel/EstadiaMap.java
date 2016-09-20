package hotel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cadastro.*;

/**
 * 
 *
 */
public class EstadiaMap {
	private Map<Estadia, Cadastro> estadiaMap;

	/**
	 * Construtor da classe
	 */
	public EstadiaMap() {
		this.estadiaMap = new HashMap<>();
	}

	/**
	 * O metodo abaixo recupera um cadastro
	 * se o cadastro for achado ele o retorna
	 * 
	 * @param estadia
	 * @return um objeto Cadastro 
	 */
	public Cadastro getCadastro(Estadia estadia) {
		return estadiaMap.get(estadia);
	}

	/**
	 * O metodo abaixo adiciona uma estadia a uma lista de estadias
	 * @param estadia
	 * @param cadastro
	 */
	public void putEstadia(Estadia estadia, Cadastro cadastro) {
		estadiaMap.put(estadia, cadastro);
	}

	/**
	 * 
	 * @return um set
	 */
	public Set<Entry<Estadia, Cadastro>> entrySet() {
		return estadiaMap.entrySet();
	}

	/**
	 * 
	 * @return um set 
	 */
	public Set<Estadia> keySet() {
		return estadiaMap.keySet();
	}

	/**
	 * Remove todas as entradas que tem o cadastro c como valor.
	 * 
	 * @param c
	 * 
	 */
	public void removeCadastro(Cadastro c) {
		Set<Map.Entry<Estadia, Cadastro>> entradas = entrySet();
		Iterator<Map.Entry<Estadia, Cadastro>> i = entradas.iterator();
		Map.Entry<Estadia, Cadastro> entrada = null;

		while (i.hasNext()) {
			entrada = i.next();
			if (entrada.getValue().equals(c))
				entradas.remove(entrada);
		}
	}

}
