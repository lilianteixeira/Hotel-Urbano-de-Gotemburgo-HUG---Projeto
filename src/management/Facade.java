package management;

import cadastro.CadastroNotFoundException;
import easyaccept.EasyAccept;
import exceptions.*;

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
	public String getInfoHospedagem(String email, String atributo) throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException{
		return controller.getInfoHospedagem(email, atributo);
	}

	public void atualizaCadastro(String email, String atributo, String novoAtributo)
			throws Exception {
		controller.atualizaCadastro(email, atributo, novoAtributo);
	}

	public void removeHospede(String email) throws Exception {
		controller.removeHospede(email);
	}
	
	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto) throws ObjetoInvalidoException, StringInvalidaException, CadastroNotFoundException{
		controller.realizaCheckin(email, dias, idQuarto, tipoQuarto);
	}
	public String realizaCheckout(String email, String idQuarto) throws Exception{
		return controller.realizaCheckout(email, idQuarto);
	}
	
	public String consultaTransacoes(String atributo) throws ObjetoInvalidoException, StringInvalidaException{
		return controller.consultaTransacoes( atributo);
	}
	
	public String consultaTransacoes(String atributo, int indice) throws ObjetoInvalidoException, StringInvalidaException{
		return controller.consultaTransacoes( atributo, indice);
	}
	
	public void cadastraPrato(String nome, double preco, String descricao) throws Exception {
		controller.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception{
		controller.cadastraRefeicao(nome, descricao, componentes);
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception{
		return controller.consultaRestaurante(nome, atributo);
	}

	public static void main(String[] args) {
		args = new String[] { "management.Facade", "resources/acceptance_test/testes_juntos.txt",
/*				"resources/acceptance_test/testes_uc1.txt",
				"resources/acceptance_test/testes_uc1_exception.txt",
				"resources/acceptance_test/testes_uc2.txt",
				"resources/acceptance_test/testes_uc2_exception.txt",
				"resources/acceptance_test/testes_uc3.txt",
				"resources/acceptance_test/testes_uc3_exception.txt",*/
				"resources/acceptance_test/testes_uc4.txt",
				"resources/acceptance_test/testes_uc4_exception.txt"};
		EasyAccept.main(args);
	}
}