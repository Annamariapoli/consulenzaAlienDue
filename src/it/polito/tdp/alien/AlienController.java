package it.polito.tdp.alien;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private  AlienDizionario dizionario = new AlienDizionario();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnPulisci;

    @FXML
    void doPulisci(ActionEvent event) {
    	txtTesto.clear();
    	txtResult.clear();
    }

    @FXML
    void doTraduci(ActionEvent event) {
    	String s = txtTesto.getText(); 
    	txtTesto.clear();
    	s=s.toLowerCase();
    	if(s.isEmpty()){                                 //ritorna un booleano (true se é vuota)
    		txtResult.appendText("La stringa è vuota");
    		return;
    	}
    	int spazi= 0;
    	for(int i=0; i<s.length();i++){
    		if(Character.isSpaceChar(s.charAt(i))){                 //trovo posizione dello spazio
    			spazi++;
    			if(spazi>1){                                        //se piu di 1 c'è errore
    				txtResult.appendText("Testo non corretto");
    				return;
    			}	
    		} else {
    			     if(!Character.isLetter(s.charAt(i))){                   //se non  sono lettere
    			    	 txtResult.appendText("Il testo non è corretto");
    			    	 return;
    			     }		    	 
    		}
    	}
    	if(spazi==0){                                               //solo una parola  
    		List<String> s1= dizionario.translateWord(s);          //la traduco ritornando la lista
    		if(s1!=null){
    			txtResult.appendText("La traduzione della parola " + s +  " è " + s1 +"\n");
    		}
    		else { txtResult.appendText("La parola non è presente \n");
    	      
    		}
    	}
    	
    	else {                                                  //se ho uno spazio:
    		
    		String s2="";
    		String alienWord;
    		String translation;                              //utente mette una stringa
    		
    		int posizione=0;
    		posizione=s.indexOf(" ");
    		
    		alienWord=s.substring(0, posizione);
    		translation=s.substring(posizione+1);
    		 //paroleETraduzioni.isTraduzionePresente(translation);   //se la traduzione inserita da utente è diversa, la aggiunge	
    		//solo dizionario
    		dizionario.addWord(alienWord, translation);
    		txtResult.appendText("E' stata aggiunta la nuova parola" + s2 + " con la traduzione  \n");
    	}
    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'it.polito.tdp.alien.fxml'.";
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'it.polito.tdp.alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'it.polito.tdp.alien.fxml'.";
        assert btnPulisci != null : "fx:id=\"btnPulisci\" was not injected: check your FXML file 'it.polito.tdp.alien.fxml'.";

    }
}
