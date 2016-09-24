package registro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import exceptions.ConsultaRegistroException;

/**
 * 
 *
 */
public class RegistroList {
	private List<RegistroCheckOut> registroList;

	/**
	 * Construtor da classe
	 */
	public RegistroList() {
		this.registroList = new ArrayList<>();
	}

	/**
	 * O metodo abaixo registra uma saida de um hospede
	 * retorna um boolean informando se o registro foi bem sucessido
	 * @param r
	 * @return um boolean
	 */
	public boolean addRegistro(RegistroCheckOut r) {
		return registroList.add(r);
	}
	
	public int size(){
		return registroList.size();
	}
	
	public String consultaTransacoes(String atributo) throws ConsultaRegistroException {
		if(atributo.equalsIgnoreCase("quantidade"))
			return Integer.toString(size());
		if(atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			for(RegistroCheckOut r : registroList)
				total += r.getTotalPago();
			return String.format("R$%.2f", total).replace('.', ',');
		}
		if(atributo.equalsIgnoreCase("Nome")) {
			StringBuilder s = new StringBuilder();
			for(RegistroCheckOut r : registroList)
				if(s.length() == 0)
					s.append(r.getNome());
				else
					s.append(";" + r.getNome());
			return s.toString();
		}
		
		throw new ConsultaRegistroException();
	}
	
	public String consultaTransacoes(String atributo, int indice) throws ConsultaRegistroException {
		if(indice < 0)
			throw new ConsultaRegistroException("Indice invalido.");
		if(atributo.equalsIgnoreCase("Total")) {
			double total = registroList.get(indice).getTotalPago();
			return String.format("R$%.2f", total).replace('.', ',');
		}
		if(atributo.equalsIgnoreCase("Nome")) {
			return registroList.get(indice).getNome();
		}
		
		throw new ConsultaRegistroException();
		
	}
	
}
