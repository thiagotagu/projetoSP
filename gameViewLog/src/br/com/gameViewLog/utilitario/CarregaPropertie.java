package br.com.gameViewLog.utilitario;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CarregaPropertie {
	
	private String caminhoArquivo;
	private String blackList;

	public CarregaPropertie() throws IOException {		
		this.carregaConfiguracaoProperties();
	}

	public  Properties carregaConfiguracaoProperties() throws IOException {
		Properties props = new Properties();
		try {	
			//FileInputStream file = new FileInputStream("/META-INF/configuracaoLog.properties");
			//InputStream in = getClass().getClassLoader().getResourceAsStream("configuracaoLog.properties");			
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("configuracaoLog.properties");

			props.load(in);
			
			setCaminhoArquivo(props.getProperty("caminholog"));
			setBlackList(props.getProperty("blackList"));
			
			} catch (Exception e) {
				System.out.println(e);
			}
		

		return props;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public String getBlackList() {
		return blackList;
	}

	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}
	
}
