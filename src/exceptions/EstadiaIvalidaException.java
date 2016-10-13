package exceptions;

/**
 * a classe abaixo e filha da classe hospedagemException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro ao verificar uma estadia
 *
 */
public class EstadiaIvalidaException extends HospedagemException{
	
	public EstadiaIvalidaException(String messagem) {
		super(messagem);
		
	}

	public EstadiaIvalidaException() {
		super();
	}

}