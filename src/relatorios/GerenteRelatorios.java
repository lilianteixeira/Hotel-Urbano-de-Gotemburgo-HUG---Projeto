package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import hospedagem.RegistroOperacoes;
import hospede.Hospede;
import restaurante.Refeicao;

public class GerenteRelatorios {

	public GerenteRelatorios() {

	}

	public void relatorioHospedes(Set<Hospede> listaHospedes) throws Exception {
		PrintWriter arquivo = null;

		try {
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter("resources/relatorios/cad_hospedes.txt")));
			String msgArquivo = "Cadastro de Hospedes: " + listaHospedes.size() + " hospedes registrados\n";
			int contador = 1;
			for (Hospede hospede : listaHospedes) {
				msgArquivo += "==> Hospede " + contador + ":\nEmail: " + hospede.getEmail() + "\nNome:"
						+ hospede.getNome() + "\nData de nascimento: " + hospede.getDataNascimento() + "\n\n";
				contador++;
			}
			arquivo.print(msgArquivo);
		} finally {
			if (arquivo != null)
				arquivo.close();
		}

	}
	
	public void relatorioRestaurante(List<Refeicao> menu) throws Exception {
		PrintWriter arquivo = null;

		try {
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter("resources/relatorios/cad_restaurante.txt")));
			String msgArquivo = "Menu do Restaurante: " + menu.size() + "  itens no cardapio\n";
			int contador = 1;
			for (Refeicao refeicao : menu) {
				msgArquivo += "==> Item " + contador + ":\nNome: " + refeicao.getNome() + " Preco R$:"
						+ refeicao.getValor() + "\nDescricao: " + refeicao.getDescricao() + "\n\n";
				contador++;
			}
			arquivo.print(msgArquivo);
		} finally {
			if (arquivo != null)
				arquivo.close();
		}

	}
	
	public void relatorioRegistros(List<RegistroOperacoes> registrosOperacoes) throws Exception {
		PrintWriter arquivo = null;

		try {
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter("resources/relatorios/cad_transacoes.txt")));
			String msgArquivo = "Historico de Transacoes:\n";
			double total = 0;
			for (RegistroOperacoes registro: registrosOperacoes) {
				msgArquivo += "==> Nome " + registro.getNome() + " Gasto R$:"
						+ registro.getTotalPago() + " Detalhes: " + registro.getId() + "\n";
				total += registro.getTotalPago();
			}
			
			msgArquivo +="\n===== Resumo de transacoes ====="
						+ "\nLucro total:R$" + total
						+ "\nTotal de transacoes:" + registrosOperacoes.size() 	
						+ "\nLucro medio por transacao: R$" + (total/registrosOperacoes.size());
			
			arquivo.print(msgArquivo);
		} finally {
			if (arquivo != null)
				arquivo.close();
		}

	}

	

}
