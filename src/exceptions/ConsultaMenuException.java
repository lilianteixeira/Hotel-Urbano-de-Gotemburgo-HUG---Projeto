package exceptions;

public class ConsultaMenuException extends RestauranteException {

	public ConsultaMenuException() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaMenuException(String arg0) {
		super("Erro na consulta do restaurante. " + arg0);
		// TODO Auto-generated constructor stub
	}

	public ConsultaMenuException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ConsultaMenuException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ConsultaMenuException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}