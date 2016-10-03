package cartaoFidelidade;

import hospede.Hospede;

public class Padrao implements TipoDeCartao{
	
	public static final double BONUS_PADRAO = 0.1;
	public static final double DESCONTO_PADRAO = 0;
	
	@Override
	public int calculaPontos(double valorGasto) {
		return (int) (valorGasto * BONUS_PADRAO);
	}
	@Override
	public double calculaDesconto(double valorGasto) {
		return valorGasto*DESCONTO_PADRAO;
	}
	@Override
	public void pagarDivida(Hospede hospede, double valor) {
		// TODO Auto-generated method stub
		
	}

}
