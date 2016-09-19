package exceptions;

/**
 * 
 * A classe Email Invalido Exception faz parte da hierarquia de exceptions, 
 * ele lanca uma excecao caso o email recebido seja invalido
 * 
 */
public class EmailInvalidoException extends Exception {

	public EmailInvalidoException() {

		super("O e-mail inserido nao e valido");
		
	}
	
	public EmailInvalidoException(String mensagem) {
		super(mensagem);
	}

}
