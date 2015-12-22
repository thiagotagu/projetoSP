package br.com.gameViewLog.utilitario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UtilitariosLogView {

	

	public static Boolean validaData(String data) {

		String DatePattern = "^(?:(31)(\\D)(0?[13578]|1[02])\\2|(29|30)(\\D)(0?[13-9]|1[0-2])\\5|(0?[1-9]|1\\d|2[0-8])(\\D)(0?[1-9]|1[0-2])\\8)((?:1[6-9]|[2-9]\\d)?\\d{2})$|^(29)(\\D)(0?2)\\12((?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)$";
		if (data.matches(DatePattern)) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean validaHora(String data) {

		String DatePattern = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
		if (data.matches(DatePattern)) {
			return true;
		} else {
			return false;
		}
	}

	public static String procuraAtributo(String atributo, String texto) {

		return procuraAtributo(atributo, texto, true);
	}

	public static String procuraAtributo(String atributo, String texto,
			boolean proximo) {

		String valorAtributo = "";

		if (texto.isEmpty() || texto.trim().isEmpty()) {
			return valorAtributo.trim();
		}

		String[] palavras = texto.split(" ");
		int posRetorno = -1;

		for (int i = 0; i < palavras.length; i++) {
			if (palavras[i].toLowerCase().equals(atributo.toLowerCase())) {
				posRetorno = i;
				if (proximo) {
					posRetorno++;
				} else {
					posRetorno--;
				}

				break;
			}
		}

		if (posRetorno >= 0 && posRetorno <= palavras.length) {
			valorAtributo = palavras[posRetorno];
		}

		return valorAtributo.trim();
	}

	public static Boolean validaPalavras(String atributo, String texto) {

		if (texto.isEmpty() || texto.trim().isEmpty()) {
			return false;
		}

		String[] palavras = texto.split(" ");

		for (int i = 0; i < palavras.length; i++) {
			if (palavras[i].toLowerCase().equals(atributo.toLowerCase())) {
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HashMap ordernarDecrescente(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o2, Object o1) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	public static String toJson(Object objeto) {

		Gson GSON = new GsonBuilder().create();
		return GSON.toJson(objeto);
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, Integer> getTopLista(ArrayList<String> lstTop) {
		HashMap<String, Integer> mListaTop = new HashMap<String, Integer>();
		Iterator<String> it = lstTop.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			int frequency = Collections.frequency(lstTop, obj);
			mListaTop.put(String.valueOf(obj), frequency);
		}

		return ordernarDecrescente(mListaTop);
	}

	public static boolean diferencaMenor1Minuto(String dtIni, String dtFim) {

		Date dataInicial;
		Date dataFinal;
		DateFormat frmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			dataInicial = frmt.parse(dtIni);

			dataFinal = frmt.parse(dtFim);
			long differenceMilliSeconds = dataFinal.getTime()
					- dataInicial.getTime();
			return ((differenceMilliSeconds / 1000) <= 60);
		}

		catch (ParseException pe) {
			System.out.println(pe);
		}

		return false;
	}
	
	public static boolean isBlackList(String nome){
		
		CarregaPropertie prop;
		String blackList = "";
		try {
			prop = new CarregaPropertie();
			blackList = prop.getBlackList();

			return  (blackList.toLowerCase().contains(nome.toLowerCase()));
			
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

}
