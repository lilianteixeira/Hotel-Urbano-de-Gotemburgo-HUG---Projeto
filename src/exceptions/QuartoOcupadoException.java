package exceptions;

public class QuartoOcupadoException extends EstadiaException{

	public QuartoOcupadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public QuartoOcupadoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QuartoOcupadoException(String id) {
		super(String.format("Quarto %s ja esta ocupado.", id));
		// TODO Auto-generated constructor stub
	}

	public QuartoOcupadoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public QuartoOcupadoException() {
		// TODO Auto-generated constructor stub
	}

}
