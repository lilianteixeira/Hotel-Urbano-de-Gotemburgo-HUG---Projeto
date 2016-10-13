package cartaoFidelidade;

import java.io.Serializable;

/**
 * 
 * Classe Cartao Fidelidade, o cartao possui uma pontuação e um tipo
 * nessa classe usamos a interface TipoDeCartao 
 *
 */
public class CartaoFidelidade  implements Serializable {

	/**
	 * atributos da classe
	 */
	private static final long serialVersionUID = 3511716196079794501L;
	private int pontuacao;
	private TipoDeCartao tipoDeCartao;
	
	/**
	 * Construtor da classe 
	 */
	public CartaoFidelidade() {
		this.pontuacao = 0;
		this.tipoDeCartao = new Padrao();
	}

	/**
	 * modificadores e acessadores
	 */
	
	/**
	 * metodo que informa a pontuacao do cartao
	 * @return um inteiro
	 * 
	 */
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * metodo que muda a pontuacao do cartao
	 * @param pontuacao
	 */
	private void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
		upgradeFidelidade();
	}
	
	/**
	 * informa o tipo de cartao
	 * @return uma interface 
	 */
	public TipoDeCartao getTipoDeCartao() {
		return tipoDeCartao;
	}
	
	/**
	 * muda o tipo do cartao
	 * @param tipoDeCartao
	 */
	public void setTipoDeCartao(TipoDeCartao tipoDeCartao) {
		this.tipoDeCartao = tipoDeCartao;
	}

	/**
	 * o metodo abaixo faz o upgrade do cartao, 
	 * se ele tiver com mais de mil pontos ele vira vip
	 * se tiver menor ou igual a 350, ele vira premium 
	 * ele e criado como padrao, se ele perder pontos e ficar com menos que 350, ele cai de posicao e vira padrao
	 */
	private void upgradeFidelidade() {
		if (getPontuacao() > 1000) setTipoDeCartao(new Vip());
		else if (getPontuacao() >= 350) setTipoDeCartao(new Premium());
		else if (getPontuacao() < 350) setTipoDeCartao(new Padrao());
	}

	/**
	 * o metodo abaixo adiciona pontos no cartao de acordo com o valor gasto
	 * @param valorGasto
	 */
	public void adicionaPontos(double valorGasto){
		int pontosAdicionais = tipoDeCartao.calculaPontos(valorGasto);
		setPontuacao(getPontuacao() + pontosAdicionais);
	}	
	
	/**
	 * o metodo abaixo, diminui os pontos do cartao
	 * @param qtdPontos
	 */
	public void diminuiPontosConvertidos(int qtdPontos){
		this.pontuacao = this.pontuacao - qtdPontos;
		upgradeFidelidade();
	}
}
