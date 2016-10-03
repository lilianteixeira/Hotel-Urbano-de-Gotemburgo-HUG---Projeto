package cartaoFidelidade;

import hospede.Hospede;

public class Premium implements TipoDeCartao{

	public static final double BONUS_PADRAO = 0.3;
	public static final double DESCONTO_PADRAO = 0.1;
	
	@Override
	public int calculaPontos(double valorGasto) {
		if (valorGasto< 100)
			return (int) (valorGasto * BONUS_PADRAO);
		else
			return ((int) (valorGasto * BONUS_PADRAO)) + ((int) (valorGasto/100)*10); 
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
