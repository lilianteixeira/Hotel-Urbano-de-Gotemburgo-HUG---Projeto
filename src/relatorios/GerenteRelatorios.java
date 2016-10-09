package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Set;

import hospede.Hospede;

public class GerenteRelatorios {
	
	public GerenteRelatorios() {
	
	}
	
	public void relatorioHospedes(Set<Hospede> listaHospedes) throws Exception{
PrintWriter arquivo = null;
		
		try{
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter("resources/relatorios/cad_hospedes.txt")));
			String msgArquivo = "Cadastro de Hospedes: "+ listaHospedes.size() + " hospedes registrados\n";
			int contador = 1;
			for (Hospede hospede : listaHospedes) {
				msgArquivo += "==> Hospede " + contador + ":\nEmail: " + hospede.getEmail()
				+ "\nNome:" + hospede.getNome()
				+ "\nData de nascimento: " + hospede.getDataNascimento() + "\n\n";
				contador ++;
			}
			arquivo.print(msgArquivo);
		}finally{
			if (arquivo != null) arquivo.close();
		}
		
	}
		
}


