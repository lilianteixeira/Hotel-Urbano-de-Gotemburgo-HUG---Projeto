package hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum Hotel {
	//Instancia única do Hotel
	HOTEL;
	
	private Set<Hospede> hospedesSet;
	//Na uml está escrito mapEstadias
	//mas irei seguir o padrão de indicar o tipo 
	//de coleção, após o tipo que ela guarda
	//pra evitar ambiguidade com os setters
	private Map<Estadia, Hospede> estadiaMap;
	//Talvez mude o nome pra HospedeFactory
	private HospedeCreator hospedeCreator;
	//Na uml está escrito "quartos"
	//Vou seguir o padrão de indicar a variável da coleção
	//no singular
	private Set<Quarto> quartoSet;
	private List<RegistroCheckOut> registroList;
	private Restaurante restaurante;
	
	private Hotel() {
		this.hospedesSet = new HashSet<>();
		this.estadiaMap = new HashMap<>();
		this.hospedeCreator = HospedeCreator.HOSPEDE_CREATOR;
		this.quartoSet = new HashSet<>();
		this.registroList = new ArrayList<>();
		this.restaurante = Restaurante.RESTAURANTE;
	}
	
	public boolean cadastraHospede(String nome, String email, int anoDeNascimento) {
		return true;
	}
	
	public Hospede buscaHospede(String email) {
		return null;
	}
	
	public void atualizaHospede(Hospede h, String nome, String email, int anoDeNascimento) {
		//Talvez, no controller/facade, seja preciso que esse método receba o email, e partir do email
		//retorne o Hospede que será atualizado
	}
	
	public boolean removeHospede(String email) {
		return false;
	}
	
	public void checkIn(Hospede h, Quarto quarto, int dias) {
		
	}
	
	public void checkOut(Hospede h) {
		
	}
	
	public void vendeRefeicao(String nomeRefeicao, Hospede hospede) {
		//Está diferente da uml
		//Existe a dúvida de onde vai ser armazenado o lucro do restaurante
		//Não está especificado no documento
		//Num futuro cartão fidelidade?
		//
		//Também fica a dúvida se a pesquisa é pelo atributo(email, nome)
		//ou se ao invés de pesquisar, passa direto o objeto
	}

}
