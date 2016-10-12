package exceptions;

public class RemoveHospedeException extends Exception {
	public RemoveHospedeException() {
		// TODO Auto-generated constructor stub
	}

	public RemoveHospedeException(String arg0) {
		super("Erro na remocao do Hospede. " + arg0);
		// TODO Auto-generated constructor stub
	}
}
