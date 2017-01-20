package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;
	
	public class WordEnhanced {  
		private String alienWord;
	    private	List<String> translations;             //lista di traduzioni relative a una sola parola
	   
		
		public WordEnhanced(String alienWord, String translation) {   //str è lista
			super();
			this.alienWord = alienWord;
			this.translations = new LinkedList<String>();
			this.translations.add(translation) ;                //come primo ele è la parola data
		}	
		
		public String getAlienWord() {
			return alienWord;
		}
		public void setAlienWord(String alienWord) {
			this.alienWord = alienWord;
		}
		public List<String> getTranslations() {       //ritorna la lista
			return translations;
		}
		public void setTranslations(List<String> translations) {
			this.translations = translations;
		}
		
		
		public void isTraduzionePresente( String traduzione){         //vedo se traduzione c'è gia
			if(!translations.contains(traduzione)){                  //se nn c'è
				translations.add(traduzione);                       //la aggiunge in coda dopo le altre
			}
			else {
				//stampare messaggio
				System.out.println("Questa traduzione  è  gia stata inserita");  //utente nn vede
			}
		}
 }
