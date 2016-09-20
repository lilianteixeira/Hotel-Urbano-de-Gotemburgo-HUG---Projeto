package hotel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cadastro.*;
import exceptions.*;
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
	 * Construtor da classe Hotel
	 */
	public Hotel() {
		this.cadastros = new CadastroSet();
		this.estadias = new EstadiaMap();
		this.registros = new RegistroSet();
		this.quartos = new QuartoSet();
		this.quartoFactory = new QuartoFactory();
		this.registroCheckout = new ArrayList<>();
	}

	/**
	 * O metodo abaixo faz o cadastro de um hospede, adicionando o mesmo na lista de hospedes cadastrados 
	 * retornando um boolean indicando se o hospede foi cadastrado ou nao 
	 * 
	 * @param nome
	 * @param email
	 * @param dataDeNascimento
	 * @return um boolean
	 * @throws Exception 
	 */
	public boolean cadastraHospede(String nome, String email, String dataDeNascimento) throws Exception {
		cadastros.addCadastro(CadastroFactory.INSTANCE.create(nome, email, dataDeNascimento));
		return true;
	}

	/**
	 * 
	 * O metodo abaixo remove um hospede cadastrado, atraves do e-mail desse hospede
	 * retorna um boolean indicando se foi removido ou nao 
	 * 
	 * @param email
	 * @return um boolean
	 * @throws Exception
	 */
	public boolean removeCadastro(String email) throws ObjetoInvalidoException, StringInvalidaException {
		return cadastros.removeCadastro(cadastros.buscaCadastro(email));
	}

	/**
	 * O metodo abaixo faz o checkin do hospede
	 * 
	 * @param email
	 * @param id
	 * @param dias
	 * @throws Exception
	 */
	public void checkIn(String email, int dias, String idQuarto, String tipoQuarto)
			throws ObjetoInvalidoException, StringInvalidaException {
		Cadastro hospede = cadastros.buscaCadastro(email);
		if (buscaQuarto(idQuarto) == null) {
			quartos.addQuarto(quartoFactory.create(idQuarto, tipoQuarto));
		}
		if (quartos.buscaQuarto(idQuarto).isOcupado()) {
			throw new ObjetoInvalidoException("Erro ao realizar checkin. Quarto " + idQuarto + " ja esta ocupado.");
		}
		Quarto quarto = buscaQuarto(idQuarto);
		Estadia estadia = EstadiaFactory.INSTANCE.create(quarto, dias);
		estadias.putEstadia(estadia, hospede);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}

	/*public void checkIn(String email, String id, int dias) throws Exception {
		Cadastro hospede = cadastros.buscaCadastro(email);
		Quarto quarto = quartos.buscaQuarto(id);
		Estadia estadia = EstadiaFactory.INSTANCE.create(quarto, dias);
		estadias.putEstadia(estadia, hospede);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}*/

	/**
	 * O metodo abaixo faz o checkout de um hospede que está no hotel 
	 * @param email
	 * @throws StringInvalidaException 
	 * @throws ObjetoInvalidoException 
	 * @throws Exception
	 */
	public String checkOut(String email, String idQuarto) throws ObjetoInvalidoException, StringInvalidaException{
		
		Cadastro hospede = cadastros.buscaCadastro(email);
		LinkedHashSet<Estadia> hospedagensAtivas = estadias.getHospedagensAtivas(hospede);
		Iterator<Estadia> it = hospedagensAtivas.iterator();
		double totalEstadia = 0;
		for (Estadia estadia : hospedagensAtivas) {
			
			if (estadia.getId().equals(idQuarto)) {
				totalEstadia += it.next().getPrecoTotal();
				quartos.buscaQuarto(idQuarto).setOcupadoState();
				RegistroCheckOut r = RegistroFactory.INSTANCE.create(hospede.getNome(), idQuarto, estadia.getPrecoTotal());
				registroCheckout.add(r);
				estadias.removeEstadia(estadia);
			}
		} 
		
		return "R$" + String.format("%.2f", totalEstadia);
	}
	/*
	public void checkOut(String email) throws Exception {
		Cadastro hospede = cadastros.buscaCadastro(email);
		Set<Map.Entry<Estadia, Cadastro>> entradas = estadias.entrySet();
		Iterator<Map.Entry<Estadia, Cadastro>> i = entradas.iterator();
		Map.Entry<Estadia, Cadastro> entrada;

		while (i.hasNext()) {// Varre todas as estadias
			entrada = i.next();
			if (entrada.getValue().equals(hospede)) {
				// se a estadia estiver relacionada ao email que está fazendo
				// checkout...
				registros.addRegistro(RegistroFactory.INSTANCE.create(hospede.getNome(), entrada.getKey().getId(),
						entrada.getKey().getPrecoTotal()));// esse trecho cria
															// uma instância de
															// RegistroCheckOut
															// com as
															// informações da
															// estadia, e
															// adiciona à lista
															// de registros
				quartos.buscaQuarto(entrada.getKey().getId()).setOcupadoState(); // Esse
																					// trecho
																					// muda
																					// o
																					// quarto
																					// para
																					// desocupado
				entradas.remove(entrada);// Esse trecho remove a estadia da
											// lista de estadias.
			}
		}
	}
*/
	/**
	 * O metodo abaixo pega as informacoes de um hospede
	 * retorna uma String com a informacao desejada
	 * 
	 * @param email
	 * @param atributo
	 * @return uma String
	 * @throws Exception
	 */
	public String getInfoHospede(String email, String atributo)
			throws ObjetoInvalidoException, StringInvalidaException {
		/*
		 * if (buscaHospede(email) == null) { throw new ObjetoInvalidoException(
		 * "Erro na consulta de hospede. Hospede de email " + email +
		 * " nao foi cadastrado(a)."); }
		 */

		Cadastro hospede = cadastros.buscaCadastro(email);
		// A checagem se o e-mail está cadastrado, foi passado para o método
		// buscaCadastro.

		if (atributo.equalsIgnoreCase("Nome")) {
			return hospede.getNome();
		}
		if (atributo.equalsIgnoreCase("Data de nascimento")) {
			return hospede.getDataDeNascimento();
		}
		if (atributo.equalsIgnoreCase("Email")) {
			return hospede.getEmail();
		}
		/* return null; */// Não deveria retornar um null, e sim lançar uma
							// exceção de argumento inválido
		throw new IllegalArgumentException(); // Trocar por uma checked
												// exception depois.
	}
	
	public String getInfoHospedagem(String email, String atributo)
			throws ObjetoInvalidoException, StringInvalidaException {

		String retorno = "";
		Cadastro hospede = cadastros.buscaCadastro(email);

		if (!estadias.temEstadiasAtivas(hospede)) {
			throw new ObjetoInvalidoException(
					"Erro na consulta de hospedagem. Hospede " + hospede.getNome() + " nao esta hospedado(a).");
		}

		LinkedHashSet<Estadia> hospedagensAtivas = estadias.getHospedagensAtivas(hospede);
		Iterator<Estadia> it = hospedagensAtivas.iterator();

		if (atributo.equalsIgnoreCase("Hospedagens ativas")) {
			retorno += estadias.getHospedagensAtivas(hospede).size();
		} else if (atributo.equalsIgnoreCase("Quarto")) {
			while (it.hasNext()) {
				retorno += it.next().getId() + ",";
			}
			retorno = retorno.substring(0, retorno.length() - 1);
		} else if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			while (it.hasNext()) {
				total += it.next().getPrecoTotal();
			}
			retorno += "R$" + String.format("%.2f", total);
		}
		return retorno;
	}


	/**
	 * 
	 * O metodo atualiza o cadastro de um hospede
	 * 
	 * @param email
	 * @param atributo
	 * @param novoAtributo
	 * @throws Exception
	 */
	public void atualizaCadastro(String email, String atributo, String novoAtributo)
			throws ObjetoInvalidoException, StringInvalidaException {
		Cadastro hospede = cadastros.buscaCadastro(email);
		if (atributo.equalsIgnoreCase("Nome"))
			hospede.setNome(novoAtributo);
		else if (atributo.equalsIgnoreCase("Data de nascimento"))
			hospede.setDataDeNascimento(novoAtributo);
		else if (atributo.equalsIgnoreCase("Email"))
			hospede.setEmail(novoAtributo);
		else
			throw new IllegalArgumentException(); // trocar por uma
													// checkedException
	}
	
	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException{
		String retorno = "";
		
		if (atributo.equalsIgnoreCase("Quantidade")){
			retorno += registroCheckout.size();
		}
		return retorno;
	}

	/**
	 * O metodo busca um quarto atraves do seu id
	 * @param id
	 * @return um objeto quarto 
	 */
	private Quarto buscaQuarto(String id) {
		return quartos.buscaQuarto(id);
	}
}
