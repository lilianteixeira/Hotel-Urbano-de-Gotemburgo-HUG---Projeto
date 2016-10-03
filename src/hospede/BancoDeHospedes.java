package hospede;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.*;
import factorys.EstadiaFactory;
import factorys.HospedeFactory;
import factorys.QuartoFactory;
import factorys.RegistroFactory;
import hospedagem.Estadia;
import hospedagem.Quarto;
import hospedagem.TipoDeQuarto;

public class BancoDeHospedes {

	private Set<Hospede> hopedesCadastrados;
	private Set<Quarto> quartos;
	private Map<Estadia, Hospede> estadias;
	private ArrayList<RegistroCheckOut> registroCheckout;
	private HospedeFactory factoryHospede;
	private QuartoFactory quartoFactory;
	private EstadiaFactory estadiaFactory;
	private RegistroFactory registroFactory;

	public BancoDeHospedes() {
		hopedesCadastrados = new HashSet<>();
		quartos = new HashSet<>();
		estadias = new LinkedHashMap<Estadia, Hospede>();
		factoryHospede = new HospedeFactory();
		estadiaFactory = new EstadiaFactory();
		quartoFactory = new QuartoFactory();
		registroCheckout = new ArrayList<>();
		registroFactory = new RegistroFactory();

	}

	public String cadastraHospede(String nome, String email, String dataDeNascimento) throws Exception {
		if (nome == null || nome.trim().equalsIgnoreCase("")) {
			throw new CadastroException("Nome do(a) hospede nao pode ser vazio.");
		}
		if (nome.contains("@"))
			throw new CadastroException("Nome do(a) hospede esta invalido.");

		if (email == null || email.trim().equalsIgnoreCase("")) {
			throw new CadastroException("Email do(a) hospede nao pode ser vazio.");
		}
		if (!isEmailValid(email)) {
			throw new CadastroException("Email do(a) hospede esta invalido.");
		}
		if (dataDeNascimento == null || dataDeNascimento.trim().equals("")) {
			throw new CadastroException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}

		if (!validateDate(dataDeNascimento))
			throw new CadastroException("Formato de data invalido.");
		if (!validaIdade(dataDeNascimento))
			throw new CadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		Hospede novoHospede = factoryHospede.criaHospede(nome, email, dataDeNascimento);
		hopedesCadastrados.add(novoHospede);
		return novoHospede.getEmail();
	}

	public String getInfoHospede(String email, String atributo) throws Exception {
		Hospede hospedeProcurado = buscaHospedePorEmail(email);
		if (hospedeProcurado == null) {
			throw new ObjetoInvalidoException(
					"Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");
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

	public String getInfoHospedagem(String email, String atributo) throws Exception {
		if (email == null || email.trim().equals(""))
			throw new HospedagemInfoException("Email do(a) hospede nao pode ser vazio.");
		if (!isEmailValid(email))
			throw new HospedagemInfoException("Email do(a) hospede esta invalido.");

		String retorno = "";
		Hospede hospedeProcurado = buscaHospedePorEmail(email);

		if (!temEstadiasAtivas(hospedeProcurado)) {
			throw new ObjetoInvalidoException("Erro na consulta de hospedagem. Hospede " + hospedeProcurado.getNome()
					+ " nao esta hospedado(a).");
		}

		LinkedHashSet<Estadia> hospedagensAtivas = getHospedagensAtivas(hospedeProcurado);
		Iterator<Estadia> it = hospedagensAtivas.iterator();

		if (atributo.equalsIgnoreCase("Hospedagens ativas")) {
			retorno += getHospedagensAtivas(hospedeProcurado).size();
		}

		else if (atributo.equalsIgnoreCase("Quarto")) {
			while (it.hasNext()) {
				retorno += it.next().getId() + ",";
			}
			retorno = retorno.substring(0, retorno.length() - 1);
		}

		else if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			while (it.hasNext()) {
				total += it.next().getPrecoTotal();
			}
			retorno += "R$" + String.format("%.2f", total);
		}
		return retorno;
	}

	public void atualizaCadastro(String email, String atributo, String alteracao) throws Exception {

		if (alteracao == null || alteracao.trim().equals("")) {
			if (atributo.equalsIgnoreCase("nome"))
				throw new AtualizaCadastroException("Nome do(a) hospede nao pode ser vazio.");
			if (atributo.equalsIgnoreCase("email"))
				throw new AtualizaCadastroException("Email do(a) hospede nao pode ser vazio.");
			if (atributo.equalsIgnoreCase("data de nascimento"))
				throw new AtualizaCadastroException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
		if (atributo.equalsIgnoreCase("data de Nascimento")) {
			if (!validateDate(alteracao))
				throw new AtualizaCadastroException("Formato de data invalido.");
			if (!validaIdade(alteracao))
				throw new AtualizaCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		}

		buscaHospedePorEmail(email).setInfoCadastro(atributo, alteracao);

	}

	public void removeHospede(String email) throws Exception {
		if (!isEmailValid(email))
			throw new StringInvalidaException("Erro na remocao do Hospede. Formato de email invalido.");
		Hospede hospedeProcurado = buscaHospedePorEmail(email);
		hopedesCadastrados.remove(hospedeProcurado);
	}

	public void checkIn(String email, int dias, String idQuarto, String tipoDeQuarto) throws Exception {
		if (email == null || email.trim().equals(""))
			throw new CheckinException("Email do(a) hospede nao pode ser vazio.");
		if (!isEmailValid(email))
			throw new CheckinException("Email do(a) hospede esta invalido.");
		if (dias <= 0)
			throw new CheckinException("Quantidade de dias esta invalida.");
		if (!validaQuarto(idQuarto))
			throw new CheckinException("ID do quarto invalido, use apenas numeros ou letras.");
		boolean isTipoInvalido = true;
		for (TipoDeQuarto t : TipoDeQuarto.values())
			if (tipoDeQuarto.equalsIgnoreCase(t.toString()))
				isTipoInvalido = false;
		if (isTipoInvalido)
			throw new CheckinException("Tipo de quarto invalido.");

		Hospede hospedeProcurado = buscaHospedePorEmail(email);

		if (hospedeProcurado == null)
			throw new CheckinException("Hospede de email " + email + " nao foi cadastrado(a).");

		if (buscaQuarto(idQuarto) == null) {
			quartos.add(quartoFactory.criaQuarto(idQuarto, tipoDeQuarto));
		}
		Quarto QuartoBuscado = buscaQuarto(idQuarto);
		if (QuartoBuscado.isOcupado()) {
			throw new ObjetoInvalidoException("Erro ao realizar checkin. Quarto " + idQuarto + " ja esta ocupado.");
		}
		Quarto quarto = buscaQuarto(idQuarto);
		Estadia estadia = estadiaFactory.criaEstadia(quarto, dias, hospedeProcurado);
		estadias.put(estadia, hospedeProcurado);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}

	public String checkout(String email, String idQuarto) throws Exception {
		if (email == null || email.trim().equals(""))
			throw new CheckoutException("Email do(a) hospede nao pode ser vazio.");
		if (!isEmailValid((email)))
			throw new CheckoutException("Email do(a) hospede esta invalido.");
		if (!validaQuarto(idQuarto))
			throw new CheckoutException("ID do quarto invalido, use apenas numeros ou letras.");
		Hospede hospede = buscaHospedePorEmail(email);
		Estadia estadia = buscaEstadiaPorQuarto(idQuarto);
		double valorComDesconto = estadia.getPrecoTotal()
				- hospede.getCartaoFidelidade().getTipoDeCartao().calculaDesconto(estadia.getPrecoTotal());
		
		registroCheckout.add(registroFactory.criaRegistro(estadia.getHospede().getNome(), idQuarto, valorComDesconto));
		
		buscaQuarto(idQuarto).setOcupadoState();
		removeEstadia(estadia);
		hospede.getCartaoFidelidade().adicionaPontos(estadia.getPrecoTotal());
		return String.format("R$%.2f", valorComDesconto).replace(".", ",");
	}

	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException {
		String retorno = "";

		if (atributo.equalsIgnoreCase("Quantidade")) {
			retorno += registroCheckout.size();
			return retorno;
		}
		if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			for (RegistroCheckOut registro : registroCheckout) {
				total += registro.getTotalPago();
			}
			return "R$" + String.format("%.2f", total);
		}
		if (atributo.equalsIgnoreCase("Nome")) {
			for (RegistroCheckOut registro : registroCheckout) {
				retorno += registro.getNome() + ";";
			}
			return retorno.substring(0, retorno.length() - 1);
		}
		return retorno;
	}

	public String consultaTransacoes(String atributo, int indice) throws Exception {

		if (indice < 0)
			throw new Exception("Erro na consulta de transacoes. Indice invalido.");

		String retorno = "";

		if (atributo.equalsIgnoreCase("Total")) {
			double total = registroCheckout.get(indice).getTotalPago();
			return "R$" + String.format("%.2f", total);
		}
		if (atributo.equalsIgnoreCase("Nome")) {
			return registroCheckout.get(indice).getNome();
		}
		if (atributo.equals("Detalhes")) {
			return registroCheckout.get(indice).getId();
		}
		return retorno;
	}

	public String realizaPedido(String email, String itemMenu, double valorRefeicao) throws Exception {

		Hospede hospede = buscaHospedePorEmail(email);
		double valorComDesconto = valorRefeicao
				- hospede.getCartaoFidelidade().getTipoDeCartao().calculaDesconto(valorRefeicao);

		registroCheckout.add(registroFactory.criaRegistro(hospede.getNome(), itemMenu, valorComDesconto));

		hospede.getCartaoFidelidade().adicionaPontos(valorRefeicao);
		return String.format("R$%.2f", valorComDesconto).replace(".", ",");
	}
	
	public String convertePontos(String email, int qtdPontos) throws Exception{
		Hospede hospede = buscaHospedePorEmail(email);
		if(qtdPontos > hospede.getCartaoFidelidade().getPontuacao()){
			throw new NumeroInvalidoException("Quantidade de pontos menor do que a quantidade de pontos acumulada.");
		}
		String str = hospede.getCartaoFidelidade().getTipoDeCartao().convertePontos(qtdPontos);
		hospede.getCartaoFidelidade().diminuiPontosConvertidos(qtdPontos);
		return str;
	}

	/*
	 * Os metodos que validam email e data estao�o aqui e na classe hospede,
	 * verificar uma forma de manter so em um local
	 */

	private boolean isEmailValid(String email) {
		if ((email == null) || (email.trim().equalsIgnoreCase("")))
			return false;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static boolean validateDate(String date) {
		final Pattern VALID_DATE_REGEX = Pattern
				.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[1,3-9]|1[0-2])\\2))"
						+ "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|"
						+ "^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
						+ "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|"
						+ "(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", Pattern.CASE_INSENSITIVE);

		Matcher matcher = VALID_DATE_REGEX.matcher(date);
		return (matcher.find() && Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", date));
	}

	private boolean validaIdade(String dataDeNascimento) throws Exception {
		LocalDate dataAtual = LocalDate.now();
		int ano = Integer.parseInt(dataDeNascimento.substring(6));
		int mes = Integer.parseInt(dataDeNascimento.substring(3, 4));
		int dia = Integer.parseInt(dataDeNascimento.substring(0, 1));
		if ((dataAtual.getYear() - ano) < 18)
			return false;
		else if ((dataAtual.getYear() - ano) == 18)
			if ((dataAtual.getMonthValue() - mes) < 0)
				return false;
			else if (dataAtual.getMonthValue() - mes == 0)
				if ((dataAtual.getDayOfMonth() - dia) < 0)
					return false;
		return true;
	}

	public Hospede buscaHospedePorEmail(String email) throws Exception {
		for (Hospede hospede : hopedesCadastrados) {
			if (hospede.getEmail().equalsIgnoreCase(email))
				return hospede;
		}
		return null;
	}

	private Quarto buscaQuarto(String idQuarto) {
		for (Quarto quarto : quartos) {
			if (quarto.getId().equals(idQuarto)) {
				return quarto;
			}
		}
		return null;
	}

	private boolean temEstadiasAtivas(Hospede hospede) {
		if (estadias.containsValue(hospede))
			return true;
		return false;
	}

	private LinkedHashSet<Estadia> getHospedagensAtivas(Hospede hospedeProcurado) {
		LinkedHashSet<Estadia> estadiasAtivas = new LinkedHashSet<>();
		for (Estadia estadia : estadias.keySet()) {
			if (estadias.get(estadia).equals(hospedeProcurado)) {
				estadiasAtivas.add(estadia);
			}
		}
		return estadiasAtivas;
	}

	private Estadia buscaEstadiaPorQuarto(String quarto) throws Exception {
		for (Estadia estadia : estadias.keySet()) {
			if (estadia.getId().equals(quarto)) {
				return estadia;
			}
		}
		throw new EstadiaIvalidaException();
	}

	private void removeEstadia(Estadia estadia) {
		estadias.remove(estadia);

	}

	private boolean validaQuarto(String id) {
		Pattern VALID_QUARTO_ID_REGEX = Pattern.compile("^[A-Z0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_QUARTO_ID_REGEX.matcher(id);
		return matcher.find();
	}

}
