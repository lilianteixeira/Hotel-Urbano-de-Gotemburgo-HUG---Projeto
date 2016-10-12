package exceptions;

public class CheckinException extends HospedagemException {
	
	public CheckinException() {
		
	}

	public CheckinException(String mensagem){
		super("Erro ao realizar checkin. " + mensagem);
	}


	
	
}
