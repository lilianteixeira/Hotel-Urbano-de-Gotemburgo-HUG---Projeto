package cartaoFidelidade;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *Classe padrao, ela implementa a interface TipoDeCartao
 *o cartao padrao da bonus de 0,1 
 *nao da desconto
 *e converte os pontos com 0,1
 * 
 */
public class Padrao implements TipoDeCartao {

	private static final double BONUS_PADRAO = 0.1;
	private static final double DESCONTO_PADRAO = 0;
	private static final double CONVERTE_PONTOS = 0.1;

	/**
	 * o metodo abaixo calcula os pontos, recebendo como parametro um double que representa os valores gastos
	 * o total de pontos se da pelo valor gasto multiplicado pelo bonus
	 */
	@Override
	public int calculaPontos(double valorGasto) {
		return (int) (valorGasto * BONUS_PADRAO);
	}

	/**
	 * o metodo abaixo calcula os pontos, recebendo como parametro um double que representa os valores gastos
	 * o total de pontos se da pelo valor gasto multiplicado pelo desconto
	 */
	@Override
	public double calculaDesconto(double valorGasto) {
		return valorGasto * DESCONTO_PADRAO;
	}

	/**
	 * o metodo abaixo converte os pontos, recebendo como parametro um int que representa a quantidade de pontos
	 */
	@Override
	public String convertePontos(int qtdPontos) {
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		String str = "";
		double dinheiro = qtdPontos * CONVERTE_PONTOS;
		str += "R$" + df.format(dinheiro);
		return str;
	}

}
