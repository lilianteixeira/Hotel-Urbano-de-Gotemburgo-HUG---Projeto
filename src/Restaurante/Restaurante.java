package Restaurante;

import java.text.DecimalFormat;
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
			if (prato.getNome().equalsIgnoreCase(nome))
				return prato;
		}
		return null;
	}

	private Refeicao buscaRefeicaoPorNome(String nome) {
		for (Refeicao refeicao : menuRefeicoes) {
			if (refeicao.getNome().equalsIgnoreCase(nome))
				return refeicao;
		}
		return null;
	}

	public void cadastraRefeicao(String nome, String descricao, String componentes) throws StringInvalidaException {
		ArrayList<Prato> pratosRefeicao = separaPratos(componentes);
		Refeicao refeicao = RefeicaoFactory.INSTANCIA.create(nome, descricao, pratosRefeicao);

		menuRefeicoes.add(refeicao);

	}

	private ArrayList<Prato> separaPratos(String componentes) {
		String[] pratosSeparados = componentes.split(";");
		ArrayList<Prato> pratosRefeicao = new ArrayList<>();
		int contador = 0;
		for (Prato pratoRefeicao : menuPratos) {
			if (pratoRefeicao.getNome().equalsIgnoreCase(pratosSeparados[contador])) {
				pratosRefeicao.add(pratoRefeicao);
				contador++;
			}
		}
		return pratosRefeicao;
	}

	public String consultaRestaurante(String nome, String atributo) {
		Prato pratoProcurado = buscaPratoPorNome(nome);
		Refeicao refeicaoProcurada = buscaRefeicaoPorNome(nome);
		if (pratoProcurado != null) {
			if (atributo.equalsIgnoreCase("Preco")) {
				DecimalFormat formatador = new DecimalFormat("#.00");
				String valor = "R$" + formatador.format(pratoProcurado.getValor());
				valor = valor.replace(".", ",");
				return valor;
			}
			if (atributo.equalsIgnoreCase("Descricao")) {
				return pratoProcurado.getDescricao();
			}
		}
		if (refeicaoProcurada != null){
			if (atributo.equalsIgnoreCase("Preco")) {
				DecimalFormat formatador = new DecimalFormat("#.00");
				String valor = "R$" + formatador.format(refeicaoProcurada.valorRefeicao());
				valor = valor.replace(".", ",");
				return valor;
			}
			if (atributo.equalsIgnoreCase("Descricao")) {
				return refeicaoProcurada.getDescricao();
			}
		}

		return null;
	}

}
