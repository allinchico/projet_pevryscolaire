package pevryscolaireController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.MainApp;

public class PageAccueilController{

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private BorderPane panneauPrincipal;
    
    @FXML
    private Label nomUser;
    
    
  
    @FXML
    void initialize() {
    	nomUser.setText(SceneConnexionController.user.nom.toString());
    }



	

	

}

