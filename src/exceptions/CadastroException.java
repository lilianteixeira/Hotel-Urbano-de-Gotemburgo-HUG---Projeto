package exceptions;

public class CadastroException extends HotelException {

	public CadastroException(String arg0) {
		super("Erro no cadastro de Hospede. " + arg0);
	}

}