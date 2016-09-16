package management;

import Restaurante.RestauranteController;
import exceptions.NumeroInvalidoException;
import exceptions.StringInvalidaException;
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

	public boolean removeHospede(String email) {
		return hotel.removeHospede(email);
	}

	public void cadastraPrato(String nome, double preco, String descricao) throws Exception{
		restaurante.cadastraPrato(nome, preco, descricao);
	}
}
