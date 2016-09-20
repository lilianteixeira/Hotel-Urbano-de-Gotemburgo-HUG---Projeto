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
	 * O metodo abaixo faz o cadastro de um hospede, adicionando o mesmo na
	 * lista de hospedes cadastrados retornando um boolean indicando se o
	 * hospede foi cadastrado ou nao
	 * 
	 * @param nome
	 * @param email
	 * @param dataDeNascimento
	 * @return um boolean <<<<<<< HEAD
	 * @throws StringInvalidaException
	 *             =======
	 * @throws Exception
	 *             >>>>>>> branch 'master' of
	 *             https://github.com/lilianteixeira/Hotel-Urbano-de-Gotemburgo-HUG---Projeto.git
	 */

	public boolean cadastraHospede(String nome, String email, String dataDeNascimento) throws StringInvalidaException {
		cadastros.addCadastro(CadastroFactory.INSTANCE.create(nome, email, dataDeNascimento));
		return true;
	}

	/**
	 * 
	 * O metodo abaixo remove um hospede cadastrado, atraves do e-mail desse
	 * hospede retorna um boolean indicando se foi removido ou nao
	 * 
	 * @param email
	 * @return um boolean
	 * @throws CadastroNotFoundException 
	 * @throws Exception
	 */
	public boolean removeCadastro(String email) throws CadastroNotFoundException {
		return cadastros.removeCadastro(cadastros.buscaCadastro(email));
	}

	/**
	 * O metodo abaixo faz o checkin do hospede
	 * 
	 * @param email
	 * @param id
	 * @param dias
	 * @throws CadastroNotFoundException 
	 * @throws Exception
	 */
	public void checkIn(String email, int dias, String idQuarto, String tipoQuarto)
			throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException {
		Cadastro hospede = cadastros.buscaCadastro(email);
		if (buscaQuarto(idQuarto) == null) {
			quartos.addQuarto(quartoFactory.create(idQuarto, tipoQuarto));
		}
		if (quartos.buscaQuarto(idQuarto).isOcupado()) {
			throw new ObjetoInvalidoException("Erro ao realizar checkin. Quarto " + idQuarto + " ja esta ocupado.");
		}
		Quarto quarto = buscaQuarto(idQuarto);
		
		// Os resultados do total no teste 03
		// estava dando errado pq quando ele faz um novo chekkin para um quarto
		// que ja estava na lista de quartos ele muda o tipo de quarto de presidencial para luxo
		//Corrigi assim na presssa mesmo. Tá meio POG mas no lab hj agt corrige 
		if (!quarto.getTipoDeQuarto().getClass().toString().equals("class hotel.Quarto" + tipoQuarto)){
			TipoDeQuarto tipo = null;
			if (tipoQuarto.equalsIgnoreCase("simples"))
				tipo = new QuartoSimples();
			else if (tipoQuarto.equalsIgnoreCase("luxo"))
				tipo = new QuartoLuxo();
			else if (tipoQuarto.equalsIgnoreCase("presidencial"))
				tipo = new QuartoPresidencial();
			quarto.setTipoDeQuarto(tipo);
		}
		Estadia estadia = EstadiaFactory.INSTANCE.create(quarto, dias);
		estadias.putEstadia(estadia, hospede);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}

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
	 * @throws Exception
	 */
	public String checkOut(String email, String idQuarto) throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException{
		
		Cadastro hospede = cadastros.buscaCadastro(email);
		LinkedHashSet<Estadia> hospedagensAtivas = estadias.getHospedagensAtivas(hospede);
		Iterator<Estadia> it = hospedagensAtivas.iterator();
		double totalEstadia = 0;
		for (Estadia estadia : hospedagensAtivas) {
			if (estadia.getId().equals(idQuarto)) {
				totalEstadia += estadia.getPrecoTotal();
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
			if (entrada.getValue() == hospede) { // Essa comparação é possível,
													// já que não vão existir
													// duas instâncias de
													// Hospedes iguais

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
	 * O metodo abaixo pega as informacoes de um hospede retorna uma String com
	 * a informacao desejada
	 * 
	 * @param email
	 * @param atributo
	 * @return uma String
	 * @throws Exception
	 */
	public String getInfoHospede(String email, String atributo) throws Exception {
		return cadastros.getInfoCadastro(email, atributo);
	}

	public String getInfoHospedagem(String email, String atributo)
			throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException {
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

	public void atualizaCadastro(String email, String atributo, String valor)
			throws Exception {
		cadastros.setInfoCadastro(email, atributo, valor);
	}
	
	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException{
		String retorno = "";
		
		if (atributo.equalsIgnoreCase("Quantidade")){
			retorno += registroCheckout.size();
		}
		else if(atributo.equalsIgnoreCase("Total")){
			double total =0;
			for (RegistroCheckOut registro : registroCheckout) {
				total += registro.getTotalPago();
			}
			retorno += "R$" + String.format("%.2f", total);
		}
		else if(atributo.equalsIgnoreCase("Nome")){
			for (RegistroCheckOut registro : registroCheckout) {
				retorno += registro.getNome() + ";";
			}
			retorno = retorno.substring(0, retorno.length() - 1);
		}
		return retorno;
	}
	
	public String consultaTransacoes(String atributo, int indice) {
		String retorno = "";
		
		if(atributo.equalsIgnoreCase("Total")){
			double total = registroCheckout.get(indice).getTotalPago();
			retorno += "R$" + String.format("%.2f", total);
		} if(atributo.equalsIgnoreCase("Nome")){
			retorno += registroCheckout.get(indice).getNome();

		}
		return retorno;
	}

	/**
	 * O metodo busca um quarto atraves do seu id
	 * 
	 * @param id
	 * @return um objeto quarto
	 */
	private Quarto buscaQuarto(String id) {
		return quartos.buscaQuarto(id);
	}


}
