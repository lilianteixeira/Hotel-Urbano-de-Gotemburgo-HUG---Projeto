package Restaurante;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exceptions.NumeroInvalidoException;
import exceptions.StringInvalidaException;

public class Restaurante {

	private Set<Prato> menuPratos;
	private Set<Refeicao> menuRefeicoes;

	public Restaurante() {

		this.menuPratos = new HashSet<>();
		this.menuRefeicoes = new HashSet<>();
	}

	public void cadastraPrato(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {

		Prato prato = PratoFactory.INSTANCIA.create(nome, preco, descricao);
		menuPratos.add(prato);
	}

	public Prato buscaPratoPorNome(String nome) {
		for (Prato prato : menuPratos) {
			if (prato.getNome().equalsIgnoreCase(nome)) {
				return prato;
			}
		}
		return null;
	}

	public boolean cadastraRefeicao(String nome, String descricao, ArrayList<Prato> pratos)
			throws StringInvalidaException {

		Refeicao refeicao = RefeicaoFactory.INSTANCIA.create(nome, descricao, pratos);

		return menuRefeicoes.add(refeicao);

	}

}
