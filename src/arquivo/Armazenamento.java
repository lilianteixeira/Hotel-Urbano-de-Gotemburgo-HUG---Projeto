package arquivo;

import hotel.Controller;

import java.io.*;


public class Armazenamento {
	private static final String CAMINHO = "arquivos_sistema/hug.dat";
	
	

	public void salvarDados(Controller controller) throws FileNotFoundException, IOException{


		ObjectOutputStream arqObjectos = null;
		try{
			arqObjectos = new ObjectOutputStream(new FileOutputStream(CAMINHO));
			arqObjectos.writeObject(controller);
		}finally{
			if(arqObjectos != null)
				arqObjectos.close();
		}
	}
//	public int salvarDados(Controller controller) {
//		try {
//			FileOutputStream fs = new FileOutputStream(CAMINHO);
//			ObjectOutputStream os = new ObjectOutputStream(fs);
//			os.writeObject(controller);
//			os.close();
//			return 0;
//		} catch (Exception ex) {
//			return -1;
//
//		}
//	}

	public Object carregarDados() {

		Object resultado = null;

		try {
			// tem que ser o mesmo nome do arquivo de salvamento
			FileInputStream fs = new FileInputStream(CAMINHO);
			ObjectInputStream os = new ObjectInputStream(fs);
			resultado = os.readObject();			
			return resultado;

		} catch (Exception ex) {
			return null;
		}

	}
}
