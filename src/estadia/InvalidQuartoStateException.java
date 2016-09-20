package estadia;

public class InvalidQuartoStateException extends EstadiaException{

	public InvalidQuartoStateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidQuartoStateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidQuartoStateException(String id) {
		super(String.format("Erro ao realizar checkin. Quarto %s ja esta ocupado.", id));
		// TODO Auto-generated constructor stub
	}

	public InvalidQuartoStateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidQuartoStateException() {
		// TODO Auto-generated constructor stub
	}

}
