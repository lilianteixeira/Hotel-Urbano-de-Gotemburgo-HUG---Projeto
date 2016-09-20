package hotel;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import cadastro.*;
import estadia.*;
import exceptions.*;
import quarto.*;
import registro.*;

/**
 *
 * A classe hotel ela gerencia a parte de cadastro, estadia, registro e quartos
 *
 */
public class Hotel {
	private CadastroSet cadastros;
	private EstadiaMap estadias;
	private RegistroSet registros;
	private ArrayList<RegistroCheckOut> registroCheckout;
	private QuartoSet quartos;
	private QuartoFactory quartoFactory;

	/**
	 * 
	 */
	public Hotel() {
		this.cadastros = new CadastroSet();
		this.estadias = new EstadiaMap();
		this.registros = new RegistroSet();
		this.quartos = new QuartoSet();
		this.registroCheckout = new ArrayList<>();
	}

	private void validaCadastro(String nome, String email, String dataDeNascimento) throws HotelCadastroException {
		if (!Pattern.matches("[[a-zA-Z]+\\s?]+", nome))
			throw new HotelCadastroException("Nome do(a) hospede esta invalido.");
		if (!Pattern.matches("[^@]+@[^@]+", email))
			throw new HotelCadastroException("Email do(a) hospede esta invalido");
		if (!Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", dataDeNascimento))
			throw new HotelCadastroException("Formato de data invalido.");
		LocalDate dataAtual = LocalDate.now();
		int ano = Integer.parseInt(dataDeNascimento.substring(6));
		int mes = Integer.parseInt(dataDeNascimento.substring(3, 4));
		int dia = Integer.parseInt(dataDeNascimento.substring(0, 1));
		if ((dataAtual.getYear() - ano) < 18)
			throw new HotelCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		else if ((dataAtual.getYear() - ano) == 18)
			if ((dataAtual.getMonthValue() - mes) < 0)
				throw new HotelCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
			else if (dataAtual.getMonthValue() - mes == 0)
				if ((dataAtual.getDayOfMonth() - dia) < 0)
					throw new HotelCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
	}

	public String cadastraHospede(String nome, String email, String dataDeNascimento) throws HotelCadastroException {
		validaCadastro(nome, email, dataDeNascimento);
		try {
			cadastros.addCadastro(CadastroFactory.INSTANCE.create(nome, email, dataDeNascimento));
		} catch (RuntimeException e) {
			String message;
			if (e.getMessage().contains("nome"))
				message = ("Nome do(a) hospede nao pode ser vazio.");
			else if (e.getMessage().contains("email"))
				message = ("Email do(a) hospede nao pode ser vazio.");
			else if (e.getMessage().contains("data de nascimento"))
				message = ("Data de Nascimento do(a) hospede nao pode ser vazio.");
			else
				message = "Erro nao identificado";
			throw new HotelCadastroException(message);
		}
		return email;
	}

	/**
	 * 
	 * O metodo atualiza o cadastro de um hospede
	 * 
	 * @param email
	 * @param atributo
	 * @param novoAtributo
	 * @throws CadastroNotFoundException
	 * @throws AtualizaCadastroException
	 */

	public void atualizaCadastro(String email, String atributo, String valor)
			throws CadastroNotFoundException, AtualizaCadastroException {
		try {
			cadastros.setInfoCadastro(email, atributo, valor);
		} catch (RuntimeException e) {
			String message;
			if (e.getMessage().contains("nome"))
				message = ("Nome do(a) hospede nao pode ser vazio.");
			else if (e.getMessage().contains("email"))
				message = ("Email do(a) hospede nao pode ser vazio.");
			else if (e.getMessage().contains("data de nascimento"))
				message = ("Data de Nascimento do(a) hospede nao pode ser vazio.");
			else
				message = e.getCause().getMessage();
		}
	}

	public String getInfoHospede(String email, String atributo) throws GetInfoException, CadastroNotFoundException {
		if (email == null || email.trim().equals(""))
			throw new GetInfoException("Email do(a) hospede nao pode ser vazio.");
		if (!Pattern.matches("[^@]+@[^@]+", email))
			throw new GetInfoException("Email do(a) hospede esta invalido");
		try {
			return cadastros.getInfoCadastro(email, atributo);
		} catch (CadastroNotFoundException e) {
			throw e;

		}
	}

	public boolean removeHospede(String email) throws CadastroNotFoundException {
		return cadastros.removeCadastro(cadastros.buscaCadastro(email));
		
		
	}

	/**
	 * O metodo abaixo faz o checkin do hospede
	 * 
	 * @param email
	 * @param id
	 * @param dias
	 * @throws CadastroNotFoundException
	 * @throws QuartoNotFoundException
	 * @throws InvalidQuartoStateException
	 * @throws Exception
	 */
	/*
	 * public void checkIn(String email, int dias, String idQuarto, String
	 * tipoQuarto) throws ObjetoInvalidoException, StringInvalidaException,
	 * CadastroNotFoundException, QuartoNotFoundException,
	 * InvalidQuartoStateException { Cadastro hospede =
	 * cadastros.buscaCadastro(email); if (buscaQuarto(idQuarto) == null) {
	 * quartos.addQuarto(quartoFactory.create(idQuarto, tipoQuarto)); } if
	 * (quartos.buscaQuarto(idQuarto).isOcupado()) { throw new
	 * ObjetoInvalidoException("Erro ao realizar checkin. Quarto " + idQuarto +
	 * " ja esta ocupado."); } Quarto quarto = buscaQuarto(idQuarto); Estadia
	 * estadia = EstadiaFactory.INSTANCE.create(quarto, dias);
	 * estadias.putEstadia(estadia, hospede); quarto.setOcupadoState(); // Muda
	 * o estado do quarto pra ocupado }
	 */

	/*
	 * public void checkIn(String email, String id, int dias) throws Exception {
	 * Cadastro hospede = cadastros.buscaCadastro(email); Quarto quarto =
	 * quartos.buscaQuarto(id); Estadia estadia =
	 * EstadiaFactory.INSTANCE.create(quarto, dias);
	 * estadias.putEstadia(estadia, hospede); quarto.setOcupadoState(); // Muda
	 * o estado do quarto pra ocupado }
	 */

	/**
	 * O metodo abaixo faz o checkout de um hospede que está no hotel
	 * 
	 * @param email
	 * @throws StringInvalidaException
	 * @throws ObjetoInvalidoException
	 * @throws CadastroNotFoundException
	 * @throws QuartoNotFoundException
	 * @throws Exception
	 */
	/*
	 * public String checkOut(String email, String idQuarto) throws
	 * ObjetoInvalidoException, StringInvalidaException,
	 * CadastroNotFoundException, QuartoNotFoundException {
	 * 
	 * Cadastro hospede = cadastros.buscaCadastro(email); LinkedHashSet<Estadia>
	 * hospedagensAtivas = estadias.getHospedagensAtivas(hospede);
	 * Iterator<Estadia> it = hospedagensAtivas.iterator(); double totalEstadia
	 * = 0; for (Estadia estadia : hospedagensAtivas) {
	 * 
	 * if (estadia.getId().equals(idQuarto)) { totalEstadia +=
	 * it.next().getPrecoTotal();
	 * quartos.buscaQuarto(idQuarto).setOcupadoState(); RegistroCheckOut r =
	 * RegistroFactory.INSTANCE.create(hospede.getNome(), idQuarto,
	 * estadia.getPrecoTotal()); registroCheckout.add(r);
	 * estadias.removeEstadia(estadia); } }
	 * 
	 * return "R$" + String.format("%.2f", totalEstadia); }
	 */

	/*
	 * public void checkOut(String email) throws Exception { Cadastro hospede =
	 * cadastros.buscaCadastro(email); Set<Map.Entry<Estadia, Cadastro>>
	 * entradas = estadias.entrySet(); Iterator<Map.Entry<Estadia, Cadastro>> i
	 * = entradas.iterator(); Map.Entry<Estadia, Cadastro> entrada;
	 * 
	 * while (i.hasNext()) {// Varre todas as estadias entrada = i.next(); if
	 * (entrada.getValue() == hospede) { // Essa comparação é possível, // já
	 * que não vão existir // duas instâncias de // Hospedes iguais
	 * 
	 * // se a estadia estiver relacionada ao email que está fazendo //
	 * checkout...
	 * registros.addRegistro(RegistroFactory.INSTANCE.create(hospede.getNome(),
	 * entrada.getKey().getId(), entrada.getKey().getPrecoTotal()));// esse
	 * trecho cria // uma instância de // RegistroCheckOut // com as //
	 * informações da // estadia, e // adiciona à lista // de registros
	 * quartos.buscaQuarto(entrada.getKey().getId()).setOcupadoState(); // Esse
	 * // trecho // muda // o // quarto // para // desocupado
	 * entradas.remove(entrada);// Esse trecho remove a estadia da // lista de
	 * estadias. } } }
	 */
	/**
	 * O metodo abaixo pega as informacoes de um hospede retorna uma String com
	 * a informacao desejada
	 * 
	 * @param email
	 * @param atributo
	 * @return uma String
	 * @throws Exception
	 */

	/*
	 * public String getInfoHospedagem(String email, String atributo) throws
	 * ObjetoInvalidoException, StringInvalidaException,
	 * CadastroNotFoundException { String retorno = ""; Cadastro hospede =
	 * cadastros.buscaCadastro(email);
	 * 
	 * if (!estadias.temEstadiasAtivas(hospede)) { throw new
	 * ObjetoInvalidoException( "Erro na consulta de hospedagem. Hospede " +
	 * hospede.getNome() + " nao esta hospedado(a)."); }
	 * 
	 * LinkedHashSet<Estadia> hospedagensAtivas =
	 * estadias.getHospedagensAtivas(hospede); Iterator<Estadia> it =
	 * hospedagensAtivas.iterator();
	 * 
	 * if (atributo.equalsIgnoreCase("Hospedagens ativas")) { retorno +=
	 * estadias.getHospedagensAtivas(hospede).size(); } else if
	 * (atributo.equalsIgnoreCase("Quarto")) { while (it.hasNext()) { retorno +=
	 * it.next().getId() + ","; } retorno = retorno.substring(0,
	 * retorno.length() - 1); } else if (atributo.equalsIgnoreCase("Total")) {
	 * double total = 0; while (it.hasNext()) { total +=
	 * it.next().getPrecoTotal(); } retorno += "R$" + String.format("%.2f",
	 * total); } return retorno; }
	 */

	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException {
		String retorno = "";

		if (atributo.equalsIgnoreCase("Quantidade")) {
			retorno += registroCheckout.size();
		} else if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			for (RegistroCheckOut registro : registroCheckout) {
				total += registro.getTotalPago();
			}
			retorno += "R$" + String.format("%.2f", total);
		} else if (atributo.equalsIgnoreCase("Nome")) {
			for (RegistroCheckOut registro : registroCheckout) {
				retorno += registro.getNome() + ";";
			}
			retorno = retorno.substring(0, retorno.length() - 1);
		}
		return retorno;
	}

	public String consultaTransacoes(String atributo, int indice) {
		String retorno = "";

		if (atributo.equalsIgnoreCase("Total")) {
			double total = registroCheckout.get(indice).getTotalPago();
			retorno += "R$" + String.format("%.2f", total);
		}
		if (atributo.equalsIgnoreCase("Nome")) {
			retorno += registroCheckout.get(indice).getNome();

		}
		return retorno;
	}

	/**
	 * O metodo busca um quarto atraves do seu id
	 * 
	 * @param id
	 * @return um objeto quarto
	 * @throws QuartoNotFoundException
	 */
	private Quarto buscaQuarto(String id) throws QuartoNotFoundException {
		return quartos.buscaQuarto(id);
	}

	public void checkIn(String email, int dias, String idQuarto, String tipoQuarto) {
		// TODO Auto-generated method stub

	}

}
