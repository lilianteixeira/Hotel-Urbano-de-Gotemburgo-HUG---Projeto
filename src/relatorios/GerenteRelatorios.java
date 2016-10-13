package relatorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import hospede.Hospede;
import registros.RegistroOperacoes;
import restaurante.Refeicao;

public class GerenteRelatorios  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8236918611310575423L;
	private static final String CAMINHO = "arquivos_sistema/relatorios/";

	public GerenteRelatorios() {

	}

	public void relatorioHospedes(Set<Hospede> listaHospedes) throws Exception {
		PrintWriter arquivo = null;

		try {
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter(CAMINHO + "cad_hospedes.txt")));
			String msgArquivo = "Cadastro de Hospedes: " + listaHospedes.size() + " hospedes registrados\n";
			int contador = 1;
			for (Hospede hospede : listaHospedes) {
				LocalDate dataFormatada = formataData(hospede.getDataNascimento());
				msgArquivo += "==> Hospede " + contador + ":\nEmail: " + hospede.getEmail() + "\nNome: "
						+ hospede.getNome() + "\nData de nascimento: " + dataFormatada + "\n\n";
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
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter(CAMINHO + "cad_restaurante.txt")));
			String msgArquivo = "Menu do Restaurante: " + menu.size() + "  itens no cardapio\n";
			int contador = 1;
			for (Refeicao refeicao : menu) {
				msgArquivo += "==> Item " + contador + ":\nNome: " + refeicao.getNome() + " Preco: R$"
						+ String.format("%.2f", refeicao.getValor()) + "\nDescricao: " + refeicao.getDescricao()
						+ "\n\n";
				contador++;
			}
			msgArquivo = msgArquivo.replace(" Serao servidos: ", "\nPratos: ");
			arquivo.print(msgArquivo);
		} finally {
			if (arquivo != null)
				arquivo.close();
		}

	}

	public void relatorioRegistros(List<RegistroOperacoes> registrosOperacoes) throws Exception {
		PrintWriter arquivo = null;

		try {
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter(CAMINHO + "cad_transacoes.txt")));
			String msgArquivo = "Historico de Transacoes:\n";
			double total = 0;
			for (RegistroOperacoes registro : registrosOperacoes) {
				msgArquivo += "==> Nome: " + registro.getNome() + " Gasto: R$"
						+ String.format("%.2f", registro.getTotalPago()) + " Detalhes: " + registro.getId() + "\n";
				total += registro.getTotalPago();
			}

			msgArquivo += "\n===== Resumo de transacoes =====" + "\nLucro total:R$" + String.format("%.2f", total)
					+ "\nTotal de transacoes:" + registrosOperacoes.size() + "\nLucro medio por transacao: R$"
					+ String.format("%.2f", (total / registrosOperacoes.size()));

			arquivo.print(msgArquivo);
		} finally {
			if (arquivo != null)
				arquivo.close();
		}

	}

	public void relatorioHotel() throws Exception {

		PrintWriter arquivo = null;
		String dir = CAMINHO ;
		String msgArquivo = "";
		File file = new File(dir);
		String[] listaArquivos = file.list();
		Arrays.sort(listaArquivos);
		try {
			arquivo = new PrintWriter(new BufferedWriter(new FileWriter(CAMINHO + "hotel_principal.txt")));
			for (String arq : listaArquivos) {
				if (arq.endsWith(".txt") && !arq.startsWith("hotel")) {
					msgArquivo += "======================================================\n"
							+ (leitura(dir + "/" + arq)) + "\n";
				}
			}
			arquivo.print(msgArquivo);
		} finally {
			if (arquivo != null)
				arquivo.close();

		}

	}

	private String leitura(String dir) throws Exception {
		String linha = "", conteudo = "";
		BufferedReader br = new BufferedReader(new FileReader(new File(dir)));
		while ((linha = br.readLine()) != null) {
			if (!linha.isEmpty()) {
				conteudo = new StringBuilder(conteudo).append(linha.concat("\n")).toString();
			}
		}
		br.close();
		return conteudo;
	}

	private LocalDate formataData(String dataRecebida) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataRecebida, formato);
		return (data);
	}

}
