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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.MainApp;
import pevryscolaireModel.Periscolaire;
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
    private TextField id;

    @FXML
    private BorderPane panneauPrincipal;
    
    // Méthode pour récupérer les infos de l'utilisateur et la connexion

    static Personne user;
    
    // Méthode pour changement de page

    @FXML
    public void SeConnecter(ActionEvent event) {
    	try {
    	System.out.println("Id = "+ id.getText() +" password = " + password.getText());
		if(!Personne.seConnecter(id.getText(), password.getText()).isEmpty()) {
			
	    	ArrayList<ArrayList> tabUser = Personne.seConnecter(id.getText(), password.getText());
	    	System.out.println("tab : "+tabUser);
	    	
	    	for(ArrayList tab : tabUser) {
	    		 ArrayList tabPeris = Personne.verifierStatutPeriscolaire(tab.get(1).toString());
	    		 ArrayList tabResp = Personne.verifierStatutResponsable(tab.get(1).toString());
	    		System.out.println(tabResp);
	    		
	    		if(!tabPeris.isEmpty()) {
	    			System.out.println("if periscolaire");
	    			user = new Periscolaire(tab.get(0).toString());		
	    			//TO DO FAIRE CODE APPEL PAGE PERISCOLAIRE
	    			System.out.println(user.nom);
		    		Parent pagePrincipale = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/ScenePrincipalePeri.fxml"));
		    		Scene pagePrincipaleScene = new Scene(pagePrincipale);
			    	Stage fenetrePrincipale = (Stage)((Node)event.getSource()).getScene().getWindow();
					fenetrePrincipale.setScene(pagePrincipaleScene);
					fenetrePrincipale.show();
					System.out.println("Ouverture peri");
	    		}
	    		else if(!tabResp.isEmpty()){
	    			System.out.println("if responsable legal");
	    			user = new ResponsableLegal(tab.get(0).toString());
	    			System.out.println(user.nom);
		    		Parent pagePrincipale = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/ScenePrincipale.fxml"));
		    		Scene pagePrincipaleScene = new Scene(pagePrincipale);
			    	Stage fenetrePrincipale = (Stage)((Node)event.getSource()).getScene().getWindow();
					fenetrePrincipale.setScene(pagePrincipaleScene);
					fenetrePrincipale.show();
	    		}
	    		
   
	    	}
	    // Génère la scène principale

		}
		else {

			System.out.println("Problème : identifiant ou mot de passe incorrect");

			Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Erreur de saisie");
            errorAlert.setContentText("Identifiant ou mot de passe incorrect");
            errorAlert.showAndWait();
		}
		
		
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}	
    
    
    @FXML
    void initialize() {
    	
    }
}
    