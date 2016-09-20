package hotel;

public class HotelCadastroException extends HotelException {

	public HotelCadastroException() {
		// TODO Auto-generated constructor stub
	}

	public HotelCadastroException(String arg0) {
		super("Erro no cadastro de Hospede. " + arg0);
		// TODO Auto-generated constructor stub
	}

	public HotelCadastroException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HotelCadastroException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public HotelCadastroException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
