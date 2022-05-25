package pevryscolaireController;

import javafx.fxml.FXML;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import pevryscolaireModel.ResponsableLegal;

public class PageFamilleController {
	@FXML
    void initialize() {
    	System.out.println("utilisateur famille : "+ SceneConnexionController.user.nom);
    }
	
}
