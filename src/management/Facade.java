package management;

import easyaccept.EasyAccept;

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

	public void atualizaCadastro(String email, String atributo, String novoAtributo) {
		controller.atualizaCadastro(email, atributo, novoAtributo);
	}

	public void removeHospede(String email) {
		controller.removeHospede(email);
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws Exception {
		controller.cadastraPrato(nome, preco, descricao);
	}

	public static void main(String[] args) {
		args = new String[] { "management.Facade", "resources/acceptance_test/testes_uc1.txt",
				"resources/acceptance_test/testes_uc4.txt" };
		EasyAccept.main(args);
	}
}
