package management;

import easyaccept.EasyAccept;
import exceptions.*;

public class Facade {

	private Controller controller;

	public Facade() {

	}

	public void iniciaSistema() {
		this.controller = new Controller();
	}

	public void fechaSistema() {
	}

	public String cadastraHospede(String nome, String email, String dataNascimento) throws HotelCadastroException {
		return controller.cadastraHospede(nome, email, dataNascimento);
	}
	
	public void atualizaCadastro(String email, String atributo, String valor) throws CadastroNotFoundException, AtualizaCadastroException {
		controller.atualizaCadastro(email, atributo, valor);
	}
	
	public void removeHospede(String email) throws HospedeNotFoundException, HotelRemoveException {
		controller.removeHospede(email);
	}

	public String getInfoHospede(String email, String atributo) throws GetInfoException, HospedeNotFoundException {
		return controller.getInfoHospede(email, atributo);
	}
	
	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto) throws CheckinException {
		controller.realizaCheckin(email, dias, idQuarto, tipoQuarto);
	}

	public String getInfoHospedagem(String email, String atributo) throws HospedagemInfoException {
		return controller.getInfoHospedagem(email, atributo);
	}

	public String realizaCheckout(String email, String quarto) throws CheckoutException, QuartoNotFoundException {
		return controller.realizaCheckout(email, quarto);
	}


	public String consultaTransacoes(String atributo) throws ConsultaRegistroException {
		return controller.consultaTransacoes(atributo);
	}
	
	public String consultaTransacoes(String atributo, int indice) throws ConsultaRegistroException {
		return controller.consultaTransacoes(atributo, indice);
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws PratoCadastroException {
		controller.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws RefeicaoCadastroException {
		controller.cadastraRefeicao(nome, descricao, componentes);
	}
	
	public String consultaRestaurante(String nome, String atributo) throws ConsultaMenuException {
		return controller.consultaRestaurante(nome, atributo);
	}

	public static void main(String[] args) {
		args = new String[] { "management.Facade", "resources/acceptance_test/testes.txt" };
		EasyAccept.main(args);
	}
}