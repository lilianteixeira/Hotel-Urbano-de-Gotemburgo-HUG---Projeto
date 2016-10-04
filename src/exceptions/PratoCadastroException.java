package exceptions;

public class PratoCadastroException extends RestauranteException {

	public PratoCadastroException() {
		// ver a mensagem que vai aqui
	}

	public PratoCadastroException(String mensagem) {
		super("Erro no cadastro do prato. " + mensagem);
	}

	//desnecessarios
	public PratoCadastroException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PratoCadastroException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PratoCadastroException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}