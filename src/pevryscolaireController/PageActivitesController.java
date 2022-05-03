package pevryscolaireController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class PageActivitesController {

	ObservableList<String> activitesListe = FXCollections.observableArrayList("Football", "Basketball");
	
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
        
    	choixActivites.setValue("<Veuillez sélectionner un sport>");
    	choixActivites.setItems(activitesListe);
    	
    }

}
