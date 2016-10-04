package exceptions;

public class HotelException extends Exception {

	

	public HotelException() {
		
	}

	public HotelException(String mensagem) {
		super(mensagem);
	}

	//abaixo desse nao sao necessarios
	public HotelException(Throwable arg0) {
		super(arg0);
	}

	public HotelException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public HotelException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}