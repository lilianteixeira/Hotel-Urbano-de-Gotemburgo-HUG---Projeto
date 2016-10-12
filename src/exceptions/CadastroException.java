package exceptions;

public class CadastroException extends HospedeException {

	public CadastroException(String mensagem) {
		super("Erro no cadastro de Hospede. " + mensagem);
	}

}