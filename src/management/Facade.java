package management;

import easyaccept.EasyAccept;
import exceptions.*;
import hotel.Hotel;

public class Facade {

	Hotel hotel;

	public Facade() {

	}

	public void iniciaSistema() {
		this.hotel = Hotel.getInstance();
	}

	public void fechaSistema() {
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

	

//	
//
//	
//
//	/*
//	 * public String realizaCheckout(String email, String idQuarto) throws
//	 * Exception { return controller.realizaCheckout(email, idQuarto); }
//	 */
//
//	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException {
//		return controller.consultaTransacoes(atributo);
//	}
//
//	public String consultaTransacoes(String atributo, int indice)
//			throws ObjetoInvalidoException, StringInvalidaException {
//		return controller.consultaTransacoes(atributo, indice);
//	}
//
//	public void cadastraPrato(String nome, double preco, String descricao) throws Exception {
//		controller.cadastraPrato(nome, preco, descricao);
//	}

	public static void main(String[] args) {
		args = new String[] { "management.Facade", "resources/acceptance_test/testes_juntos.txt" };
		EasyAccept.main(args);
	}
}