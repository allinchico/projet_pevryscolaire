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
    private TextField nomActivite, materiel;

    @FXML
    private DatePicker choixDate;

    @FXML
    private TabPane ongletSport;
   
    
    
    @FXML
    private void CreerActivite(ActionEvent event) {
    	//idResp pour r�cup�rer le nom du responsable p�riscolaire s�lectionn� dans le combobox
    	String idResp = (String) choixResponsable.getValue();
    	//requ�te pour r�cup�rer l'id du responsable p�riscolaire � partir de son nom
    	String reqIdResp = "SELECT idUser FROM periscolaire WHERE nom = '"+idResp+"'";
    	ArrayList idRespTab = ConnectMySQL.main(reqIdResp);
    	System.out.println(idRespTab);
    	//appel de la m�thode pour insert une activit� dans la table
		Periscolaire.CreerActivite(nomActivite.getText(), materiel.getText(), ((List<String>) idRespTab.get(0)).get(0).toString());
    }
  
    
    
    @FXML
    void initialize() {
        
        System.out.println("utilisateur famille : "+ SceneConnexionController.user.nom);
        ArrayList<ArrayList> AllActivites = Personne.ConsulterActivite();
        System.out.println(AllActivites);
        for(ArrayList activite: AllActivites) {
        	activitesListe.add(activite.get(1).toString());
        	ongletSport.getTabs().add(new Tab(activite.get(1).toString(), new Label("AFFICHER SESSION "+activite.get(1).toString())));
        }
        ArrayList<ArrayList> AllResponsablePeri = Periscolaire.getPeriscolaire();
        for(ArrayList responsablePeri: AllResponsablePeri) {
        	responsablePeriListe.add(responsablePeri.get(0).toString());
        }
        choixResponsable.setValue("<Veuillez s�lectionner un responsable>");
        choixResponsable.setItems(responsablePeriListe);
        choixActivites.setValue("<Veuillez s�lectionner un sport>");
        choixActivites.setItems(activitesListe);
        
    	
    }

}
