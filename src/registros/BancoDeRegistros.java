package registros;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class BancoDeRegistros  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3972079058336960705L;
	private ArrayList<RegistroOperacoes> registroOperacoes;

	public BancoDeRegistros() {
		this.registroOperacoes = new ArrayList<>();
	}

	public void addRegistro(RegistroOperacoes registro) {
		registroOperacoes.add(registro);
	}
	

	public String consultaTransacoes(String atributo) {
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		String retorno = "";

		if (atributo.equalsIgnoreCase("Quantidade")) {
			retorno += registroOperacoes.size();
			return retorno;
		}
		if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			for (RegistroOperacoes registro : registroOperacoes) {
				total += registro.getTotalPago();
			}
			
			return "R$" + df.format(total);
		}
		if (atributo.equalsIgnoreCase("Nome")) {
			for (RegistroOperacoes registro : registroOperacoes) {
				retorno += registro.getNome() + ";";
			}
			return retorno.substring(0, retorno.length() - 1);
		}
		return retorno;
	}

	
	
	public String consultaTransacoes(String atributo, int indice) {
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		String retorno = "";

		if (atributo.equalsIgnoreCase("Total")) {
			double total = registroOperacoes.get(indice).getTotalPago();
			return "R$" + df.format(total);
		}
		if (atributo.equalsIgnoreCase("Nome")) {
			return registroOperacoes.get(indice).getNome();
		}
		if (atributo.equals("Detalhes")) {
			return registroOperacoes.get(indice).getId();
		}
		return retorno;
	}

	public ArrayList<RegistroOperacoes> getRegistroOperacoes() {
		return registroOperacoes;
	}
	
	
}