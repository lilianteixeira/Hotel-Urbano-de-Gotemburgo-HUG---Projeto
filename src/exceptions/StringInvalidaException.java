/**
 * @author Antonio Dartagnan S. C. Junior - 114210775 Turma 02
 */
package exceptions;

public class StringInvalidaException extends Exception {

	public StringInvalidaException (String mensagem) {
		super(mensagem);
	}

	public StringInvalidaException() {
		super();
	}
}
