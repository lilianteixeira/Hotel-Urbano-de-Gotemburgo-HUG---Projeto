package exceptions;

/**
 * a classe abaixo e filha da classe hospedeException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de procurar um hospede
 *
 */
public class HospedeNotFoundException extends HospedeException {
	
	public HospedeNotFoundException() {
		super();
	}

	public HospedeNotFoundException(String mensagem) {
		super("Erro na consulta de " + mensagem);
		
	}

}
