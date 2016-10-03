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
	public double calculaDesconto(double valorGasto) {
		if (valorGasto< 100)
			return (valorGasto * DESCONTO_PADRAO);
		else
			return ((valorGasto * DESCONTO_PADRAO)) + ((valorGasto/100)*10); 
	}	
	

	@Override
	public void pagarDivida(Hospede hospede, double valor) {
		// TODO Auto-generated method stub
		
	}


}
