package br.com.gameViewLog.beanImpl;

import br.com.gameViewLog.bean.PartidaTO;
import br.com.gameViewLog.utilitario.UtilitariosLogView;

public class PartidaTOImpl extends TOImplAbstract {

	// private Logger log = Logger.getLogger(LogTOImpl.class);

	public static PartidaTO montaTO(final String texto) {

		PartidaTO partidaTO = new PartidaTO();
		Integer partida = obterPartida(texto);
		if (partida != null) {
			partidaTO.setDataInicio(montaData(texto));
			partidaTO.setHoraInicio(montaHora(texto));
			partidaTO.setPartida(partida);
		}
		return partidaTO;
	}

	private static Integer obterPartida(String texto) {

		Integer valorPartida = null;

		try {
			valorPartida = Integer.valueOf(UtilitariosLogView.procuraAtributo(
					"match", texto));
		} catch (Exception e) {
			// Log.error("Erroa ao converter uma partida",e.getMessage())
		}

		return valorPartida;

	}

}
