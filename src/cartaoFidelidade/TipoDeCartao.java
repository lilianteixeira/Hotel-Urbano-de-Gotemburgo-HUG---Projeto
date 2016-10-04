package cartaoFidelidade;


public interface TipoDeCartao {
	// adicionar pontos, aplicar desconto em gastos e pagar d�vidas com gastos

	int calculaPontos(double valorGasto);

	double calculaDesconto(double valorGasto);

	String convertePontos(int qtdPontos);
}
