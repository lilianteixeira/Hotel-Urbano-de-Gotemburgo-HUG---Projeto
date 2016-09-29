package exceptions;

public class CheckoutException extends HotelException {

	public CheckoutException() {
		// TODO Auto-generated constructor stub
	}

	public CheckoutException(String arg0) {
		super("Erro ao realizar checkout. " + arg0);
	}

	public CheckoutException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CheckoutException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CheckoutException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}