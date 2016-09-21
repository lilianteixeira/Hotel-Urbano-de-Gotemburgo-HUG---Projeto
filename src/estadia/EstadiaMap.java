package estadia;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cadastro.*;
import exceptions.EstadiaInfoException;
import exceptions.NoSuchEstadiaException;

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

	public void removeEstadia(Estadia estadia) {
		estadiaMap.remove(estadia);
	}
	
	public int getHospedagensAtivas(Cadastro c) {
		int ativos = 0;
		Set<Entry<Estadia, Cadastro>> entries = estadiaMap.entrySet();
		for(Map.Entry<Estadia, Cadastro> entry : entries)
			if(entry.getValue().equals(c))
				ativos ++;
		return ativos;
	}
	
	public String getInfoHospedagem(Cadastro c, String atributo) throws EstadiaInfoException {
		if(atributo == null || atributo.trim().equals(""))
			throw new EstadiaInfoException("Atributo não pode ser vazio");
		
		if(atributo.equalsIgnoreCase("Hospedagens ativas"))
			return Integer.toString(getHospedagensAtivas(c));
		
		if(atributo.equalsIgnoreCase("Quarto")) {
			StringBuilder s = new StringBuilder();
			Set<Entry<Estadia, Cadastro>> entries = estadiaMap.entrySet();
			for(Map.Entry<Estadia, Cadastro> entry : entries)
				if(entry.getValue().equals(c))
					if(s.length() == 0)
						s.append(entry.getKey().getId());
					else
						s.append("," + entry.getKey().getId());
			return s.toString();
		}
		
		if(atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			Set<Entry<Estadia, Cadastro>> entries = estadiaMap.entrySet();
			for(Map.Entry<Estadia, Cadastro> entry : entries)
				if(entry.getValue().equals(c))
					total += entry.getKey().getPrecoTotal();
			return String.format("R$%.2f", total).replace(",", ".");
		}
		
		throw new EstadiaInfoException("Atributo invalido");
					
					
	}

}
