package exceptions;

public class RefeicaoCadastroException extends RestauranteException {

	public RefeicaoCadastroException() {
		// ver a mensagem que vai aqui
	}

	public RefeicaoCadastroException(String mensagem) {
		super("Erro no cadastro de refeicao" + mensagem);
	}

	//desnecessarios
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