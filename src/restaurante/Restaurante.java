package restaurante;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exceptions.ConsultaMenuException;
import exceptions.PratoCadastroException;
import exceptions.RefeicaoCadastroException;

public final class Restaurante {

	private Set<Refeicao> menu;

	private Restaurante() {
		this.menu = new HashSet<>();
	}

	public static Restaurante getInstance() {
		return instance;
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws PratoCadastroException {
		if (nome == null || nome.trim().equals(""))
			throw new PratoCadastroException("Nome do prato esta vazio.");
		if (preco < 0)
			throw new PratoCadastroException("Preco do prato eh invalido.");
		if (descricao == null || descricao.trim().equals(""))
			throw new PratoCadastroException("Descricao do prato esta vazia.");

		Refeicao prato = RefeicaoFactory.INSTANCE.createPrato(nome, preco, descricao);
		menu.add(prato);
	}

	public void cadastraRefeicao(String nome, String descricao, String componentes) throws RefeicaoCadastroException {
		if (nome == null || nome.trim().equals(""))
			throw new RefeicaoCadastroException("Nome da refeicao esta vazio.");
		if (descricao == null || descricao.trim().equals(""))
			throw new RefeicaoCadastroException("Descricao da refeicao esta vazia.");
		if (componentes == null || componentes.trim().equals(""))
			throw new RefeicaoCadastroException("Componente(s) esta(o) vazio(s).");
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
				throw new RefeicaoCadastroException("So eh possivel cadastrar refeicoes com pratos ja cadastrados.");
		}
		if(pratos.size() < 3 || pratos.size() > 4)
			throw new RefeicaoCadastroException("Uma refeicao completa deve possuir no minimo 3 e no maximo 4 pratos.");

		Refeicao refeicaoCompleta = RefeicaoFactory.INSTANCE.createRefeicaoCompleta(nome, descricao, pratos);
		menu.add(refeicaoCompleta);
	}

	public String consultaRestaurante(String nome, String atributo) throws ConsultaMenuException {
		if (nome == null || nome.trim().equals(""))
			throw new ConsultaMenuException("Nome do prato esto vazio.");
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

	private static final Restaurante instance = new Restaurante();

}