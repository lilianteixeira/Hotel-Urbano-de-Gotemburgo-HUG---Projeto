package cartaoFidelidade;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import hospede.Hospede;

public class Premium implements TipoDeCartao {

	private static final double BONUS_PADRAO = 0.3;
	private static final double DESCONTO_PADRAO = 0.1;
	private static final double CONVERTE_PONTOS = 0.3;
	private static final double BONUS_CONVERSAO = 0.2;

	@Override
	public int calculaPontos(double valorGasto) {
		if (valorGasto < 100)
			return (int) (valorGasto * BONUS_PADRAO);
		else
			return ((int) (valorGasto * BONUS_PADRAO)) + ((int) (valorGasto / 100) * 10);
	}

	@Override
	public double calculaDesconto(double valorGasto) {
		return valorGasto * DESCONTO_PADRAO;
	}

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

}
