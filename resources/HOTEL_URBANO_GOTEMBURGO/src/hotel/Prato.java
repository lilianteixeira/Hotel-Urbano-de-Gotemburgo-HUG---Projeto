package hotel;

public class Prato implements Refeicao {
	private String nome;
	private double preco;
	private String descricao;

	public Prato(String nome, double preco, String descricao) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return preco;
	}

}
