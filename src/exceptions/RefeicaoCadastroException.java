package exceptions;

public class RefeicaoCadastroException extends Exception {

	public RefeicaoCadastroException() {
		
	}

	public RefeicaoCadastroException(String mensagem) {
		super("Erro no cadastro de refeicao" + mensagem);
	}

}