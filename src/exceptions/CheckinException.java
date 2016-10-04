package exceptions;

public class CheckinException extends Exception {
	
	public CheckinException() {
		
	}

	public CheckinException(String mensagem){
		super("Erro ao realizar checkin. " + mensagem);
	}


	
	
}
