package br.com.gameViewLog.taglib;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import br.com.gameViewLog.bean.PartidaTO;
import br.com.gameViewLog.carregamento.ObterLog;
import br.com.gameViewLog.utilitario.UtilitariosLogView;

public class CarregaLog  extends TagSupport  {
 
	private static final long serialVersionUID = 7455467876066565694L;
	//private Logger log = Logger.getLogger("CarregaLog");
	
	
	@Override
	public int doStartTag() throws JspException {
		
		try {
 
		  ArrayList<PartidaTO> lstLog = ObterLog.obterListaLog();
			
		  pageContext.setAttribute("lstPartidas", lstLog);
		  pageContext.setAttribute("jsonPartidas", UtilitariosLogView.toJson(lstLog));
		} catch (Exception e) {
		//	log.debug("Erro taglib", e);
		}
		
		return EVAL_BODY_INCLUDE;
	}
}
