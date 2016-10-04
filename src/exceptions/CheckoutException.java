package exceptions;

public class CheckoutException extends Exception {

	public CheckoutException() {
		
	}
	
	public CheckoutException(String mensagem) {
		super("Erro ao realizar checkout. " + mensagem);
	}


}