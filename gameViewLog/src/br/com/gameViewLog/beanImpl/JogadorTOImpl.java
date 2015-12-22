package br.com.gameViewLog.beanImpl;

import java.util.ArrayList;

import br.com.gameViewLog.bean.JogadorTO;

public class JogadorTOImpl extends TOImplAbstract {

	public static void montaTO(String linha,
			ArrayList<JogadorTO> lstJogadores) {

		 incrementaAssassinato(linha, lstJogadores);
		 incrementaMorte(linha, lstJogadores);
	}

	private static Boolean incrementaMorte(String linha,
			ArrayList<JogadorTO> lstJogadores) {

		String nomeJogador = procuraMorto(linha);

		if (!nomeJogador.isEmpty() && lstJogadores.size() > 0) {
			for (JogadorTO jogadorTO : lstJogadores) {

				if (jogadorTO.getNome().equals(nomeJogador)) {
					jogadorTO.setSomaMorte();
					jogadorTO.setSequencia("morreu;"+montaData(linha)+" "+montaHora(linha));
					 
					return true;
				}
			}
		}
		
		if (!nomeJogador.isEmpty()){
			criaJogadorMorto(linha,lstJogadores);
		}
		
		return false;
	}

	private static Boolean incrementaAssassinato(String linha,
			ArrayList<JogadorTO> lstJogadores) {
		String nomeJogador = procuraAssassino(linha);

		if (!nomeJogador.isEmpty() && lstJogadores.size() > 0) {
			for (JogadorTO jogadorTO : lstJogadores) {

				if (jogadorTO.getNome().equals(nomeJogador)) {
					jogadorTO.setSomaAssassinato();
					jogadorTO.setArma(procuraArma(linha));
					jogadorTO.setSequencia("matou;"+montaData(linha)+" "+montaHora(linha));
					
					return true;
				}
			}
		}
		if (!nomeJogador.isEmpty()){
			criaJogadorAssassino(linha,lstJogadores);
		}
		return false;
	}

	private static void criaJogadorAssassino(String linha, ArrayList<JogadorTO> lstJogadores ) {
		JogadorTO jogadorTO = new JogadorTO();

		jogadorTO.setNome(procuraAssassino(linha));
		jogadorTO.setSomaAssassinato();
		jogadorTO.setArma(procuraArma(linha));
		jogadorTO.setSequencia("matou;"+montaData(linha)+" "+montaHora(linha));
		lstJogadores.add(jogadorTO);
	}
	private static void criaJogadorMorto(String linha, ArrayList<JogadorTO> lstJogadores ) {
		JogadorTO jogadorTO = new JogadorTO();

		jogadorTO.setNome(procuraMorto(linha));
		jogadorTO.setSomaMorte();
		jogadorTO.setArma(procuraArma(linha));
		jogadorTO.setSequencia("morreu;"+montaData(linha)+" "+montaHora(linha));
		lstJogadores.add(jogadorTO);
	}	
	 
}
