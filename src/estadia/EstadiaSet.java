package estadia;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import cadastro.*;
import exceptions.*;

/**
 * 
 *
 */
public class EstadiaSet {
	private Set<Estadia> estadiaSet;

	/**
	 * Construtor da classe
	 */
	public EstadiaSet() {
		this.estadiaSet = new TreeSet<>();
	}

	/**
	 * O metodo abaixo adiciona uma estadia a uma lista de estadias
	 * 
	 * @param estadia
	 * @param cadastro
	 */
	public void addEstadia(Estadia estadia) {
		if (estadia == null)
			throw new NullPointerException();
		estadiaSet.add(estadia);
	}

	public void removeEstadia(Estadia estadia) {
		estadiaSet.remove(estadia);
	}

	public int getHospedagensAtivas(Cadastro hospede) {
		int ativos = 0;
		for (Estadia e : estadiaSet)
			if (e.getHospede().equals(hospede))
				ativos++;
		return ativos;
	}

	public String getInfoHospedagem(Cadastro c, String atributo) throws EstadiaInfoException {
		if (atributo == null || atributo.trim().equals(""))
			throw new EstadiaInfoException("Atributo não pode ser vazio");
		
		boolean isHospedado = false;
		for(Estadia e : estadiaSet)
			if(e.getHospede().equals(c))
				isHospedado = true;
		if(!isHospedado)
			throw new EstadiaInfoException(String.format("Hospede %s nao esta hospedado(a).", c.getNome()));

		if (atributo.equalsIgnoreCase("Hospedagens ativas"))
			return Integer.toString(getHospedagensAtivas(c));

		if (atributo.equalsIgnoreCase("Quarto")) {
			StringBuilder s = new StringBuilder();
			for (Estadia e : estadiaSet)
				if (e.getHospede().equals(c))
					if (s.length() == 0)
						s.append(e.getId());
					else
						s.append("," + e.getId());
			return s.toString();
		}

		if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			for (Estadia e : estadiaSet)
				if (e.getHospede().equals(c))
					total += e.getPrecoTotal();
			return String.format("R$%.2f", total).replace(".", ",");
		}

		throw new EstadiaInfoException("Atributo invalido");
	}
	
	public Estadia buscaEstadia(String id) throws NoSuchEstadiaException {
		for (Estadia e : estadiaSet)
			if(e.getId().equals(id))
				return e;
		throw new NoSuchEstadiaException();
	}

}
