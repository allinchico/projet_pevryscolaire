package pevryscolaireController;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import main.MainApp;

public class ScenePrincipaleController implements Initializable {
	
	private MainApp main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton boutonAccueil, boutonActivites, boutonFamille;

    @FXML
    private ImageView logoEvry;

    @FXML
    private Pane panneau_accueil, panneau_activites, panneau_famille, view;
    
    @FXML
    private BorderPane panneauPrincipal;
    
   @FXML
    private void boutonAcceder(ActionEvent event) {
    	try {
    	if(event.getSource() == boutonAccueil)
    	{
    		AnchorPane panneauAccueil = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageAccueil.fxml"));
    		panneauPrincipal.setCenter(panneauAccueil);
    	}
    	else if(event.getSource() == boutonActivites)
    	{
    		AnchorPane panneauActivites = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageActivites.fxml"));
    		panneauPrincipal.setCenter(panneauActivites);
    	}
    	else if(event.getSource() == boutonFamille)
    	{
    		AnchorPane panneauFamille = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageFamille.fxml"));
    		panneauPrincipal.setCenter(panneauFamille);
    	}
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}	

    @FXML
    void initialize() {
    	System.out.println("utilisateur : "+ SceneConnexionController.user);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		AnchorPane panneauAccueil;
		try {
			panneauAccueil = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageAccueil.fxml"));
			panneauPrincipal.setCenter(panneauAccueil);
			System.out.println("utilisateur : "+ SceneConnexionController.user.nom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
