package management;

/**
 * faltou esse pacote
 */
import Restaurante.Restaurante;
import exceptions.NumeroInvalidoException;
import exceptions.ObjetoInvalidoException;
import exceptions.StringInvalidaException;
import hotel.*;

public class Controller {

	private Hotel hotel;
	private Restaurante restaurante;

	public Controller() {
		this.hotel = new Hotel();
		this.restaurante = new Restaurante();
	}

	public String cadastraHospede(String nome, String email, String dataNascimento) {
		hotel.cadastraHospede(nome, email, dataNascimento);
		return email;
	}

	public String getInfoHospede(String email, String atributo)
			throws ObjetoInvalidoException, StringInvalidaException {
		return hotel.getInfoHospede(email, atributo);
	}

	public boolean removeHospede(String email) throws ObjetoInvalidoException, StringInvalidaException {
		return hotel.removeCadastro(email);
	}

	public void atualizaCadastro(String email, String atributo, String novoAtributo)
			throws ObjetoInvalidoException, StringInvalidaException {
		hotel.atualizaCadastro(email, atributo, novoAtributo);
	}

	public void cadastraPrato(String nome, double preco, String descricao)
			throws StringInvalidaException, NumeroInvalidoException {
		restaurante.cadastraPrato(nome, preco, descricao);
	}

	public void realizaCheckin(String email, int dias, String id, String tipoQuarto)
			throws ObjetoInvalidoException, StringInvalidaException {
		hotel.buscaQuarto(id);
		hotel.checkIn(email, id, dias);
	}
}
