package management;

import exceptions.AtualizaCadastroException;
import exceptions.CadastroNotFoundException;
import exceptions.CheckinException;
import exceptions.CheckoutException;
import exceptions.ConsultaMenuException;
import exceptions.ConsultaRegistroException;
import exceptions.GetInfoException;
import exceptions.HospedagemInfoException;
import exceptions.HospedeNotFoundException;
import exceptions.HotelCadastroException;
import exceptions.HotelRemoveException;
import exceptions.RefeicaoCadastroException;
import exceptions.PratoCadastroException;
import exceptions.QuartoNotFoundException;
import hotel.*;
import restaurante.Restaurante;

public class Controller {

	private Hotel hotel;
	private Restaurante restaurante;

	public Controller() {
		this.hotel = Hotel.getInstance();
		this.restaurante = Restaurante.getInstance();
	}


	public String cadastraHospede(String nome, String email, String dataNascimento) throws HotelCadastroException {
		return hotel.cadastraHospede(nome, email, dataNascimento);
	}
	
	public void atualizaCadastro(String email, String atributo, String valor) throws CadastroNotFoundException, AtualizaCadastroException {
		hotel.atualizaCadastro(email, atributo, valor);
	}
	
	public void removeHospede(String email) throws HospedeNotFoundException, HotelRemoveException {
		hotel.removeHospede(email);
	}

	public String getInfoHospede(String email, String atributo) throws GetInfoException, HospedeNotFoundException {
		return hotel.getInfoHospede(email, atributo);
	}
	
	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto) throws CheckinException {
		hotel.realizaCheckin(email, dias, idQuarto, tipoQuarto);
	}

	public String getInfoHospedagem(String email, String atributo) throws HospedagemInfoException {
		return hotel.getInfoHospedagem(email, atributo);
	}

	public String realizaCheckout(String email, String quarto) throws CheckoutException, QuartoNotFoundException {
		return hotel.realizaCheckout(email, quarto);
	}


	public String consultaTransacoes(String atributo) throws ConsultaRegistroException {
		return hotel.consultaTransacoes(atributo);
	}
	
	public String consultaTransacoes(String atributo, int indice) throws ConsultaRegistroException {
		return hotel.consultaTransacoes(atributo, indice);
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws PratoCadastroException {
		restaurante.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws RefeicaoCadastroException {
		restaurante.cadastraRefeicao(nome, descricao, componentes);
	}
	
	public String consultaRestaurante(String nome, String atributo) throws ConsultaMenuException {
		return restaurante.consultaRestaurante(nome, atributo);
	}
}