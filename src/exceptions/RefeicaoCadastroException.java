package exceptions;

public class RefeicaoCadastroException extends RestauranteException {

	public RefeicaoCadastroException() {
		// TODO Auto-generated constructor stub
	}

	public RefeicaoCadastroException(String arg0) {
		super("Erro no cadastro de refeicao" + arg0);
		// TODO Auto-generated constructor stub
	}

	public RefeicaoCadastroException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public RefeicaoCadastroException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public RefeicaoCadastroException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}