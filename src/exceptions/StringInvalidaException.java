package exceptions;

public class StringInvalidaException extends Exception{
	
	public StringInvalidaException() {
	}
	
	public StringInvalidaException(String mensagem){
		super(mensagem);
	}
}
