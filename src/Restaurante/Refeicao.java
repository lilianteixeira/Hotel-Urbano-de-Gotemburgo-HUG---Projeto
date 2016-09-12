/**
 * @author Antonio Dartagnan S. C. Junior - 114210775 Turma 02
 */
package Restaurante;

import java.util.ArrayList;

import exceptions.StringInvalidaException;

public class Refeicao {

	private final double DESCONTO = 0.1;
	private String nome;
	private String descricao;
	private ArrayList<Prato> refeicoes;

	public Refeicao(String nome, String descricao) throws StringInvalidaException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Descricao nao pode ser nula ou vazia");
		}

		this.nome = nome;
		this.descricao = descricao;
		this.refeicoes = new ArrayList<Prato>();
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
	 * Adiciona um prato a uma refeição completa, sendo que uma refeição nao
	 * pode ter mais de 4 pratos
	 * 
	 * @param novoPrato
	 *            - prato a ser adicionado a refeição
	 * @return - retorna se foi possível ou não adicionar um novo prato a
	 *         refeiçao
	 */
	public boolean addPrato(Prato novoPrato) {
		if (refeicoes.size() < 4) {
			return refeicoes.add(novoPrato);
		}
		return false;
	}

	/**
	 * metodo que calcula o valor de um refeição completa, sabendo que para um
	 * refeição completa o hospede recebe 10% de desconto no valor total da
	 * refeição
	 * 
	 * @return - retorna o valor total da refeição
	 */
	public double valorRefeicao() {
		double valorTotal = 0;
		for (Prato prato : refeicoes) {
			valorTotal += prato.getValor();
		}
		valorTotal = valorTotal * DESCONTO;
		return valorTotal;
	}

	@Override
	public String toString() {
		String msg = "";
		msg += this.getNome() + ", ";
		msg += this.getDescricao() + " ";
		for (Prato prato : refeicoes) {
			msg += prato.getNome() + ", ";
		}
		msg += "R$" + valorRefeicao() + ".";
		return msg;
	}

	/**
	 * Equals de uma refeição onde uma refeiçao é igual a outra se sua
	 * descrição, seu nome e sua lista de pratos são iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Refeicao) {
			Refeicao novaRefeicao = (Refeicao) obj;
			boolean verdade = false;
			return novaRefeicao.getNome().equals(this.getNome())
					&& novaRefeicao.getDescricao().equals(this.getDescricao())
					&& novaRefeicao.refeicoes.equals(this.refeicoes);
		}
		return false;
	}
}
