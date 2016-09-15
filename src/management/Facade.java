package management;

import easyaccept.EasyAccept;

public class Facade {
	
	Controller controller;
	
	public Facade(){
		
	}
	
	public void cadastraHospede(String nome, String email, String dataNascimento) throws Exception{
		controller.cadastraHospede(nome, email, dataNascimento);
	}
	
	
	public static void main(String[] args) {
	    args = new String[] {"management.Facade", "resources/acceptance_test/testes_uc1.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}
}
