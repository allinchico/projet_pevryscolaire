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
 /*
    @FXML
    private void accederActivites(ActionEvent event) {
    	try {
    	AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageActivites.fxml"));
    	panneauPrincipal.setCenter(pane);
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    private void accederAccueil(ActionEvent event) {
    	try {
    	AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageAccueil.fxml"));
    	panneauPrincipal.setCenter(pane);
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    private void accederFamille(ActionEvent event) {
    	try {
    	AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PageFamille.fxml"));
    	panneauPrincipal.setCenter(pane);
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
   */ 
    
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
        assert boutonActivites != null : "fx:id=\"bouton_activites\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert boutonFamille != null : "fx:id=\"bouton_famille\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert logoEvry != null : "fx:id=\"logoEvry\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert panneau_accueil != null : "fx:id=\"panneau_accueil\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert panneau_activites != null : "fx:id=\"panneau_activites\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert panneau_famille != null : "fx:id=\"panneau_famille\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
