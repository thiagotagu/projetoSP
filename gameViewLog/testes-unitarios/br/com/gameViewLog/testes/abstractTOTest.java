package br.com.gameViewLog.testes;

import junit.framework.TestCase;
import br.com.gameViewLog.bean.PartidaTO;

public class abstractTOTest extends TestCase {

	protected static final Integer UM = 1;
	protected static final Integer ZERO = 0;
	protected static final Integer TRES = 3;

	protected PartidaTO getPartida() {

		PartidaTO partida = new PartidaTO(
				"23/04/2013 15:34:22 - New match 11348965 has started");

		partida.add("23/04/2013 15:35:04 - Thiago killed Roman using AK");
		partida.add("23/04/2013 15:35:14 - Roman killed Jose using M16");
		partida.add("23/04/2013 15:36:04 - Jose killed Roman using M16");
		partida.add("23/04/2013 15:36:14 - Roman killed Roman using M16");
		partida.add("23/04/2013 15:37:04 - Roman killed Roman using AR15");
		partida.add("23/04/2013 15:36:04 - Roman killed Nick using M16");
		partida.fimPartida("23/04/2013 15:39:22 - Match 11348965 has ended");

		return partida;
	}

	protected PartidaTO getPartidaMAtouMAis5(){
	
	PartidaTO partida = new PartidaTO("23/04/2013 15:34:22 - New match 11348965 has started");

	partida.add("23/04/2013 15:36:02 - Roman killed Nick using M16");
	partida.add("23/04/2013 15:36:03 - Roman killed Nick using M16");
	partida.add("23/04/2013 15:36:04 - Thiago killed Roman using M16");
	partida.add("23/04/2013 15:36:05 - Jose killed Nick using AK");
	partida.add("23/04/2013 15:32:06 - Roman killed Nick using AR15");
	partida.add("23/04/2013 15:36:07 - Roman killed Nick using AR15");
	partida.add("23/04/2013 15:36:08 - Roman killed Nick using AR15");
	partida.add("23/04/2013 15:36:09 - Roman killed Nick using AR15");
	partida.add("23/04/2013 15:36:10 - Roman killed Nick using AR15");
	partida.add("23/04/2013 15:36:11 - Roman killed Nick using AR15");
	partida.add("23/04/2013 15:36:12 - Roman killed Nick using AR15");
	partida.add("a23/04/2013 15:38:09 - Jose killed Roman by DROWN");
	partida.fimPartida("23/04/2013 15:39:22 - Match 11348965 has ended");
	
	
	return partida;
}
}
