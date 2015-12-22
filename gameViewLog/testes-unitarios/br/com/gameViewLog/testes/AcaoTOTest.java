package br.com.gameViewLog.testes;

import org.junit.Test;

public class AcaoTOTest extends abstractTOTest {

	@Test
	public void testGetMatou() {
		assertEquals(getPartida().getAcoes().get(ZERO).getMatou(), "Thiago");
	}

	@Test
	public void testGetMorreu() {
		assertEquals(getPartida().getAcoes().get(ZERO).getMorreu(), "Roman");
	}

	@Test
	public void testGetArma() {
		assertEquals(getPartida().getAcoes().get(ZERO).getArma(), "AK");
	}

	@Test
	public void testGetData() {
		assertEquals(getPartida().getAcoes().get(ZERO).getData(), "23/04/2013");
	}

	@Test
	public void testGetHora() {
		assertEquals(getPartida().getAcoes().get(ZERO).getHora(), "15:35:04");
	}

	@Test
	public void testGetTexto() {
		assertEquals(getPartida().getAcoes().get(ZERO).getTexto(),"Thiago killed Roman using AK");
	}

}
