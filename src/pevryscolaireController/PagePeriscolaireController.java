package pevryscolaireController;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import pevryscolaireModel.ConnectMySQL;
import pevryscolaireModel.Periscolaire;
import pevryscolaireModel.Personne;

public class PagePeriscolaireController {

	ObservableList<String> activitesListe = FXCollections.observableArrayList();
	
    @FXML
    private ComboBox choixActivites;

    @FXML
    private AnchorPane panneauPeriscolaire;
    
    @FXML
    private void deleteActivites(ActionEvent event) {
    	//idActivites pour r�cup�rer le nom de l'activit� s�lectionn�e dans le combobox
    	String nomActivite = (String) choixActivites.getValue();
    	//requ�te pour r�cup�rer l'id de l'activit� � partir de son nom
    	String reqIdActivite = "SELECT id FROM activites WHERE nom = '"+nomActivite+"'";
    	ArrayList idActiviteTab = ConnectMySQL.main(reqIdActivite);
    	System.out.println(idActiviteTab);
    	Periscolaire.SupprimerActivite(((List<String>) idActiviteTab.get(0)).get(0).toString());
    }


    @FXML
    void initialize() {
    	System.out.println("utilisateur famille : "+ SceneConnexionController.user.nom);
		ArrayList<ArrayList> AllActivites = Personne.ConsulterActivite();
		System.out.println(AllActivites);
		for(ArrayList activite: AllActivites) {
			activitesListe.add(activite.get(1).toString());
			choixActivites.setValue("<Veuillez s�lectionner un sport>");
        	choixActivites.setItems(activitesListe);
		}
	}
}