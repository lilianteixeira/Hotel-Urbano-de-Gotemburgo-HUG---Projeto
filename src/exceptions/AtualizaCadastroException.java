package exceptions;

public class AtualizaCadastroException extends Exception {

	public AtualizaCadastroException() {
		//ver qual a mensagem que vai aqui
	}

	public AtualizaCadastroException(String mensagem) {
		super("Erro na atualizacao do cadastro de Hospede. " + mensagem);

	}

	//desnecessarios
	public AtualizaCadastroException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AtualizaCadastroException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AtualizaCadastroException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}