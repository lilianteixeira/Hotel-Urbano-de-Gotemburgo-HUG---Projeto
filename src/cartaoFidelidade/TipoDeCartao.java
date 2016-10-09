package cartaoFidelidade;

/**
 *
 * A interface TipoDeCartao, e implementada por outras classes
 * ela possui os metodos de calcular pontos
 * calcular descontos e 
 * converter pontos
 *
 */
public interface TipoDeCartao {

	/**
	 * o metodo abaixo calcula os pontos, recebendo como parametro um double que representa os valores gastos
	 * o total de pontos se da pelo valor gasto multiplicado pelo bonus
	 */
	int calculaPontos(double valorGasto);

	/**
	 * o metodo abaixo calcula os pontos, recebendo como parametro um double que representa os valores gastos
	 * o total de pontos se da pelo valor gasto multiplicado pelo desconto
	 */
	double calculaDesconto(double valorGasto);

	/**
	 * o metodo abaixo converte os pontos, recebendo como parametro um int que representa a quantidade de pontos
	 */
	String convertePontos(int qtdPontos);
}
