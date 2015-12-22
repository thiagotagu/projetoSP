package br.com.gameViewLog.testes;

import org.junit.Test;

public class JogadorTOTest extends abstractTOTest {

	@Test
	public void testGetNome() {
		
		assertEquals(getPartida().getJogadores().get(0).getNome(), "Thiago");
	}

	@Test
	public void testGetQtdAssassinato() {
		assertEquals(getPartida().getJogadores().get(0).getQtdAssassinato(), UM);
	}

	@Test
	public void testGetQtdMorte() {
		assertEquals(getPartida().getJogadores().get(0).getQtdMorte(), ZERO);
	}

	@Test
	public void testGetArmaPreferida() {
		assertEquals(getPartida().getJogadores().get(0).getArmaPreferida(), "AK");
	}

	@Test
	public void testGetSaldo() {
		assertEquals(getPartida().getJogadores().get(0).getSaldo(), UM);
	}
	
	@Test
	public void testGetMaiorSequencia() {
		assertEquals(getPartida().getJogadores().get(0).getMaiorSequencia(), UM);
	}
	
	@Test
	public void testisMatou5Em1min() {
		
		assertEquals(getPartidaMAtouMAis5().getJogadores().get(0).isMatou5Em1min(), true);
	}	
	

	
	

}
