package hotel;

import java.util.HashSet;
import java.util.Set;

public enum Restaurante {
	RESTAURANTE;
	
	private Set<Refeicao> refeicaoSet;
	private RefeicaoFactory refeicaoFactory;
	
	private Restaurante() {
		refeicaoSet = new HashSet<>();
		
	}
	//Diferente da uml
	public boolean addRefeicao(RefeicaoFactory rf) {
		return false;
	}
	
	public boolean removeRefeicao(Refeicao refeicao) {
		//Talvez a busca seja pelo nome?
		return false;
	}
	
	public Refeicao buscaRefeicao(String nome) {
		return null;
	}

}
