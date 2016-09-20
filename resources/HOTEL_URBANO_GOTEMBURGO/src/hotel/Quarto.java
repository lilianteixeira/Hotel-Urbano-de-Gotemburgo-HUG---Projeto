package hotel;

public class Quarto {
	private String id;
	private QuartoState quartoState;	
	private boolean isOcupado;
	
	public Quarto(String id) {
		//Construtor
	}
	
	public double getDiaria() {
		//Deve calcular a diária a partir do quartoState
		return this.quartoState.getDiaria();
	}
	
	public String getId() {
		return id;
	}
	//Na UML a assinatura não está recebendo um atributo
	//Vou corrigir essa parte
	public void setQuartoState(QuartoType quartoType) {
		//A ideia é que o quarto possa mudar de tipo, a partir
		//do argumento passado para o método
	}
	
	public boolean getIsOcupado() {
		return false;
	}
	
	public void setIsOcupado() {
		this.isOcupado = !this.isOcupado ; 
	}	

}
