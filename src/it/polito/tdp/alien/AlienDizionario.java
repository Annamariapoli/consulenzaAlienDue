package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDizionario {

	private List<WordEnhanced> paroleConTrad = new LinkedList<WordEnhanced>();   // lista di parole con le traduzioni												

	public void addWord(String alienWord, String translation) {               //agg parolae  valore di ritono, se è gia presente aggiungo la traduzione																
		for (WordEnhanced p : paroleConTrad) {
			if (p.getAlienWord().equals(alienWord)) {                // se c'è // p.equals(alienWord)

				 // controllo se la traduzione non sia uguale a una di quelle gia presenti
				// se è la stessa traduzione stampo un mess  // se la traduzione è diversa
			   // aggiungo la parola e la traduzione in coda alla lista

				p.isTraduzionePresente(translation);             // se non la contiene la aggiunge in coda
				return;                                         // xke ho trovato la parola e c'è una volta sola
			}
		}                                             //esco dal ciclo
		                                             // se la parola non c'è la inserisce

		WordEnhanced parola = new WordEnhanced(alienWord, translation);  //dopo ke sono uscita dal ciclo
		paroleConTrad.add(parola);
	}

	public List<String> translateWord(String alienWord) {
		for (WordEnhanced p : paroleConTrad) {
			if (p.getAlienWord().equals(alienWord)) {     // se c'è la parola
				return p.getTranslations();
			}                                           // ritorno la lista con le traduzioni //SE HA UNA SOLA TRADUZIONE?
				 }
		
		return null;                                // se nn c'è ritorno null
	}

}
