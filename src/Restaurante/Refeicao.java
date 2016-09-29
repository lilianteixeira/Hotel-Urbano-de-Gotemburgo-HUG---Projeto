package Restaurante;

import java.util.ArrayList;

import exceptions.StringInvalidaException;

public class Refeicao {

	private final double DESCONTO = 0.1;
	private String nome;
	private String descricao;
	private ArrayList<Prato> refeicoes;

	public Refeicao(String nome, String descricao, ArrayList<Prato> pratos) throws StringInvalidaException {

		this.nome = nome;
		this.descricao = descricao;
		this.refeicoes = pratos;
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

	/**
	 * metodo que calcula o valor de um refeicao completa, sabendo que para um
	 * refeicao completa o hospede recebe 10% de desconto no valor total da
	 * refeicao
	 * 
	 * @return - retorna o valor total da refeicao
	 */
	public double valorRefeicao() {
		double valorTotal = 0;
		for (Prato prato : refeicoes) {
			valorTotal += prato.getValor();
		}
		valorTotal = valorTotal - (valorTotal * DESCONTO);
		return valorTotal;
	}

	@Override
	public String toString() {
		String msg = "";
		int contador = 1;
		msg += this.getDescricao() + " Serao servidos: ";
		for (Prato prato : refeicoes) {
			msg += "(" + contador + ") " + prato.getNome() + ", ";
			contador++;
		}
		msg = msg.substring(0, msg.length() - 2);
		msg += ".";
		return msg;
	}

	/**
	 * Equals de uma refeicao onde uma refeicao eh igual a outra se sua
	 * descricao, seu nome e sua lista de pratos sao iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Refeicao) {
			Refeicao novaRefeicao = (Refeicao) obj;
			return novaRefeicao.getNome().equals(this.getNome())
					&& novaRefeicao.getDescricao().equals(this.getDescricao())
					&& novaRefeicao.refeicoes.equals(this.refeicoes);
		}
		return false;
	}
}
