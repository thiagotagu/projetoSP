package br.com.gameViewLog.bean;

import br.com.gameViewLog.beanImpl.AcaoTOImpl;

public class AcaoTO {

	private String data;
	private String hora;
	private String texto;

	private String matou;
	private String morreu;
	private String arma;

	public AcaoTO() {
		super();
	}

	public AcaoTO(String linha) {
		AcaoTO acaoTO = AcaoTOImpl.montaTO(linha);

		if (validaTO(acaoTO)) {
			this.data = acaoTO.getData();
			this.hora = acaoTO.getHora();
			this.texto = acaoTO.getTexto();
			this.matou = acaoTO.getMatou();
			this.morreu = acaoTO.getMorreu();
			this.arma = acaoTO.getArma();
		}

	}

	private boolean validaTO(AcaoTO acaoTO) {

		return (!acaoTO.getMatou().toLowerCase().equals("world"));
	}

	public String getMatou() {
		return matou;
	}

	public void setMatou(String matou) {
		this.matou = matou;
	}

	public String getMorreu() {
		return morreu;
	}

	public void setMorreu(String morreu) {
		this.morreu = morreu;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
