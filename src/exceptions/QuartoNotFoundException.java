package exceptions;

public class QuartoNotFoundException extends QuartoSetException {

	public QuartoNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public QuartoNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public QuartoNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public QuartoNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public QuartoNotFoundException() {
		super("Quarto não encontrado");
	}

}