package hotel;


import java.math.RoundingMode;
import java.text.DecimalFormat;

import exceptions.AtualizaCadastroException;
import exceptions.CadastroException;
import exceptions.CheckinException;
import exceptions.CheckoutException;
import exceptions.ConsultaMenuException;
import exceptions.HospedagemInfoException;
import exceptions.PratoCadastroException;
import exceptions.RefeicaoCadastroException;
import exceptions.StringInvalidaException;
import hospedagem.BancoDeHospedagem;
import hospedagem.BancoDeRegistros;
import hospedagem.Estadia;
import hospedagem.RegistroOperacoes;
import hospedagem.TipoDeQuarto;
import hospede.BancoDeHospedes;
import hospede.Hospede;
import relatorios.GerenteRelatorios;
import restaurante.Restaurante;
import validador.Validador;

public class Controller {
	private BancoDeHospedes bancoDeHospedes;
	private BancoDeHospedagem bancoDeHospedagens;
	private BancoDeRegistros bancoDeRegistros;
	private Restaurante restaurante;
	private Validador validador;
	private GerenteRelatorios gerenteRelatorios = new GerenteRelatorios();

	
	public Controller(){
		this.bancoDeHospedes = new BancoDeHospedes();
		this.bancoDeRegistros = new BancoDeRegistros();
		this.bancoDeHospedagens = new BancoDeHospedagem();
		this.restaurante = new Restaurante();
		this.validador = new Validador();
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
		if (!validador.isEmailValid(email)) {
			throw new CadastroException("Email do(a) hospede esta invalido.");
		}
		if (dataDeNascimento == null || dataDeNascimento.trim().equals("")) {
			throw new CadastroException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}

		if (!validador.validateDate(dataDeNascimento))
			throw new CadastroException("Formato de data invalido.");
		if (!validador.validaIdade(dataDeNascimento))
			throw new CadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		return bancoDeHospedes.cadastraHospede(nome, email, dataDeNascimento);
	}
	
	public String getInfoHospede(String email, String atributo) throws Exception{
		return bancoDeHospedes.getInfoHospede(email, atributo);
	}
	
	public void atualizaCadastro(String email, String atributo, String alteracao) throws Exception{
		
		if (alteracao == null || alteracao.trim().equals("")) {
			if (atributo.equalsIgnoreCase("nome"))
				throw new AtualizaCadastroException("Nome do(a) hospede nao pode ser vazio.");
			if (atributo.equalsIgnoreCase("email"))
				throw new AtualizaCadastroException("Email do(a) hospede nao pode ser vazio.");
			if (atributo.equalsIgnoreCase("data de nascimento"))
				throw new AtualizaCadastroException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
		if (atributo.equalsIgnoreCase("data de Nascimento")) {
			if (!validador.validateDate(alteracao))
				throw new AtualizaCadastroException("Formato de data invalido.");
			if (!validador.validaIdade(alteracao))
				throw new AtualizaCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		}
		bancoDeHospedes.atualizaCadastro(email, atributo, alteracao);
	}
	
	public void removeHospede(String email)throws Exception{
		if (!validador.isEmailValid(email))
			throw new StringInvalidaException("Erro na remocao do Hospede. Formato de email invalido.");

		bancoDeHospedes.removeHospede(email);
	}
	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto)
			throws Exception{
		if (email == null || email.trim().equals(""))
			throw new CheckinException("Email do(a) hospede nao pode ser vazio.");
		if (!validador.isEmailValid(email))
			throw new CheckinException("Email do(a) hospede esta invalido.");
		if (dias <= 0)
			throw new CheckinException("Quantidade de dias esta invalida.");
		if (!validador.validaQuarto(idQuarto))
			throw new CheckinException("ID do quarto invalido, use apenas numeros ou letras.");
		boolean isTipoInvalido = true;
		for (TipoDeQuarto t : TipoDeQuarto.values())
			if (tipoQuarto.equalsIgnoreCase(t.toString()))
				isTipoInvalido = false;
		if (isTipoInvalido)
			throw new CheckinException("Tipo de quarto invalido.");
		
		Hospede hospede = bancoDeHospedes.buscaHospedePorEmail(email);
		
		if (hospede == null)
			throw new CheckinException("Hospede de email " + email + " nao foi cadastrado(a).");
	
		
		bancoDeHospedagens.checkIn(hospede, dias, idQuarto, tipoQuarto);
	}
	public String realizaCheckout(String email, String idQuarto)
			throws Exception{
		if (email == null || email.trim().equals(""))
			throw new CheckoutException("Email do(a) hospede nao pode ser vazio.");
		if (!validador.isEmailValid((email)))
			throw new CheckoutException("Email do(a) hospede esta invalido.");
		if (!validador.validaQuarto(idQuarto))
			throw new CheckoutException("ID do quarto invalido, use apenas numeros ou letras.");
	
		Hospede hospede = bancoDeHospedes.buscaHospedePorEmail(email);
		
		Estadia estadia = bancoDeHospedagens.buscaEstadiaPorQuarto(idQuarto);
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		double valorComDesconto = estadia.getPrecoTotal()
				- hospede.getCartaoFidelidade().getTipoDeCartao().calculaDesconto(estadia.getPrecoTotal());
		
		bancoDeRegistros.addRegistro((new RegistroOperacoes(hospede.getNome(), idQuarto, valorComDesconto)));

		return bancoDeHospedagens.checkout(hospede, idQuarto);
	}
	public String getInfoHospedagem(String email, String atributo)
			throws Exception {
		if (email == null || email.trim().equals(""))
			throw new HospedagemInfoException("Email do(a) hospede nao pode ser vazio.");
		if (!validador.isEmailValid(email))
			throw new HospedagemInfoException("Email do(a) hospede esta invalido.");

		Hospede hospede = bancoDeHospedes.buscaHospedePorEmail(email);
		return bancoDeHospedagens.getInfoHospedagem(hospede, atributo);
	}
	public String consultaTransacoes(String atributo) throws Exception {
		return bancoDeRegistros.consultaTransacoes(atributo);
	}
	public String consultaTransacoes(String atributo, int indice) throws Exception {
		return bancoDeRegistros.consultaTransacoes(atributo, indice);
	}
	public void cadastraPrato(String nome, double preco, String descricao)
			throws Exception {
		
		if (nome == null || nome.trim().equals(""))
			throw new PratoCadastroException("Nome do prato esta vazio.");
		if (preco < 0)
			throw new PratoCadastroException("Preco do prato eh invalido.");
		if (descricao == null || descricao.trim().equals(""))
			throw new PratoCadastroException("Descricao do prato esta vazia.");
		
		restaurante.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception {
		
		if (nome == null || nome.trim().equals(""))
			throw new RefeicaoCadastroException(". Nome da refeicao esta vazio.");
		if (descricao == null || descricao.trim().equals(""))
			throw new RefeicaoCadastroException(". Descricao da refeicao esta vazia.");
		if (componentes == null || componentes.trim().equals(""))
			throw new RefeicaoCadastroException(". Componente(s) esta(o) vazio(s).");
		
		restaurante.cadastraRefeicao(nome, descricao, componentes);
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception{
		
		if (nome == null || nome.trim().equals(""))
			throw new ConsultaMenuException("Nome do prato esta vazio.");
		
		return restaurante.consultaRestaurante(nome, atributo);
	}
	public String consultaMenuRestaurante() {
		return restaurante.consultaMenuRestaurante();
	}

	public String realizaPedido(String email, String itemMenu) throws Exception {
		double valorRefeicao = restaurante.buscaRefeicao(itemMenu).getValor();
		
		Hospede hospede = bancoDeHospedes.buscaHospedePorEmail(email);
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		double valorComDesconto = valorRefeicao
				- hospede.getCartaoFidelidade().getTipoDeCartao().calculaDesconto(valorRefeicao);
		
		bancoDeRegistros.addRegistro(new RegistroOperacoes(hospede.getNome(), itemMenu, valorComDesconto));

		
		return bancoDeHospedes.realizaPedido(email, itemMenu, valorRefeicao);
	}
	
	public String convertePontos (String email, int qtdPontos) throws Exception{
		return bancoDeHospedes.convertePontos(email, qtdPontos);
	}

	public void ordenaMenu(String tipoOrdenacao) {
		restaurante.ordenaMenu(tipoOrdenacao);
	}

	public void geraGelatorio(String tipoRelatorio) throws Exception {
		if (tipoRelatorio.equalsIgnoreCase("hospedes"))
			gerenteRelatorios.relatorioHospedes(bancoDeHospedes.getHospedesCadastrados());
		else if (tipoRelatorio.equalsIgnoreCase("Restaurante"))
			gerenteRelatorios.relatorioRestaurante(restaurante.getMenu());
		else if (tipoRelatorio.equalsIgnoreCase("Transacoes"))
			gerenteRelatorios.relatorioRegistros(bancoDeRegistros.getRegistroOperacoes());
		else if (tipoRelatorio.equalsIgnoreCase("Hotel"))
			gerenteRelatorios.relatorioHotel();
	}
	
	
}
