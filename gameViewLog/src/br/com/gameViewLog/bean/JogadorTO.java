package br.com.gameViewLog.bean;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.gameViewLog.utilitario.UtilitariosLogView;

public class JogadorTO {

	private String nome;
	private Integer qtdAssassinato = 0;
	private Integer qtdMorte = 0;
	private String armaPreferida;
	
	private ArrayList<String> lstSequencia = new ArrayList<String>();

	ArrayList<String> lstArma = new ArrayList<String>();
	HashMap<String, Integer> aramMaisMatou;

	public JogadorTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdAssassinato() {
		return qtdAssassinato;
	}

	public void setSomaAssassinato() {
		this.qtdAssassinato++;
	}

	public Integer getQtdMorte() {
		return qtdMorte;
	}

	public void setQtdMorte(int qtdMorte) {
		this.qtdMorte = qtdMorte;
	}

	public String getArmaPreferida() {

		HashMap<String, Integer> hsArmas = UtilitariosLogView
				.getTopLista(lstArma);
		if (hsArmas.isEmpty()) {
			return "";
		}

		this.armaPreferida = hsArmas.entrySet().iterator().next().getKey();
		return armaPreferida;
	}

	public void setArma(String arma) {
		if (!arma.isEmpty()) {
			this.lstArma.add(arma);
		}
	}

	public void setSomaMorte() {
		this.qtdMorte++;
	}

	public Integer getSaldo() {
		return getQtdAssassinato() - getQtdMorte() ;
	}

	/**
	 * @return the sequencia
	 */
	

	public Integer getMaiorSequencia() {
		
		ArrayList<String> lst = this.lstSequencia;
		String[] split;
		Integer sqAssassinato=0;
		Integer sqTemp=0;
		for (int i = 0; i < lst.size(); i++) {
			split =  lst.get(i).split(";");
			if (split[0].equals("matou")){
				sqTemp++;
			}
			if (split[0].equals("morreu")){
				if (sqTemp >  sqAssassinato) {
					sqAssassinato = sqTemp;
				}
				sqTemp=0;
			}
		}
		if (sqTemp >  sqAssassinato) {
			sqAssassinato = sqTemp;
		}
		
		return sqAssassinato;
	}
		
public boolean isMatou5Em1min() {
		
		ArrayList<String> lst = this.lstSequencia;
		ArrayList<String> lstTempo = new ArrayList<String>();
		String[] split;
		Integer sqAssassinato=0;
		
		for (int i = 0; i < lst.size(); i++) {
			split =  lst.get(i).split(";");
			if (split[0].equals("matou")){
				sqAssassinato++; 
				lstTempo.add(split[1]);
			}
			if (split[0].equals("morreu")){
				
				if (sqAssassinato>=5){
					if (calculaListaAssassinato1Minuto(lstTempo)){
						return true;
					}
					sqAssassinato = 0;
					lstTempo.clear();
				}
				
				sqAssassinato = 0;
				lstTempo.clear();
			}
		}
		return false;
	}	
	

	private boolean calculaListaAssassinato1Minuto(ArrayList<String> lstTempo) {
				
		
		while (lstTempo.size()>=5) {
			if (UtilitariosLogView.diferencaMenor1Minuto(lstTempo.get(0),lstTempo.get(4))){
				return true;
			}
			lstTempo.remove(0);
		}
	return false;
}

	/**
	 * @param sequencia the sequencia to set
	 */
	public void setSequencia(String sequencia) {
		this.lstSequencia.add(sequencia);
	}

}
