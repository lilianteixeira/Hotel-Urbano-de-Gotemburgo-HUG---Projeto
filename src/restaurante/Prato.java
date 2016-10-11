package restaurante;

public class Prato implements Refeicao {

	private String nome;
	private double valor;
	private String descricao;

	public Prato(String nome, double preco, String descricao) {
		this.nome = nome;
		this.valor = preco;
		this.descricao = descricao;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String msg = "";
		msg += this.getNome() + ", ";
		msg += "R$" + this.getValor() + ", ";
		msg += this.getDescricao();

		return msg;
	}

	@Override
	public int compareTo(Refeicao r2) {
		return this.nome.compareToIgnoreCase(r2.getNome());
	}
}