package management;

import hotel.Hotel;

public class Controller {

	private Hotel hotel;

	public Controller() {
		this.hotel = new Hotel();
	}

	public void cadastraHospede(String nome, String email, String dataNascimento) throws Exception {

		hotel.cadastraHospede(nome, email, dataNascimento);
	}
}
