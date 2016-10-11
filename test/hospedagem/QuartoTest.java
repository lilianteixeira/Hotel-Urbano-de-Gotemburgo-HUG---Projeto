package hospedagem;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hospedagem.Quarto;
import hospedagem.TipoDeQuarto;

public class QuartoTest {
	
	private Quarto quartoSimples, quartoLuxo, quartoPresidencial;
	@Before
	public void setup() {
		this.quartoSimples = new Quarto("1a", TipoDeQuarto.SIMPLES);
		this.quartoLuxo = new Quarto("1b", TipoDeQuarto.LUXO);
		this.quartoPresidencial = new Quarto("1c", TipoDeQuarto.PRESIDENCIAL);
	}

	@Test
	public void test() {
		/*
		 * testa valores das diarias
		 */
		assertEquals(100, quartoSimples.getDiaria(), 0.1);
		assertEquals(250, quartoLuxo.getDiaria(), 0.1);
		assertEquals(450, quartoPresidencial.getDiaria(), 0.1);
		
		/*
		 * Testa se quartos sao iquais (a condicao eh o ID)
		 */
		assertTrue(quartoSimples.equals(new Quarto("1a", TipoDeQuarto.LUXO)));
		assertFalse(quartoLuxo.equals(new Quarto("1a", TipoDeQuarto.LUXO)));
		
		/*
		 * Testa se o quarto está ocupado
		 */
		
		quartoPresidencial.setOcupadoState();
		assertTrue(quartoPresidencial.isOcupado());
		quartoPresidencial.setOcupadoState();
		assertFalse(quartoPresidencial.isOcupado());
	}
		
	

}
