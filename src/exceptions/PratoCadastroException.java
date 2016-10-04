package exceptions;

public class PratoCadastroException extends Exception {

	public PratoCadastroException() {
		
	}

	public PratoCadastroException(String mensagem) {
		super("Erro no cadastro do prato. " + mensagem);
	}

}