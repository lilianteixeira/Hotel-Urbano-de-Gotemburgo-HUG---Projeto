package Restaurante;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
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

	public void cadastraRefeicao(String nome, String descricao, String componentes)
			throws StringInvalidaException, ObjetoInvalidoException, NumeroInvalidoException {
		if (componentes == null || componentes.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro no cadastro de refeicao. Componente(s) esta(o) vazio(s).");
		}
		ArrayList<Prato> pratosRefeicao = separaPratos(componentes);
		// if (!menuPratos.contains(pratosRefeicao)) {
		// throw new ObjetoInvalidoException(
		// "Erro no cadastro de refeicao. So eh possivel cadastrar refeicoes com
		// pratos ja cadastrados.");
		// }

		Refeicao refeicao = RefeicaoFactory.INSTANCIA.create(nome, descricao, pratosRefeicao);

		menuRefeicoes.add(refeicao);

	}

	private ArrayList<Prato> separaPratos(String componentes) throws NumeroInvalidoException {
		String[] pratosSeparados = componentes.split(";");
		if (pratosSeparados.length < 3 || pratosSeparados.length > 4) {
			throw new NumeroInvalidoException(
					"Erro no cadastro de refeicao completa. Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");
		}
		ArrayList<Prato> pratosRefeicao = new ArrayList<>();
		for (int contador = 0; contador < pratosSeparados.length; contador++) {
			for (Prato prato : menuPratos) {
				if(prato.getNome().equalsIgnoreCase(pratosSeparados[contador]))
					pratosRefeicao.add(prato);
			}
		}
		return pratosRefeicao;
	}

	public String consultaRestaurante(String nome, String atributo) throws StringInvalidaException {
		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro na consulta do restaurante. Nome do prato esto vazio.");
		}

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
		if (refeicaoProcurada != null) {
			if (atributo.equalsIgnoreCase("Preco")) {
				DecimalFormat formatador = new DecimalFormat("#.00");
				String valor = "R$" + formatador.format(refeicaoProcurada.valorRefeicao());
				valor = valor.replace(".", ",");
				return valor;
			}
			if (atributo.equalsIgnoreCase("Descricao")) {
				return refeicaoProcurada.toString();
			}
		}

		return null;
	}

}
