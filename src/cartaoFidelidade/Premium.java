package cartaoFidelidade;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *Classe premium, ela implementa a interface TipoDeCartao
 *o cartao premium da bonus de 0,3 
 *da desconto de 0,1
 * converte os pontos com 0,3
 * da tambem um bonus de 0,2 pela conversao de padrao para premium 
 * 
 */
public class Premium implements TipoDeCartao {

	private static final double BONUS_PADRAO = 0.3;
	private static final double DESCONTO_PADRAO = 0.1;
	private static final double CONVERTE_PONTOS = 0.3;
	private static final double BONUS_CONVERSAO = 0.2;

	/**
	 * o metodo abaixo calcula os pontos, recebendo como parametro um double que representa os valores gastos
	 * o total de pontos se da pelo valor gasto multiplicado pelo bonus
	 */
	@Override
	public int calculaPontos(double valorGasto) {
		if (valorGasto < 100)
			return (int) (valorGasto * BONUS_PADRAO);
		else
			return ((int) (valorGasto * BONUS_PADRAO)) + ((int) (valorGasto / 100) * 10);
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
		double bonus = (qtdPontos/10) * BONUS_CONVERSAO;
		dinheiro += bonus;
		str += "R$" + df.format(dinheiro);
		return str;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Premium";
	}

}
