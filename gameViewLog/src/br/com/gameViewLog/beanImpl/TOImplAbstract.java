package br.com.gameViewLog.beanImpl;

import br.com.gameViewLog.utilitario.UtilitariosLogView;

@SuppressWarnings("unused")
public class TOImplAbstract {
	
	protected static String montaTexto(final String textoCompleto) {
		String texto  =  textoCompleto.substring(21,textoCompleto.length()).trim();
		
		if (texto.isEmpty()) {
			return null;
		}
		return texto;
	}
 
	public static String montaHora(final String texto) {
		String horaString =  texto.substring(11,19);
		
		if (horaString.isEmpty()){			
			return null;
		}
		
		if (!UtilitariosLogView.validaHora(horaString)) {
			return null;
		}
		
		return horaString;
	}

	public static  String montaData(final String texto)   {
		String dataString =  texto.substring(0,10);	
		
		if (dataString.isEmpty()){			
			return null;
		}
		
		if (!UtilitariosLogView.validaData(dataString)){
			return null;
		}
		return dataString;
	}
	
	protected static String procuraArma(String texto) {
		// TODO Auto-generated method stub
		return UtilitariosLogView.procuraAtributo("using", texto);
	}
	
	protected static String removeCaracterSujo(String palavra){
		
		return palavra.replaceAll("[^a-zA-Z0-9 ]", "");
	}

	protected static String procuraAssassino(String texto) {
		
		String matou = UtilitariosLogView.procuraAtributo("killed", texto,false);
		return removeCaracterSujo(matou);
	}

	protected static String procuraMorto(String texto) {
		
		return UtilitariosLogView.procuraAtributo("killed", texto);
	}


}
