package exceptions;

/**
 * a classe abaixo e filha da classe restauranteException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora que for usar algo relacionado a refeicao da classe restaurante
 *
 */
public class RefeicaoCadastroException extends RestauranteException {

	public RefeicaoCadastroException() {
		super();
		
	}

	public RefeicaoCadastroException(String mensagem) {
		super("Erro no cadastro de refeicao" + mensagem);
	}

}