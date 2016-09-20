package hotel;

public class Estadia {
	Quarto quarto;
	int dias;
	//Na uml, os atributos do construtor está errado
	//Talvez no controller, ao invés de Quarto, seja necessário passar uma String representando uma Id
	//E a partir da ID, procurar o Quarto
	//Fica a dicussão pra quinta sobre isso
	public Estadia(Quarto quarto, int dias) {
		
	}
	
	public String getId() {
		return this.quarto.getId();
	}
	
	public double getPrecoTotal() {
		return 0;
	}
	
	

}
