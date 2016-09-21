package management;

import Restaurante.Restaurante;
import exceptions.CadastroNotFoundException;
import exceptions.CheckinException;
import exceptions.GetInfoException;
import exceptions.HospedeNotFoundException;
import exceptions.HotelCadastroException;
import exceptions.InvalidQuartoStateException;
import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
import exceptions.QuartoNotFoundException;
import exceptions.StringInvalidaException;
import hotel.*;

public class Controller {

	private Hotel hotel;
	private Restaurante restaurante;

	public Controller() {
		this.hotel = new Hotel();
		this.restaurante = new Restaurante();
	}


	public String cadastraHospede(String nome, String email, String dataNascimento) throws HotelCadastroException {
		hotel.cadastraHospede(nome, email, dataNascimento);
		return email;
	}

  	public String getInfoHospede(String email, String atributo) throws GetInfoException, HospedeNotFoundException {
		return hotel.getInfoHospede(email, atributo);
	}
/*	public String getInfoHospedagem(String email, String atributo) throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException{
		return hotel.getInfoHospedagem(email, atributo);
	}*/

	public boolean removeHospede(String email) throws HospedeNotFoundException {
		return hotel.removeHospede(email);
	}
	
	public void atualizaCadastro(String email, String atributo, String novoAtributo)
			throws Exception {
		hotel.atualizaCadastro(email, atributo, novoAtributo);
	}
	
	public String consultaTransacoes( String atributo) throws ObjetoInvalidoException, StringInvalidaException{
		return hotel.consultaTransacoes(atributo);
	}
	public String consultaTransacoes(String atributo, int indice) {
		return hotel.consultaTransacoes(atributo, indice);
	}
	public void cadastraPrato(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {
		restaurante.cadastraPrato(nome, preco, descricao);
	}

	public void realizaCheckin(String email, int dias, String Quarto, String tipoQuarto) throws CheckinException {
		hotel.realizaCheckin(email, dias, Quarto, tipoQuarto);
	}
	
	/*public String realizaCheckout(String email, String idQuarto) throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException, QuartoNotFoundException{
		return hotel.checkOut(email, idQuarto);
	}*/



	
}