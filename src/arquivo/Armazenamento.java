package arquivo;

import hotel.Controller;

import java.io.*;
/**
 *
 * Classe Armazenamento, a classe e responsavel por armazenar os dados em um arquivo
 *
 */
public class Armazenamento {
	/**
	 * String statica que indica o caminho onde esta o arquivo
	 */
	private static final String CAMINHO = "arquivos_sistema/hug.dat";
		
/**
 * o metodo abaixo salva os dados
 * @param controller
 * @throws FileNotFoundException
 * @throws IOException
 */
	public void salvarDados(Controller controller) throws FileNotFoundException, IOException{
		
		File arquivo = new File(CAMINHO);

		if (arquivo.exists()) {
			arquivo.delete();
		}
		ObjectOutputStream arqObjectos = null;
		try{
			arqObjectos = new ObjectOutputStream(new FileOutputStream(CAMINHO));
			arqObjectos.writeObject(controller);
		}finally{
			if(arqObjectos != null)
				arqObjectos.close();
		}
	}


	/**
	 * o metodo carrega os dados que estao no arquivo
	 * @return um objeto 
	 */
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
