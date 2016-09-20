package estadia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
	 * O metodo abaixo recupera um cadastro se o cadastro for achado ele o
	 * retorna
	 * 
	 * @param estadia
	 * @return um objeto Cadastro
	 * @throws NoSuchEstadiaException
	 */
	public Cadastro getCadastro(Estadia estadia) throws NoSuchEstadiaException {
		Cadastro c = estadiaMap.get(estadia);
		if (c == null)
			throw new NoSuchEstadiaException();
		return c;
	}

	/**
	 * O metodo abaixo adiciona uma estadia a uma lista de estadias
	 * 
	 * @param estadia
	 * @param cadastro
	 */
	public void putEstadia(Estadia estadia, Cadastro cadastro) {
		if (estadia == null || cadastro == null)
			throw new NullPointerException();
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

	/*
	 * public boolean temEstadiasAtivas(Cadastro hospede) { if
	 * (estadiaMap.containsValue(hospede)) return true; return false; }
	 * 
	 * public LinkedHashSet getHospedagensAtivas(Cadastro hospede) {
	 * LinkedHashSet<Estadia> estadiasAtivas = new LinkedHashSet<>();
	 * 
	 * for (Estadia e : estadiaMap.keySet()) { if
	 * (estadiaMap.get(e).equals(hospede)) { estadiasAtivas.add(e);
	 * 
	 * } } return estadiasAtivas; }
	 */

	public void removeEstadia(Estadia estadia) {
		estadiaMap.remove(estadia);

	}

}
