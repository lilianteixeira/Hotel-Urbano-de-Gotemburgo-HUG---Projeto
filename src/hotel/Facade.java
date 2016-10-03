package hotel;

import easyaccept.EasyAccept;

public class Facade {
	private Controller controller = new Controller();

	public Facade() {

	}

	public void iniciaSistema() {

	}

	public void fechaSistema() {

	}

	public String cadastraHospede(String nome, String email, String dataDeNascimento) throws Exception {
		return controller.cadastraHospede(nome, email, dataDeNascimento);
	}

	public String getInfoHospede(String email, String atributo) throws Exception {
		return controller.getInfoHospede(email, atributo);
	}
	
	public String getHospedeInfo(String email, String atributo) throws Exception {
		return controller.getInfoHospede(email, atributo);
	}

	public void atualizaCadastro(String email, String atributo, String alteracao) throws Exception{
		controller.atualizaCadastro(email, atributo, alteracao);
	}

	public void removeHospede(String email)throws Exception {
		controller.removeHospede(email);
	}
	
	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto) throws Exception {
		controller.realizaCheckin(email, dias, idQuarto, tipoQuarto);
	}
	public String realizaCheckout(String email, String idQuarto) throws Exception {
		return controller.realizaCheckout(email, idQuarto);
	}
	
	
	public String getInfoHospedagem(String email, String atributo) throws Exception {
		return controller.getInfoHospedagem(email, atributo);
	}
	public String consultaTransacoes(String atributo) throws Exception {
		return controller.consultaTransacoes(atributo);
	}
	public String consultaTransacoes(String atributo, int indice) throws Exception {
		return controller.consultaTransacoes(atributo, indice);
	}
	public void cadastraPrato(String nome, double preco, String descricao) throws Exception {
		controller.cadastraPrato(nome, preco, descricao);
	}

	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception {
		controller.cadastraRefeicao(nome, descricao, componentes);
	}

	public String consultaRestaurante(String nome, String atributo) throws Exception {
		return controller.consultaRestaurante(nome, atributo);
	}
	public String consultaMenuRestaurante() {
		return controller.consultaMenuRestaurante();
	}
	
	public String realizaPedido(String email, String itemMenu) throws Exception{
		return controller.realizaPedido(email, itemMenu);
	}
	public void ordenaMenu(String tipoOrdenacao){
		controller.ordenaMenu(tipoOrdenacao);
	}
	
	public String convertePontos (String email, int qtdPontos) throws Exception{
		return controller.convertePontos(email, qtdPontos);
	}
	
	public static void main(String[] args) {
		args = new String[] { "hotel.Facade", 
							  "resources/acceptance_test/testes_uc1.txt",
							  "resources/acceptance_test/testes_uc1_exception.txt",
							  "resources/acceptance_test/testes_uc2.txt",
							  "resources/acceptance_test/testes_uc2_exception.txt",
							  "resources/acceptance_test/testes_uc3.txt",
							  "resources/acceptance_test/testes_uc3_exception.txt",
							  "resources/acceptance_test/testes_uc4.txt",
							  "resources/acceptance_test/testes_uc4_exception.txt",
							  "resources/acceptance_test/testes_uc5.txt",
							  "resources/acceptance_test/testes_uc6.txt",
							  "resources/acceptance_test/testes_uc7.txt"
							  
							  
		};
		EasyAccept.main(args);
	}
}
