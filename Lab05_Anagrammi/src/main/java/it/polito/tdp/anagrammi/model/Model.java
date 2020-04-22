package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	private Ricerca ricerca;
	private List<String> soluzione;
	private AnagrammaDAO dao;

	public Model() {
		ricerca = new Ricerca();
		soluzione = new ArrayList<>();
		dao = new AnagrammaDAO();
	}

	public List<String> getAnagrammiCorretti(String parola) {
		List<String> corretti = new ArrayList<>();
		soluzione = ricerca.anagrammi(parola);
		for (String s : soluzione) {
			if (dao.isCorrect(s)) {
				corretti.add(s);
			}

		}
		return corretti;
	}
	
	public List<String> getAnagrammiSbagliati(String parola) {
		List<String> sbagliati = new ArrayList<>();
		soluzione = ricerca.anagrammi(parola);
		for (String s : soluzione) {
			if (!dao.isCorrect(s)) {
				sbagliati.add(s);
			}

		}
		return sbagliati;
	}
}
