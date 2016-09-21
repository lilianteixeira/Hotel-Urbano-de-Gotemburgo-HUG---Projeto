package exceptions;

public class HospedeNotFoundException extends HotelException {

	public HospedeNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public HospedeNotFoundException(String arg0) {
		super("Erro na consulta de hospede. Hospede de email " +  arg0 +  " nao foi cadastrado(a).");
		// TODO Auto-generated constructor stub
	}

	public HospedeNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HospedeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public HospedeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
