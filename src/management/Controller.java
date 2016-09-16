package management;

import Restaurante.RestauranteController;
import exceptions.ObjetoInvalidoException;
import hotel.Hotel;

public class Controller {

	private Hotel hotel;
	private RestauranteController restaurante;

	public Controller() {
		this.hotel = new Hotel();
		this.restaurante = new RestauranteController();
	}

	public String cadastraHospede(String nome, String email, String dataNascimento) throws Exception {
		return hotel.cadastraHospede(nome, email, dataNascimento);
	}
	
	public String getInfoHospede(String email, String atributo) throws Exception{
		return hotel.getInfoHospede(email, atributo);
	}

	public void removeHospede(String email) {
		hotel.removeHospede(email);
	}
	
	public void atualizaCadastro(String email, String atributo, String novoAtributo){
		hotel.atualizaCadastro(email, atributo, novoAtributo);
	}
	
	public void cadastraPrato(String nome, double preco, String descricao) throws Exception{
		restaurante.cadastraPrato(nome, preco, descricao);
	}
}
