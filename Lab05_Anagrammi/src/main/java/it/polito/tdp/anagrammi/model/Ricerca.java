package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Ricerca {

	private List<String> soluzione;

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso
	 * 
	 * @param parola parola da anagrammare
	 * @return elenco degli anagrammi trovati
	 */
	public List<String> anagrammi(String parola) {

		parola = parola.toUpperCase();
		List<Character> disponibili = new ArrayList<>();

		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}

		this.soluzione = new ArrayList<>();
		this.cerca("", 0, disponibili);
		return soluzione;
	}

	/**
	 * Procedura ricorsiva per il calcolo dell'anagramma
	 * 
	 * @param parziale    parte iniziale dell'anagramma costruito fino ad ora
	 * @param livello     livello della ricorsione, sempre uguale a parziale.legth()
	 * @param disponibili lista delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if (disponibili.size() == 0) {
			this.soluzione.add(parziale);
		}

		for (Character ch : disponibili) {
			String tentativo = parziale + ch;

			List<Character> ridotta = new ArrayList<>(disponibili);
			ridotta.remove(ch);
			cerca(tentativo, livello + 1, ridotta);
		}
	}

}
