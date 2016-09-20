package hotel;

public class GetInfoException extends HotelException {

	public GetInfoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetInfoException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public GetInfoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public GetInfoException(String arg0) {
		super("Erro ao realizar checkin. " + arg0);
		// TODO Auto-generated constructor stub
	}

	public GetInfoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
