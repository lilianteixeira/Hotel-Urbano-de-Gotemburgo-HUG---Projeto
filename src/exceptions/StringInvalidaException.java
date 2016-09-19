package exceptions;

/**
 * 
 * A classe String Invalida Exception faz parte da hierarquia de exceptions, 
 * ela lanca uma excecao caso a string recebido seja invalida
 * 
 */
public class StringInvalidaException extends Exception {

	public StringInvalidaException (String mensagem) {
		super(mensagem);
	}

	public StringInvalidaException() {
		super("A string informada e invalida");
	}
}
