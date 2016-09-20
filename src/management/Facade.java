package management;

import cadastro.CadastroNotFoundException;
import easyaccept.EasyAccept;
import estadia.InvalidQuartoStateException;
import exceptions.*;
import quarto.QuartoNotFoundException;

public class Facade {

	Controller controller;

	public Facade() {

	}

	public void iniciaSistema() {
		this.controller = new Controller();
	}

	public void fechaSistema() {
	}

	public String cadastraHospede(String nome, String email, String dataNascimento) throws Exception {
		return controller.cadastraHospede(nome, email, dataNascimento);
	}

	public String getInfoHospede(String email, String atributo) throws Exception {
		return controller.getInfoHospede(email, atributo);
	}

	/*public String getInfoHospedagem(String email, String atributo)
			throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException {
		return controller.getInfoHospedagem(email, atributo);
	}*/

	public void atualizaCadastro(String email, String atributo, String novoAtributo) throws Exception {
		controller.atualizaCadastro(email, atributo, novoAtributo);
	}

	public void removeHospede(String email) throws Exception {
		controller.removeHospede(email);
	}

	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto)
			throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException, QuartoNotFoundException,
			InvalidQuartoStateException {
		controller.realizaCheckin(email, dias, idQuarto, tipoQuarto);
	}

	/*public String realizaCheckout(String email, String idQuarto) throws Exception {
		return controller.realizaCheckout(email, idQuarto);
	}*/

	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException {
		return controller.consultaTransacoes(atributo);
	}

	public String consultaTransacoes(String atributo, int indice)
			throws ObjetoInvalidoException, StringInvalidaException {
		return controller.consultaTransacoes(atributo, indice);
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws Exception {
		controller.cadastraPrato(nome, preco, descricao);
	}

	public static void main(String[] args) {
		args = new String[] { "management.Facade", "resources/acceptance_test/testes_juntos.txt" };
		EasyAccept.main(args);
	}
}