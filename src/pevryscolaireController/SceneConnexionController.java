package pevryscolaireController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.MainApp;
import pevryscolaireModel.Personne;
import pevryscolaireModel.ResponsableLegal;

public class SceneConnexionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button connect_bouton;

    @FXML
    private ImageView logoEvry;

    @FXML
    private Label messageBienvenue;

    @FXML
    private PasswordField password;
    
    @FXML
    private BorderPane panneauPrincipal;
    
    @FXML
    private TextField id;
    
    static Personne user;
    
    // Méthode pour changement de page
    @FXML
    public void SeConnecter(ActionEvent event) {
    	try {
    	System.out.println("Id = "+ id.getText() +" password = " + password.getText());
		if(!Personne.seConnecter(id.getText(), password.getText()).isEmpty()) {
			
	    	ArrayList<ArrayList> tabUser = Personne.seConnecter(id.getText(), password.getText());
	    	for(ArrayList tab : tabUser) {
	    		System.out.println("id envoyé : "+tab);
	    		user = new ResponsableLegal(tab.get(0).toString());
	    		System.out.println(user.nom);
	    	}
	    	Parent pagePrincipale = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/ScenePrincipale.fxml"));
	    	Scene pagePrincipaleScene = new Scene(pagePrincipale);

	    	
	     
	    // Récupère les informations de la page
	    	
	    	Stage fenetrePrincipale = (Stage)((Node)event.getSource()).getScene().getWindow();
			fenetrePrincipale.setScene(pagePrincipaleScene);
			fenetrePrincipale.show();
		}
		else {
			System.out.println("Problème : identifiant ou mot de passe incorrect");
		}
		
		
		
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}	
    
    
    @FXML
    void initialize() {
    	
    }
}
    