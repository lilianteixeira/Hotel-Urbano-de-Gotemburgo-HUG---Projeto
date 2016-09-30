package cartaoFidelidade;

import hospede.Hospede;

public interface TipoDeCartao {
	//adicionar pontos, aplicar desconto em gastos e pagar d�vidas com gastos
	
	public int calculaPontos(double valorGasto);
	
	public double getDesconto();
	
	public void pagarDivida(Hospede hospede, double valor);

}
