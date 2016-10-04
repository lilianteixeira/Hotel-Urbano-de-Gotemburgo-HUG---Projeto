package hospedagem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;

public class BancoDeRegistros {
	private ArrayList<RegistroOperacoes> registroOperacoes;

	public BancoDeRegistros() {
		this.registroOperacoes = new ArrayList<>();
	}

	public void addRegistro(RegistroOperacoes registro) {
		registroOperacoes.add(registro);
	}
	

	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException {
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

	
	
	public String consultaTransacoes(String atributo, int indice) throws Exception {
		if (indice < 0)
			throw new Exception("Erro na consulta de transacoes. Indice invalido.");

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
	

}
