package br.com.gameViewLog.testes;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import br.com.gameViewLog.bean.JogadorTO;

public class PartidaTOTest extends abstractTOTest {

	@Test
	public void testGetPartida() {
		Integer partida = 11348965;
		assertEquals(getPartida().getPartida(), partida);
	}

	@Test
	public void testGetDataInicio() {
		String data = "23/04/2013";
		assertEquals(getPartida().getDataInicio(), data);
	}

	@Test
	public void testGetHoraInicio() {
		String hora = "15:34:22";
		assertEquals(getPartida().getHoraInicio(), hora);
	}
	
	@Test
	public void testGetDataFim() {
		String data = "23/04/2013";
		assertEquals(getPartida().getDataInicio(), data);
	}

	@Test
	public void testGetHoraFim() {
		String hora = "15:39:22"; 
		assertEquals(getPartida().getHoraFim(), hora);
	}
	
	 
	@Test
	public void testGetJogadorMaisMatou() {
		assertEquals(getPartida().getJogadorMaisMatou(), "Roman");
	}

	@Test
	public void testGetArmaMaisMatou() {
		
		HashMap<String, Integer> matador = getPartida().getArmaMaisMatou();
		
		assertEquals(matador.toString(), "{M16=4, AR15=1, AK=1}");
	}

	@Test
	public void testGetJogadoresInvictos() {
		
		ArrayList<JogadorTO> lstJogadoresInvictos = new ArrayList<JogadorTO>();
		lstJogadoresInvictos = getPartida().getJogadoresInvictos();
		 assertEquals(lstJogadoresInvictos.get(ZERO).getNome(), "Thiago");
	}
	@Test
	public void testGetAcoes() {
		assertNotNull(getPartida());
	}

	@Test
	public void testGetJogadores() {
		assertNotNull(getPartida());
	}

}
