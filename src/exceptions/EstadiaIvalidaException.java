package exceptions;

public class EstadiaIvalidaException extends Exception{

	public EstadiaIvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EstadiaIvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public EstadiaIvalidaException(String message) {
		super(message);
	}

	public EstadiaIvalidaException(Throwable cause) {
		super(cause);
	}

	public EstadiaIvalidaException() {
	}

}