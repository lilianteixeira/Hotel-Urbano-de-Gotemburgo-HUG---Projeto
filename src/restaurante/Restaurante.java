package restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import exceptions.ConsultaMenuException;
import exceptions.PratoCadastroException;
import exceptions.RefeicaoCadastroException;

public class Restaurante {

	private ArrayList<Refeicao> menu;

	public Restaurante() {
		this.menu = new ArrayList<>();
	}

	public static Restaurante getInstance() {
		return instance;
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new PratoCadastroException("Nome do prato esta vazio.");
		if (preco < 0)
			throw new PratoCadastroException("Preco do prato eh invalido.");
		if (descricao == null || descricao.trim().equals(""))
			throw new PratoCadastroException("Descricao do prato esta vazia.");

		Refeicao prato = new Prato(nome, preco, descricao);
		menu.add(prato);
	}

	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new RefeicaoCadastroException(". Nome da refeicao esta vazio.");
		if (descricao == null || descricao.trim().equals(""))
			throw new RefeicaoCadastroException(". Descricao da refeicao esta vazia.");
		if (componentes == null || componentes.trim().equals(""))
			throw new RefeicaoCadastroException(". Componente(s) esta(o) vazio(s).");
		ArrayList<Prato> pratos = new ArrayList<>();
		for (String componente : componentes.split(";")) {
			boolean isCadastrado = false;
			for (Refeicao refeicao : menu)
				if (refeicao.getClass() == (Prato.class))
					if (componente.equals(refeicao.getNome())) {
						pratos.add((Prato) refeicao);
						isCadastrado = true;
					}
			if (!isCadastrado)
				throw new RefeicaoCadastroException(". So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
		if (pratos.size() < 3 || pratos.size() > 4)
			throw new RefeicaoCadastroException(
					" completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");

		Refeicao refeicaoCompleta = new RefeicaoCompleta(nome, descricao, pratos);
		menu.add(refeicaoCompleta);
	}

	public String consultaRestaurante(String nome, String atributo) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new ConsultaMenuException("Nome do prato esta vazio.");
		if (atributo.equalsIgnoreCase("Preco")) {
			for (Refeicao r : menu)
				if (nome.equals(r.getNome()))
					return String.format("R$%.2f", r.getValor()).replace('.', ',');
			return null;
		}
		if (atributo.equalsIgnoreCase("Descricao")) {
			for (Refeicao r : menu)
				if (nome.equals(r.getNome()))
					return r.getDescricao();
			return null;
		}
		return null;
	}

	public void ordenaMenu(String tipoOrdenacao) {
		if (tipoOrdenacao.equalsIgnoreCase("nome"))
				Collections.sort(menu);
		else if (tipoOrdenacao.equalsIgnoreCase("Preco")){
			RefeicaoComparatorByPrice c = new RefeicaoComparatorByPrice();
			ordenaPorPreco(c);
		}
	}

	public void ordenaPorPreco(Comparator<Refeicao> comparador) {
		Collections.sort(menu, comparador);
	}

	public String consultaMenuRestaurante() {
		String retorno = "";
		for (Refeicao refeicao : menu) {
			retorno += refeicao.getNome() + ";";
		}
		return retorno.substring(0, retorno.length() - 1);

	}

	public Refeicao buscaRefeicao(String nome) throws Exception {
		for (Refeicao refeicao : menu) {
			if (refeicao.getNome().equals(nome))
				return refeicao;
		}
		throw new RefeicaoCadastroException();
	}

	public ArrayList<Refeicao> getMenuByPrice() {
		SortedSet<Refeicao> menuOrdenado = new TreeSet<>();
		menuOrdenado.addAll(this.menu);
		ArrayList<Refeicao> menu = new ArrayList<>(menuOrdenado);
		return menu;
	}

	private static final Restaurante instance = new Restaurante();

}