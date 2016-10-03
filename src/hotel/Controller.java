package hotel;


import hospede.BancoDeHospedes;
import restaurante.Restaurante;

public class Controller {
	private BancoDeHospedes bancoDeHospedes;
	private Restaurante restaurante;
	
	public Controller(){
		this.bancoDeHospedes = new BancoDeHospedes();
		this.restaurante = new Restaurante();
	}
	
	public String cadastraHospede(String nome, String email, String dataDeNascimento) throws Exception {
		return bancoDeHospedes.cadastraHospede(nome, email, dataDeNascimento);
	}
	
	public String getInfoHospede(String email, String atributo) throws Exception{
		return bancoDeHospedes.getInfoHospede(email, atributo);
	}
	
	public void atualizaCadastro(String email, String atributo, String alteracao) throws Exception{
		bancoDeHospedes.atualizaCadastro(email, atributo, alteracao);
	}
	
	public void removeHospede(String email)throws Exception{
		bancoDeHospedes.removeHospede(email);
	}
	public void realizaCheckin(String email, int dias, String idQuarto, String tipoQuarto)
			throws Exception{
		bancoDeHospedes.checkIn(email, dias, idQuarto, tipoQuarto);
	}
	public String realizaCheckout(String email, String tipoQuarto)
			throws Exception{
		return bancoDeHospedes.checkout(email, tipoQuarto);
	}
	public String getInfoHospedagem(String email, String atributo)
			throws Exception {
		return bancoDeHospedes.getInfoHospedagem(email, atributo);
	}
	public String consultaTransacoes(String atributo) throws Exception {
		return bancoDeHospedes.consultaTransacoes(atributo);
	}
	public String consultaTransacoes(String atributo, int indice) throws Exception {
		return bancoDeHospedes.consultaTransacoes(atributo, indice);
	}
	public void cadastraPrato(String nome, double preco, String descricao)
			throws Exception {
		restaurante.cadastraPrato(nome, preco, descricao);
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception {
		restaurante.cadastraRefeicao(nome, descricao, componentes);
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception{
		return restaurante.consultaRestaurante(nome, atributo);
	}
	public String consultaMenuRestaurante() {
		return restaurante.consultaMenuRestaurante();
	}

	public String realizaPedido(String email, String itemMenu) throws Exception {
		double valorRefeicao = restaurante.buscaRefeicao(itemMenu).getValor();
		return bancoDeHospedes.realizaPedido(email, itemMenu, valorRefeicao);
	}
	
	public String convertePontos (String email, int qtdPontos) throws Exception{
		return bancoDeHospedes.convertePontos(email, qtdPontos);
	}

	public void ordenaMenu(String tipoOrdenacao) {
		restaurante.ordenaMenu(tipoOrdenacao);
		
	}
}
