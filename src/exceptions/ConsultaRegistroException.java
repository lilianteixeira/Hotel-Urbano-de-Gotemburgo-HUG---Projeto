package exceptions;

public class ConsultaRegistroException extends RegistroException {

	public ConsultaRegistroException() {
		super();
	}
	
	public ConsultaRegistroException(String msg) {
		super("Erro na consulta de transacoes. " + msg);
	}

}
