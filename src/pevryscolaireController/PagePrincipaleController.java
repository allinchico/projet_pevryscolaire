package pevryscolaireController;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

public class PagePrincipaleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton bouton_activites, bouton_famille;

    @FXML
    private ImageView logoEvry;

    @FXML
    private Pane panneau_accueil, panneau_activites, panneau_famille;

    @FXML
    private void BoutonAcceder(ActionEvent event) {
    	if(event.getSource() == bouton_activites)
    	{
    		panneau_activites.toFront();
    	}
    	else if(event.getSource() == bouton_famille)
    	{
    		panneau_famille.toFront();
    	}
    }

    @FXML
    void initialize() {
        assert bouton_activites != null : "fx:id=\"bouton_activites\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert bouton_famille != null : "fx:id=\"bouton_famille\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert logoEvry != null : "fx:id=\"logoEvry\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert panneau_accueil != null : "fx:id=\"panneau_accueil\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert panneau_activites != null : "fx:id=\"panneau_activites\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert panneau_famille != null : "fx:id=\"panneau_famille\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

}
