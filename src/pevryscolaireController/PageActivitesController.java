package pevryscolaireController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import pevryscolaireModel.Personne;
import pevryscolaireModel.ResponsableLegal;

public class PageActivitesController {

	ObservableList<String> activitesListe = FXCollections.observableArrayList();
	ObservableList<String> enfantsListe = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox choixActivites, choixEnfant, choixSession;

    @FXML
    private DatePicker choixDate;

    @FXML
    void initialize() {
        
        System.out.println("utilisateur famille : "+ SceneConnexionController.user.nom);
        ArrayList<ArrayList> AllActivites = Personne.ConsulterActivite();
        System.out.println(AllActivites);
        for(ArrayList activite: AllActivites) {
        	activitesListe.add(activite.get(1).toString());
        }
        ArrayList<ArrayList> AllEnfants = ResponsableLegal.getEnfants();
        for(ArrayList enfant: AllEnfants) {
        	enfantsListe.add(enfant.get(2).toString());
        }
        choixEnfant.setValue("<Veuillez sélectionner un enfant>");
        choixEnfant.setItems(enfantsListe);
    	choixActivites.setValue("<Veuillez sélectionner un sport>");
    	choixActivites.setItems(activitesListe);
    	
        
    	
    }

}
