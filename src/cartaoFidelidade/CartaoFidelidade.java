package cartaoFidelidade;

public class CartaoFidelidade {

	private int pontuacao;
	private TipoDeCartao tipoDeCartao;
	
	public CartaoFidelidade() {
		this.pontuacao = 0;
		this.tipoDeCartao = new Padrao();
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
		upgradeFidelidade();
	}
	
	public TipoDeCartao getTipoDeCartao() {
		return tipoDeCartao;
	}

	public void setTipoDeCartao(TipoDeCartao tipoDeCartao) {
		this.tipoDeCartao = tipoDeCartao;
	}

	private void upgradeFidelidade() {
		if (getPontuacao() > 1000) setTipoDeCartao(new Vip());
		else if (getPontuacao() >= 350) setTipoDeCartao(new Premium());
	}

	public void adicionaPontos(double valorGasto){
		int pontosAdicionais = tipoDeCartao.calculaPontos(valorGasto);
		setPontuacao(getPontuacao() + pontosAdicionais);
	}	
}
