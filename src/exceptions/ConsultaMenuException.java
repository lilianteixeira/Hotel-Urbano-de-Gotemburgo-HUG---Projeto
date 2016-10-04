package exceptions;

public class ConsultaMenuException extends Exception {
	
	public ConsultaMenuException() {
	}
	
	public ConsultaMenuException(String mensagem){
		super("Erro na consulta do restaurante. " + mensagem);
	}

}