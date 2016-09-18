package hotel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cadastro.Cadastro;

public class EstadiaMap {
	private Map<Estadia, Cadastro> estadiaMap;

	public EstadiaMap() {
		this.estadiaMap = new HashMap<>();
	}

	public Cadastro getCadastro(Estadia estadia) {
		return estadiaMap.get(estadia);
	}

	public void putEstadia(Estadia estadia, Cadastro cadastro) {
		estadiaMap.put(estadia, cadastro);
	}

	public Set<Entry<Estadia, Cadastro>> entrySet() {
		return estadiaMap.entrySet();
	}

	public Set<Estadia> keySet() {
		return estadiaMap.keySet();
	}

	/**
	 * Remove todas as entradas que tem <code>c</code> como valor.
	 * 
	 * @param c
	 * @return
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
