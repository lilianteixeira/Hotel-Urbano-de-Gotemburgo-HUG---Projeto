package management;

import Restaurante.Restaurante;
import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import hotel.Hotel;

public class Controller {

	private Hotel hotel;
	private Restaurante restaurante;

	public Controller() {
		this.hotel = new Hotel();
		this.restaurante = new Restaurante();
	}

	public boolean cadastraHospede(String nome, String email, String dataNascimento) {
		return hotel.cadastraHospede(nome, email, dataNascimento);
	}

	public String getInfoHospede(String email, String atributo) throws ObjetoInvalidoException {
		return hotel.getInfoHospede(email, atributo);
	}

	public boolean removeHospede(String email) {
		return hotel.removeCadastro(email);
	}

	public void atualizaCadastro(String email, String atributo, String novoAtributo) {
		hotel.atualizaCadastro(email, atributo, novoAtributo);
	}

	public void cadastraPrato(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {
		restaurante.cadastraPrato(nome, preco, descricao);
	}
}
