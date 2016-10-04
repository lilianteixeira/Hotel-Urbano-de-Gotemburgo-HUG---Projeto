package exceptions;

public class RestauranteException extends Exception {

	public RestauranteException() {
		//ver a mensagem que vai aqui
	}

	public RestauranteException(String mensagem) {
		super(mensagem);
	}

	//desnecessarios
	public RestauranteException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public RestauranteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public RestauranteException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}