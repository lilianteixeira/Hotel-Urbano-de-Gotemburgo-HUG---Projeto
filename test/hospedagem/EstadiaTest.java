package hospedagem;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hospede.Hospede;

public class EstadiaTest {
	private Estadia estadia;
	private Quarto quarto = new Quarto("1b", TipoDeQuarto.SIMPLES);
	private Hospede hospede = new Hospede("michele", ",michele@michele.com", "03/01/1915");
	private int dias = 5;
	@Before
	
	public void setup(){
		this.estadia = new Estadia(quarto, dias, hospede);
	}
	
	@Test
	public void testGetId() {
		assertEquals("1b", estadia.getId());
	}
	@Test
	public void testGetPrecoTotal() {
		assertEquals(quarto.getDiaria()*dias, estadia.getPrecoTotal(), 0.1);
	}
	@Test
	public void getHospedeTest(){
		assertEquals(hospede, estadia.getHospede());
	}	
}
