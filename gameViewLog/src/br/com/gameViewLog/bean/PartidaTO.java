package br.com.gameViewLog.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import br.com.gameViewLog.beanImpl.JogadorTOImpl;
import br.com.gameViewLog.beanImpl.PartidaTOImpl;
import br.com.gameViewLog.utilitario.UtilitariosLogView;

public class PartidaTO {

	private Integer partida;
	private String dataInicio;
	private String horaInicio;
	private String dataFim;
	private String horaFim;
	private ArrayList<AcaoTO> lstAcao = new ArrayList<AcaoTO>();
	private ArrayList<JogadorTO> lstJogadores = new ArrayList<JogadorTO>();

	public PartidaTO() {
		super();
	}

	public PartidaTO(String texto) {

		PartidaTO partidaTo = PartidaTOImpl.montaTO(texto);

		this.partida = partidaTo.getPartida();
		this.dataInicio = partidaTo.getDataInicio();
		this.horaInicio = partidaTo.getHoraInicio();

	}

	public Integer getPartida() {
		return partida;
	}

	public void setPartida(Integer partida) {
		this.partida = partida;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public ArrayList<AcaoTO> getAcoes() {
		return lstAcao;
	}

	private void setAcao(String linha) {
		AcaoTO acao = new AcaoTO(linha);
		if (acao.getTexto() != null && !acao.getTexto().isEmpty()) {
			this.lstAcao.add(new AcaoTO(linha));
		}
	}

	public ArrayList<JogadorTO> getJogadores() {

		for (int i = 0; i < lstJogadores.size(); i++) {
			if (lstJogadores.get(i).getNome().equalsIgnoreCase("world")) {
				lstJogadores.remove(i);
			}
		}

		return lstJogadores;
	}

	public void setJogador(String linha) {
		JogadorTOImpl.montaTO(linha, lstJogadores);
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public void implementaHoraFim(String linha) {
		this.horaFim = PartidaTOImpl.montaHora(linha);
	}

	public void implementaDataFim(String linha) {
		this.dataFim = PartidaTOImpl.montaData(linha);
	}

	public String getJogadorMaisMatou() {

		ArrayList<String> lstAssassino = new ArrayList<String>();

		for (AcaoTO acao : lstAcao) {
			lstAssassino.add(acao.getMatou());
		}
		HashMap<String, Integer> matador = UtilitariosLogView
				.getTopLista(lstAssassino);
		Iterator<String> i = matador.keySet().iterator();
		return (String) i.next();
	}

	public HashMap<String, Integer> getArmaMaisMatou() {

		ArrayList<String> lstArma = new ArrayList<String>();
		for (AcaoTO acao : lstAcao) {
			lstArma.add(acao.getArma());
		}
		return UtilitariosLogView.getTopLista(lstArma);
	}

	public ArrayList<JogadorTO> getJogadoresInvictos() {

		ArrayList<JogadorTO> lstInvicto = new ArrayList<JogadorTO>();
		for (int i = 0; i < lstJogadores.size(); i++) {
			if (lstJogadores.get(i).getQtdMorte() == 0) {
				lstInvicto.add(lstJogadores.get(i));
			}
		}

		return lstInvicto;
	}

	public void add(String linha) {
		this.setAcao(linha);
		this.setJogador(linha);
	}

	public void fimPartida(String linha) {
		
		this.implementaDataFim(linha);
		this.implementaHoraFim(linha);
		
	}

}
