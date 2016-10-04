package hospede;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;



import exceptions.*;
import factorys.HospedeFactory;

public class BancoDeHospedes {

	private Set<Hospede> hopedesCadastrados;
	private HospedeFactory factoryHospede;

	public BancoDeHospedes() {
		hopedesCadastrados = new HashSet<>();
		factoryHospede = new HospedeFactory();

	}

	public String cadastraHospede(String nome, String email, String dataDeNascimento) throws Exception {
	
		Hospede novoHospede = factoryHospede.criaHospede(nome, email, dataDeNascimento);
		hopedesCadastrados.add(novoHospede);
		return novoHospede.getEmail();
	}

	public String getInfoHospede(String email, String atributo) throws Exception {
		Hospede hospedeProcurado = buscaHospedePorEmail(email);
		if (hospedeProcurado == null) {
			throw new HospedeNotFoundException("hospede. Hospede de email " + email + " nao foi cadastrado(a).");
		}
		if (atributo.equalsIgnoreCase("nome")) {
			return hospedeProcurado.getNome();
		}
		if (atributo.equalsIgnoreCase("data de Nascimento")) {
			return hospedeProcurado.getDataNascimento();
		}
		if (atributo.equalsIgnoreCase("email")) {
			return hospedeProcurado.getEmail();
		}
		if (atributo.equalsIgnoreCase("Pontos")) {
			String s = "";
			s += hospedeProcurado.getCartaoFidelidade().getPontuacao();
			return s;
		}
		return null;
	}

	public void atualizaCadastro(String email, String atributo, String alteracao) throws Exception {

		buscaHospedePorEmail(email).setInfoCadastro(atributo, alteracao);

	}

	public void removeHospede(String email) throws Exception {
		Hospede hospedeProcurado = buscaHospedePorEmail(email);
		hopedesCadastrados.remove(hospedeProcurado);
	}

	public String realizaPedido(String email, String itemMenu, double valorRefeicao) throws Exception {
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		Hospede hospede = buscaHospedePorEmail(email);
		double valorComDesconto = valorRefeicao
				- hospede.getCartaoFidelidade().getTipoDeCartao().calculaDesconto(valorRefeicao);

		//registroOperacoes.add(registroFactory.criaRegistro(hospede.getNome(), itemMenu, valorComDesconto));

		hospede.getCartaoFidelidade().adicionaPontos(valorRefeicao);
		String retorno = "R$" + df.format(valorComDesconto);
		return retorno;
	}

	public String convertePontos(String email, int qtdPontos) throws Exception {
		Hospede hospede = buscaHospedePorEmail(email);
		if (qtdPontos > hospede.getCartaoFidelidade().getPontuacao()) {
			throw new NumeroInvalidoException("Quantidade de pontos menor do que a quantidade de pontos acumulada.");
		}
		String str = hospede.getCartaoFidelidade().getTipoDeCartao().convertePontos(qtdPontos);
		hospede.getCartaoFidelidade().diminuiPontosConvertidos(qtdPontos);
		return str;
	}

	public Hospede buscaHospedePorEmail(String email) throws Exception {
		for (Hospede hospede : hopedesCadastrados) {
			if (hospede.getEmail().equalsIgnoreCase(email))
				return hospede;
		}
		return null;
	}



}
