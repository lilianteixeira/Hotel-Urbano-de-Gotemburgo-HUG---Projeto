package Restaurante;

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.NumeroInvalidoException;
import exceptions.StringInvalidaException;
import factory.FactoryPrato;
import factory.FactoryRefeicao;

public class RestauranteController {

	private HashSet<Prato> menuPratos;
	private HashSet<Refeicao> menuRefeicoes;
	private FactoryPrato factoryPrato;
	private FactoryRefeicao factoryRefeicao;

	public RestauranteController() {

		this.menuPratos = new HashSet<Prato>();
		this.menuRefeicoes = new HashSet<Refeicao>();
		this.factoryPrato = new FactoryPrato();
		this.factoryRefeicao = new FactoryRefeicao();
	}

	public void cadastraPrato(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {

		Prato prato = factoryPrato.criaPrato(nome, preco, descricao);
		menuPratos.add(prato);
	}
	
	public Prato buscaPratoPorNome(String nome){
		for (Prato prato : menuPratos) {
			if (prato.getNome().equalsIgnoreCase(nome)){
				return prato;
			}
		}
		return null;
	}
	
	public boolean cadastraRefeicao(String nome, String descricao, ArrayList<Prato> pratos) throws StringInvalidaException{
		
		Refeicao refeicao = factoryRefeicao.criaRefeicao(nome, descricao, pratos);
		
		return menuRefeicoes.add(refeicao);
		
	}
	
}
