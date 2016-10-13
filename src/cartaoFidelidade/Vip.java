package cartaoFidelidade;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *Classe vip, ela implementa a interface TipoDeCartao
 *o cartao vip da bonus de 0,5 
 *da desconto de 0,15
 * converte os pontos com 0,7
 * da tambem um bonus  de 0,5 pela conversao de padrao para premium 
 * 
 */
public class Vip implements TipoDeCartao, Serializable{

	/**
	 *atributos da classe 
	 */
	private static final long serialVersionUID = 9207120541458008659L;
	private static final double BONUS_PADRAO = 0.5;
	private static final double DESCONTO_PADRAO = 0.15;
	private static final double CONVERTE_PONTOS = 0.7;
	private static final double BONUS_CONVERSAO = 0.5;
	
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
		if (valorGasto< 100)
			return (valorGasto * DESCONTO_PADRAO);
		else
			return ((valorGasto * DESCONTO_PADRAO)) + ((valorGasto/100)*10); 
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
		
		return "Vip";
	}
	


}
