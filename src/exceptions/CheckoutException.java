package exceptions;

public class CheckoutException extends HospedagemException {

	public CheckoutException() {
		
	}
	
	public CheckoutException(String mensagem) {
		super("Erro ao realizar checkout. " + mensagem);
	}


}