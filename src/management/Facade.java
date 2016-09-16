package management;

import easyaccept.EasyAccept;

public class Facade {

	Controller controller;

	public Facade() {

	}

	public void iniciaSistema() {

	}

	public void fechaSistema() {
	}

	public String cadastraHospede(String nome, String email, String dataNascimento) throws Exception {
		return controller.cadastraHospede(nome, email, dataNascimento);
	}

	public boolean removeHospede(String email) {
		return controller.removeHospede(email);
	}
	
	public void cadastraPrato(String nome, double preco, String descricao) throws Exception{
		controller.cadastraPrato(nome, preco, descricao);
	}
	public static void main(String[] args) {
		args = new String[] { "management.Facade", "resources/acceptance_test/testes_uc1.txt",
							  "resources/acceptance_test/testes_uc4.txt" };
		EasyAccept.main(args);
	}
}
