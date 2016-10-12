package hospedagem;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import exceptions.CheckinException;
import exceptions.EstadiaIvalidaException;
import exceptions.HospedeNotFoundException;
import factorys.QuartoFactory;
import hospede.Hospede;



public class BancoDeHospedagem {
	
	
	private Set<Quarto> quartos;
	private Map<Estadia, Hospede> estadias;
	private QuartoFactory quartoFactory;
	
	public BancoDeHospedagem() {
		this.quartos = new HashSet<>();
		this.estadias = new LinkedHashMap<Estadia, Hospede>();
		this.quartoFactory = new QuartoFactory();
	}
	
	public void checkIn(Hospede hospede, int dias, String idQuarto, String tipoDeQuarto) throws Exception {
		if (buscaQuarto(idQuarto) == null) {
			quartos.add(quartoFactory.criaQuarto(idQuarto, tipoDeQuarto));
		}
		Quarto QuartoBuscado = buscaQuarto(idQuarto);
		if (QuartoBuscado.isOcupado()) {
			throw new CheckinException("Quarto " + idQuarto + " ja esta ocupado.");
		}
		Quarto quarto = buscaQuarto(idQuarto);
		Estadia estadia = new Estadia(quarto, dias, hospede);
		estadias.put(estadia, hospede);
		quarto.setOcupadoState(); // Muda o estado do quarto pra ocupado
	}

	public String checkout(Hospede hospede, String idQuarto) throws Exception {
		
		Estadia estadia = buscaEstadiaPorQuarto(idQuarto);
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.UP);
		double valorComDesconto = estadia.getPrecoTotal()
				- hospede.getCartaoFidelidade().getTipoDeCartao().calculaDesconto(estadia.getPrecoTotal());

		
		buscaQuarto(idQuarto).setOcupadoState();
		removeEstadia(estadia);
		hospede.getCartaoFidelidade().adicionaPontos(estadia.getPrecoTotal());
		return "R$" + df.format(valorComDesconto).replace(".", ",");
	}
	
	public String getInfoHospedagem(Hospede hospede, String atributo) throws Exception {
		
		String retorno = "";

		if (!temEstadiasAtivas(hospede)) {
			throw new HospedeNotFoundException("hospedagem. Hospede " + hospede.getNome()
					+ " nao esta hospedado(a).");
		}

		LinkedHashSet<Estadia> hospedagensAtivas = getHospedagensAtivas(hospede);
		Iterator<Estadia> it = hospedagensAtivas.iterator();

		if (atributo.equalsIgnoreCase("Hospedagens ativas")) {
			retorno += getHospedagensAtivas(hospede).size();
		}

		else if (atributo.equalsIgnoreCase("Quarto")) {
			while (it.hasNext()) {
				retorno += it.next().getId() + ",";
			}
			retorno = retorno.substring(0, retorno.length() - 1);
		}

		else if (atributo.equalsIgnoreCase("Total")) {
			double total = 0;
			while (it.hasNext()) {
				total += it.next().getPrecoTotal();
			}
			retorno += "R$" + String.format("%.2f", total);
		}
		return retorno;
	}

	private Quarto buscaQuarto(String idQuarto) {
		for (Quarto quarto : quartos) {
			if (quarto.getId().equals(idQuarto)) {
				return quarto;
			}
		}
		return null;
	}

	

	private boolean temEstadiasAtivas(Hospede hospede) {
		if (estadias.containsValue(hospede))
			return true;
		return false;
	}

	private LinkedHashSet<Estadia> getHospedagensAtivas(Hospede hospedeProcurado) {
		LinkedHashSet<Estadia> estadiasAtivas = new LinkedHashSet<>();
		for (Estadia estadia : estadias.keySet()) {
			if (estadias.get(estadia).equals(hospedeProcurado)) {
				estadiasAtivas.add(estadia);
			}
		}
		return estadiasAtivas;
	}

	public Estadia buscaEstadiaPorQuarto(String quarto) throws Exception {
		for (Estadia estadia : estadias.keySet()) {
			if (estadia.getId().equals(quarto)) {
				return estadia;
			}
		}
		throw new EstadiaIvalidaException();
	}

	private void removeEstadia(Estadia estadia) {
		estadias.remove(estadia);

	}



}
