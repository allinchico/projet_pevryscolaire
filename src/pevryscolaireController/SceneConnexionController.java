package pevryscolaireController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.MainApp;

public class SceneConnexionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button connect_bouton;

    @FXML
    private PasswordField identifiant;

    @FXML
    private ImageView logoEvry;

    @FXML
    private Label messageBienvenue;

    @FXML
    private PasswordField password;
    
    @FXML
    private BorderPane panneauPrincipal;
    
    // Méthode pour changement de page
    @FXML
    public void SeConnecter(ActionEvent event) {
    	try {
    	Parent pagePrincipale = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/ScenePrincipale.fxml"));
    	Scene pagePrincipaleScene = new Scene(pagePrincipale);
    	
     
    // Récupère les informations de la page
    	
    	Stage fenetrePrincipale = (Stage)((Node)event.getSource()).getScene().getWindow();
		fenetrePrincipale.setScene(pagePrincipaleScene);
		fenetrePrincipale.show();
		
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}	
    
    
    @FXML
    void initialize() {
    	
    }
}
    