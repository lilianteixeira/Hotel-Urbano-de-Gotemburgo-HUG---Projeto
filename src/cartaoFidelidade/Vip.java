package cartaoFidelidade;

import java.text.DecimalFormat;

import hospede.Hospede;

public class Vip implements TipoDeCartao{

	private static final double BONUS_PADRAO = 0.5;
	private static final double DESCONTO_PADRAO = 0.15;
	private static final double CONVERTE_PONTOS = 0.7;
	private static final double BONUS_CONVERSAO = 0.5;
	
	@Override
	public int calculaPontos(double valorGasto) {
		return (int) (valorGasto * BONUS_PADRAO);
	}
	
	@Override
	public double calculaDesconto(double valorGasto) {
		if (valorGasto< 100)
			return (valorGasto * DESCONTO_PADRAO);
		else
			return ((valorGasto * DESCONTO_PADRAO)) + ((valorGasto/100)*10); 
	}

	@Override
	public String convertePontos(int qtdPontos) {
		DecimalFormat df = new DecimalFormat("#0.00");
		String str = "";
		double dinheiro = qtdPontos * CONVERTE_PONTOS;
		double bonus = (qtdPontos/10) * BONUS_CONVERSAO;
		dinheiro += bonus;
		str += "R$" + df.format(dinheiro);
		return str;
	}	
	

	


}
