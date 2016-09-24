package exceptions;

public class HotelRemoveException extends HotelException {

	public HotelRemoveException() {
		// TODO Auto-generated constructor stub
	}

	public HotelRemoveException(String arg0) {
		super("Erro na remocao do Hospede. " + arg0);
		// TODO Auto-generated constructor stub
	}

	public HotelRemoveException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HotelRemoveException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public HotelRemoveException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
