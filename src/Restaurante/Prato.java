/**
 * @author Antonio Dartagnan S. C. Junior - 114210775 Turma 02
 */
package Restaurante;

import exceptions.NumeroInvalidoException;
import exceptions.StringInvalidaException;

public class Prato {

	private String nome;
	private double valor;
	private String descricao;

	public Prato(String nome, double preco, String descricao) throws StringInvalidaException, NumeroInvalidoException {

		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio");
		}
		if (preco < 0) {
			throw new NumeroInvalidoException("Preco nao pode ser negativo");
		}
		if (descricao == null || descricao.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Descricao nao pode ser nula ou vazia");
		}

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
	 * Equals de um prato, onde um prato vai ser igual a outro se possuir mesmo nome, preço e mesma descrição
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
