package it.polito.tdp.anagrammi;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	String parola= this.txtParola.getText();
    	
    	if(parola.isEmpty()) {
    		this.txtCorretti.setText("Devi inserire una parola");
    	}
    	if(parola.contains("[\\=.,\\?\\/#!$%\\^$\\*;:{}\\-\\_()\\[\\]\"]")) {
    		this.txtCorretti.setText("Devi inserire una parola senza simboli e spazi");
    	}
    	
    	List<String> corretti= this.model.getAnagrammiCorretti(parola);
    	List<String> sbagliati= this.model.getAnagrammiSbagliati(parola);
    	
    	for(String s: corretti) {
    		this.txtCorretti.appendText(s+"\n");
    	}
    	for(String s: sbagliati) {
    		this.txtErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void reset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}
}
