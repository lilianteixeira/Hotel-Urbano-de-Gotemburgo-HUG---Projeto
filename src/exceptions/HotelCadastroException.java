package exceptions;

public class HotelCadastroException extends HotelException {

	public HotelCadastroException(String arg0) {
		super("Erro no cadastro de Hospede. " + arg0);
	}

}
