package Restaurante;

public class Prato {

	private String nome;
	private double valor;
	private String descricao;

	public Prato(String nome, double preco, String descricao)  {
		this.nome = nome;
		this.valor = preco;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Equals de um prato, onde um prato vai ser igual a outro se possuir mesmo nome, preco e mesma descricao
	 * */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prato) {
			Prato novoPrato = (Prato) obj;
			return novoPrato.getNome().equals(this.getNome())
					&& novoPrato.getDescricao().equals(this.getDescricao())
					&& novoPrato.getValor() == this.getValor();
		}
		return false;
	}

	@Override
	public String toString() {
		String msg = "";
		msg += this.getNome() + ", ";
		msg += "R$" + this.getValor() + ", ";
		msg += this.getDescricao();

		return msg;
	}
}
