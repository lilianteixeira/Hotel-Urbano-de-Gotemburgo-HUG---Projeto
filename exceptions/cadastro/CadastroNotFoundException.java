package cadastro;

public class CadastroNotFoundException extends CadastroSetException {

	public CadastroNotFoundException() {
		super("Cadastro não encontrado");
	}

	public CadastroNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CadastroNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CadastroNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CadastroNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
