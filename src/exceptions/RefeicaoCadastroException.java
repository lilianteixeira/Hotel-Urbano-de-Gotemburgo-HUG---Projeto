package exceptions;

public class RefeicaoCadastroException extends RestauranteException {

	public RefeicaoCadastroException() {
		
	}

	public RefeicaoCadastroException(String mensagem) {
		super("Erro no cadastro de refeicao" + mensagem);
	}

}