package exceptions;

public class CheckinException extends Exception {

	public CheckinException() {
		// TODO Auto-generated constructor stub
	}

	public CheckinException(String arg0) {
		super("Erro ao realizar checkin. " + arg0);
		// TODO Auto-generated constructor stub
	}

	public CheckinException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CheckinException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CheckinException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	
	
}
