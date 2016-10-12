package exceptions;

public class PratoCadastroException extends RestauranteException {

	public PratoCadastroException() {
		
	}

	public PratoCadastroException(String mensagem) {
		super("Erro no cadastro do prato. " + mensagem);
	}

}