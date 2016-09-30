package cartaoFidelidade;

import hospede.Hospede;

public class Vip implements TipoDeCartao{

	public static final double BONUS_PADRAO = 0.5;
	public static final double DESCONTO_PADRAO = 0.15;
	
	@Override
	public int calculaPontos(double valorGasto) {
		return (int) (valorGasto * BONUS_PADRAO);
	}
	@Override
	public double getDesconto() {
		return DESCONTO_PADRAO;
	}

	@Override
	public void pagarDivida(Hospede hospede, double valor) {
		// TODO Auto-generated method stub
		
	}


}
