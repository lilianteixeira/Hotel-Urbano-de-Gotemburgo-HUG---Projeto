package exceptions;

/**
 * a classe abaixo e filha da classe hospedagemException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de fazer checkin 
 *
 */
public class CheckinException extends HospedagemException {
	
	public CheckinException() {
		super();
	}

	public CheckinException(String mensagem){
		super("Erro ao realizar checkin. " + mensagem);
	}


	
	
}
