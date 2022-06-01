package pevryscolaireController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import pevryscolaireModel.ConnectMySQL;
import pevryscolaireModel.Periscolaire;
import pevryscolaireModel.Personne;
import pevryscolaireModel.ResponsableLegal;

public class PageActivitesControllerPeri {

	ObservableList<String> activitesListe = FXCollections.observableArrayList();
	ObservableList<String> responsablePeriListe = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox choixActivites, choixResponsable;
    
    @FXML
    private TextField nomActivite, materiel, heureSession, lieuSession;

    @FXML
    private DatePicker choixDate;

    @FXML
    private TabPane ongletSport;
   
    
    
    @FXML
    private void addActivites(ActionEvent event) {
    	//idResp pour récupérer le nom du responsable périscolaire sélectionné dans le combobox
    	String idResp = (String) choixResponsable.getValue();
    	//requête pour récupérer l'id du responsable périscolaire à partir de son nom
    	String reqIdResp = "SELECT idUser FROM periscolaire WHERE nom = '"+idResp+"'";
    	ArrayList idRespTab = ConnectMySQL.main(reqIdResp);
    	System.out.println(idRespTab);
    	//appel de la méthode pour insert une activité dans la table
		Periscolaire.CreerActivite(nomActivite.getText(), materiel.getText(), ((List<String>) idRespTab.get(0)).get(0).toString());
    }
  
    @FXML
    private void addSessions(ActionEvent event) {
    	//idActivites pour récupérer le nom de l'activité sélectionnée dans le combobox
    	String nomActivite = (String) choixActivites.getValue();
    	//requête pour récupérer l'id de l'activité à partir de son nom
    	String reqIdActivite = "SELECT id FROM activites WHERE nom = '"+nomActivite+"'";
    	ArrayList idActiviteTab = ConnectMySQL.main(reqIdActivite);
    	System.out.println(idActiviteTab);
    	Periscolaire.CreerSession(choixDate.getConverter().fromString(choixDate.getEditor().getText()), heureSession.getText(), lieuSession.getText(), ((List<String>) idActiviteTab.get(0)).get(0).toString()); 
    }
    
    @FXML
    void initialize() {
        
        System.out.println("utilisateur famille : "+ SceneConnexionController.user.nom);
        ArrayList<ArrayList> AllActivites = Personne.ConsulterActivite();
        System.out.println(AllActivites);
        for(ArrayList activite: AllActivites) {
        	activitesListe.add(activite.get(1).toString());
        }
        ArrayList<ArrayList> AllResponsablePeri = Periscolaire.getPeriscolaire();
        for(ArrayList responsablePeri: AllResponsablePeri) {
        	responsablePeriListe.add(responsablePeri.get(0).toString());
        }
        choixResponsable.setValue("<Veuillez sélectionner un responsable>");
        choixResponsable.setItems(responsablePeriListe);
        choixActivites.setValue("<Veuillez sélectionner un sport>");
        choixActivites.setItems(activitesListe);
        
    	
    }

}
