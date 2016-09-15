package management;

import hotel.Hotel;

public class Controller {

	private Hotel hotel;

	public Controller() {
		this.hotel = new Hotel();
	}

	public String cadastraHospede(String nome, String email,
			String dataNascimento) throws Exception {
		return hotel.cadastraHospede(nome, email, dataNascimento);
	}

	public boolean removeHospede(String email) {
		return hotel.removeHospede(email);
	}

}
