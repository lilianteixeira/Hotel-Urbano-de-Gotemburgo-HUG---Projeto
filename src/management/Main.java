package management;

import easyaccept.EasyAccept;

public class Main {
	public static void main(String[] args) {
	    args = new String[] {"management.Facade", "acceptance_test/testes_uc1.txt"}; //separe cada script de teste por virgula.
	    EasyAccept.main(args);
	}

}
