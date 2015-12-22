package br.com.gameViewLog.beanImpl;

import br.com.gameViewLog.bean.AcaoTO;

public class AcaoTOImpl extends TOImplAbstract {

	public static AcaoTO montaTO(String texto) {
		AcaoTO acaoTO = new AcaoTO();
		acaoTO.setData(montaData(texto));
		acaoTO.setHora(montaHora(texto));
		acaoTO.setTexto(montaTexto(texto));
		acaoTO.setMatou(procuraAssassino(texto));
		acaoTO.setMorreu(procuraMorto(texto));
		acaoTO.setArma(procuraArma(texto));

		return acaoTO;
	}

}
