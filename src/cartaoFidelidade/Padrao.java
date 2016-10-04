package cartaoFidelidade;

import java.math.RoundingMode;
import java.text.DecimalFormat;



public class Padrao implements TipoDeCartao {

	private static final double BONUS_PADRAO = 0.1;
	private static final double DESCONTO_PADRAO = 0;
	private static final double CONVERTE_PONTOS = 0.1;

	@Override
	public int calculaPontos(double valorGasto) {
		return (int) (valorGasto * BONUS_PADRAO);
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
		str += "R$" + df.format(dinheiro);
		return str;
	}

}
