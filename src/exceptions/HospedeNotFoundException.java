package exceptions;

public class HospedeNotFoundException extends HospedeException {
	
	public HospedeNotFoundException() {
		super();
	}

	public HospedeNotFoundException(String mensagem) {
		super("Erro na consulta de " + mensagem);
		
	}

}
