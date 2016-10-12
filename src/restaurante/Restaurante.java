package restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.RefeicaoCadastroException;

public class Restaurante  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360202397174661824L;
	private List<Refeicao> menu;
	private String tipoOrdenacao;

	public Restaurante() {
		this.menu = new ArrayList<>();
		this.tipoOrdenacao = "";
	}

	public void cadastraPrato(String nome, double preco, String descricao)  {
		Refeicao prato = new Prato(nome, preco, descricao);
		addNoMenu(prato);
		
	}

	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception {
		
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
		addNoMenu(refeicaoCompleta);
	}

	public String consultaRestaurante(String nome, String atributo) {

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
		if (tipoOrdenacao.equalsIgnoreCase("nome")) {
			setTipoOrdenacao(tipoOrdenacao);
			Collections.sort(menu);
			
		} else if (tipoOrdenacao.equalsIgnoreCase("Preco")) {
			setTipoOrdenacao(tipoOrdenacao);
			RefeicaoComparatorByPrice comparador = new RefeicaoComparatorByPrice();
			Collections.sort(menu, comparador);
			
		}
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

	private void setTipoOrdenacao(String tipoOrdenacao) {
		this.tipoOrdenacao = tipoOrdenacao;
	}
	
	private void addNoMenu(Refeicao refeicao){
		
		if (tipoOrdenacao == null || tipoOrdenacao.trim().equals(""))
			menu.add(refeicao);
		else if (tipoOrdenacao.equalsIgnoreCase("Nome")){
			menu.add(refeicao);
			Collections.sort(menu);
		}			
		else if (tipoOrdenacao.equalsIgnoreCase("Preco")){
			menu.add(refeicao);
			RefeicaoComparatorByPrice comparador = new RefeicaoComparatorByPrice();
			Collections.sort(menu, comparador);
		}
		
	}

	public List<Refeicao> getMenu() {
		return menu;
	}

}