package br.com.gameViewLog.carregamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import br.com.gameViewLog.bean.PartidaTO;
import br.com.gameViewLog.utilitario.CarregaPropertie;
import br.com.gameViewLog.utilitario.UtilitariosLogView;

public class ObterLog {

	// private static Logger log = Logger.getLogger(ObterLog.class);

	public static ArrayList<PartidaTO> obterListaLog() {

		ArrayList<PartidaTO> lstPartidas = new ArrayList<PartidaTO>();
		
		try {

			CarregaPropertie prop = new CarregaPropertie();
			String caminholog = prop.getCaminhoArquivo(); 

			FileReader arq = new FileReader(caminholog);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();			
			Integer idPArtida=null;
			Integer linhaIdPartida=null;			
			Boolean novaPartida=true;
			
			while (linha != null) {
				
				linhaIdPartida = obterPartida(linha);
				if (linhaIdPartida >-1){
					idPArtida = linhaIdPartida;
				}
				novaPartida = isNovaPArtida(linha);			
				
				if (idPArtida != null  ){
					if (lstPartidas.size() >0) {						
						for (PartidaTO partidaTO : lstPartidas) {							
							if( partidaTO.getPartida().equals(idPArtida)) {
								if (isFimPartida(linha)){
									partidaTO.fimPartida(linha);
									break;
								}
								
								novaPartida = false;								
								partidaTO.add(linha);
							}
						}
					}					
					
					if (idPArtida != null && idPArtida>-1 && novaPartida)
					{
						PartidaTO partida = new PartidaTO(linha);
						lstPartidas.add(partida);
					}
					
				}
				
				linha = lerArq.readLine();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lstPartidas;
	}
	
	private static boolean isFimPartida(String linha) {
		// TODO Auto-generated method stub
		return (UtilitariosLogView.validaPalavras("match", linha) && UtilitariosLogView.validaPalavras("ended", linha));
	}

	private static boolean isNovaPArtida(String linha){
		
		return (UtilitariosLogView.validaPalavras("match", linha) && UtilitariosLogView.validaPalavras("started", linha));
		
		
	}

	private static Integer obterPartida(String linha) {
		try {	
			return 	 Integer.valueOf(UtilitariosLogView.procuraAtributo("match", linha));
		} catch (Exception e) {
			return -1;
		}			
	}

	
}
