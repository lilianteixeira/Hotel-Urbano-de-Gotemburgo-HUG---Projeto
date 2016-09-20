package management;

import Restaurante.Restaurante;
import cadastro.CadastroNotFoundException;
import estadia.InvalidQuartoStateException;
import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import hotel.*;
import quarto.QuartoNotFoundException;

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

	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto)
			throws CadastroNotFoundException, QuartoNotFoundException, InvalidQuartoStateException {
		//hotel.buscaQuarto(id);
		hotel.checkIn(email, dias, idQuarto, tipoQuarto);
	}
	
	/*public String realizaCheckout(String email, String idQuarto) throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException, QuartoNotFoundException{
		return hotel.checkOut(email, idQuarto);
	}*/



	
}