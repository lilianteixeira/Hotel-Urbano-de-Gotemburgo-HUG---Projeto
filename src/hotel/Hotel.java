package hotel;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cadastro.*;
import exceptions.*;

public class Hotel {
	private CadastroSet cadastros;
	private EstadiaMap estadias;
	private RegistroSet registros;
	private QuartoSet quartos;

	public Hotel() {
		this.cadastros = new CadastroSet();
		this.estadias = new EstadiaMap();
		this.registros = new RegistroSet();
		this.quartos = new QuartoSet();
	}

	public boolean cadastraHospede(String nome, String email, String dataDeNascimento) {
		cadastros.addCadastro(CadastroFactory.INSTANCE.create(nome, email, dataDeNascimento));
		return true;
	}

	public boolean removeCadastro(String email) {
		return cadastros.removeCadastro(cadastros.buscaCadastro(email));
	}

	public void checkIn(String email, String id, int dias) {
		Cadastro hospede = cadastros.buscaCadastro(email);
		Quarto quarto = quartos.buscaQuarto(id);
		Estadia estadia = EstadiaFactory.INSTANCE.create(quarto, dias);
		estadias.putEstadia(estadia, hospede);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}

	public void checkOut(String email) {
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

	public String getInfoHospede(String email, String atributo) throws ObjetoInvalidoException {
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

	public void atualizaCadastro(String email, String atributo, String novoAtributo) {
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
}
