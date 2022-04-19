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
import javafx.stage.Stage;
import main.MainApp;

public class PageConnexionController {

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

    // Méthode pour changement de page
    
    @FXML
    public void SeConnecter(ActionEvent event) throws IOException
    {
    	
    	//main.MainApp.pagePrincipale();
    	Parent pagePrincipale = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PagePrincipale.fxml"));
    	Scene principaleScene = new Scene(pagePrincipale);
     
    
    // Récupère les informations de la page
    	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(principaleScene);
	window.show();
    }
    
}
