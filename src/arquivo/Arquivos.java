package arquivo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import hotel.Controller;

public class Arquivos  {
	/**
	 * 
	 */
	
	
	public Object getData(String caminho) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(caminho)));
		Object o = in.readObject();
		in.close();
		return o;
}
	
	
	public void saveData(Object object, String caminho) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(caminho)));
		out.writeObject(object);
		out.close();
}
	
	
	//	public void gravaSistema(Controller controller) throws Exception {
//
//		
//		try {
//			arqObjectos = new FileOutputStream(file);
//			BufferedOutputStream outStream = new BufferedOutputStream(arqObjectos);
//			ObjectOutputStream stream = new ObjectOutputStream(outStream);
//			stream.writeObject(controller);
//			stream.close();
//		
//		} finally {
//			if (arqObjectos != null)
//				arqObjectos.close();
//		}
//	}
//
//	public Controller restaurarSistema(Controller controller) throws Exception, ClassNotFoundException {
//
//		File file = new File("arquivos_sistema/hug.dat");
//		controller = null;
//		if (!file.exists()) {
//			return null;
//		}
//		try {
//
//			FileInputStream inFile = new FileInputStream(file);
//			BufferedInputStream inStream = new BufferedInputStream(inFile);
//			ObjectInputStream stream = new ObjectInputStream(inStream);
//			controller = (Controller) stream.readObject();
//			stream.close();
//
//		} catch (FileNotFoundException exp) {
//			System.out.println("FILENOT FOUND " + exp.getMessage());
//		} catch (IOException exp) {
//			System.out.println("IOEX " + exp.getMessage());
//		} catch (ClassNotFoundException exp) {
//			System.out.println("CLASS NOT FOUND " + exp.getMessage());
//		}
//		return controller;
//	}
	

}
