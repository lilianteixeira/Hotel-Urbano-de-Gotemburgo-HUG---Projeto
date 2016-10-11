package restaurante;

import java.util.ArrayList;
import java.util.List;

public class RefeicaoCompleta implements Refeicao{

	private String nome;
	private String descricao;
	private List<Prato> componentes;

	public RefeicaoCompleta(String nome, String descricao, List<Prato> componentes) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.componentes = componentes;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append(this.descricao + " Serao servidos: ");
		int indice = 1;
		for(Prato prato : componentes)
			if(indice == 1)
				descricao.append(String.format("(%d) %s", indice++, prato.getNome()));
			else
				descricao.append(String.format(", (%d) %s", indice++, prato.getNome()));
		descricao.append('.');
		return descricao.toString();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getComponentes() {
		ArrayList<String> pratos = new ArrayList<>();
		for(Prato prato : componentes)
			pratos.add(prato.getNome());
		return pratos;
	}

	/**
	 * metodo que calcula o valor de um refeicao completa, sabendo que para um
	 * refeicao completa o hospede recebe 10% de desconto no valor total da
	 * refeicao
	 * 
	 * @return - retorna o valor total da refeicao
	 */
	public double getValor() {
		double valorTotal = 0;
		for (Prato prato : componentes) {
			valorTotal += prato.getValor();
		}
		valorTotal = valorTotal * 0.9;
		return valorTotal;
	}

	@Override
	public String toString() {
		String msg = "";
		msg += this.getNome() + ", ";
		msg += this.getDescricao() + " ";
		for (Refeicao prato : componentes) {
			msg += prato.getNome() + ", ";
		}
		msg += "R$" + getValor() + ".";
		return msg;
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
		RefeicaoCompleta other = (RefeicaoCompleta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
	@Override
	public int compareTo(Refeicao r2) {
		return this.nome.compareTo(r2.getNome());
	}

	
	
	
}