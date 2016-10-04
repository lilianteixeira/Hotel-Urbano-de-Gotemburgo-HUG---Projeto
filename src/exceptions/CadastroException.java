package exceptions;

public class CadastroException extends HotelException {

	public CadastroException(String mensagem) {
		super("Erro no cadastro de Hospede. " + mensagem);
	}

}