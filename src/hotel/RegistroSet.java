package hotel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 *
 */
public class RegistroSet {
	private Set<RegistroCheckOut> registroSet;

	/**
	 * Construtor da classe
	 */
	public RegistroSet() {
		this.registroSet = new HashSet<>();
	}

	/**
	 * O metodo abaixo registra uma saida de um hospede
	 * retorna um boolean informando se o registro foi bem sucessido
	 * @param r
	 * @return um boolean
	 */
	public boolean addRegistro(RegistroCheckOut r) {
		return registroSet.add(r);
	}

	/**
	 * O metodo abaixo registra um iterator na lista ???
	 * @return um iterator
	 */
	public Iterator<RegistroCheckOut> iterator() {
		return registroSet.iterator();
	}
	
	public int size(){
		return registroSet.size();
	}
	
}
