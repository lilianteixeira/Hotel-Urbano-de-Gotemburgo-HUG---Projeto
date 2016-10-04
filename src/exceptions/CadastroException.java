package exceptions;

public class CadastroException extends Exception {

	public CadastroException(String mensagem) {
		super("Erro no cadastro de Hospede. " + mensagem);
	}

}