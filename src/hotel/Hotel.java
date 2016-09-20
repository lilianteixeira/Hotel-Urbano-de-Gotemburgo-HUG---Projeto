package hotel;

import java.util.Iterator;
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
	private QuartoSet quartos;

	/**
	 * Construtor da classe Hotel
	 */
	public Hotel() {
		this.cadastros = new CadastroSet();
		this.estadias = new EstadiaMap();
		this.registros = new RegistroSet();
		this.quartos = new QuartoSet();
	}

	/**
	 * O metodo abaixo faz o cadastro de um hospede, adicionando o mesmo na
	 * lista de hospedes cadastrados retornando um boolean indicando se o
	 * hospede foi cadastrado ou nao
	 * 
	 * @param nome
	 * @param email
	 * @param dataDeNascimento
	 * @return um boolean
	 * @throws StringInvalidaException
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
	 * @throws Exception
	 */
	public boolean removeCadastro(String email) throws Exception {
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
	public void checkIn(String email, String id, int dias) throws Exception {
		Cadastro hospede = cadastros.buscaCadastro(email);
		Quarto quarto = quartos.buscaQuarto(id);
		Estadia estadia = EstadiaFactory.INSTANCE.create(quarto, dias);
		estadias.putEstadia(estadia, hospede);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}

	/**
	 * O metodo abaixo faz o checkout de um hospede que está no hotel
	 * 
	 * @param email
	 * @throws Exception
	 */
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

	/**
	 * 
	 * O metodo atualiza o cadastro de um hospede
	 * 
	 * @param email
	 * @param atributo
	 * @param novoAtributo
	 * @throws Exception
	 */
	public void atualizaCadastro(String email, String atributo, String novoAtributo) throws Exception {
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

	/**
	 * O metodo busca um quarto atraves do seu id
	 * 
	 * @param id
	 * @return um objeto quarto
	 */
	public Quarto buscaQuarto(String id) {
		return quartos.buscaQuarto(id);
	}
}
