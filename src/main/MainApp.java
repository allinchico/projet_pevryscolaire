package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class MainApp extends Application {

	private Stage secondaryStage;
	public BorderPane pagePrincipale;
	
	
	// Génère l'écran de connexion
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent pageConnexion = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/SceneConnexion.fxml"));
			Scene connexionScene = new Scene(pageConnexion,450,500);
			primaryStage.setScene(connexionScene);
			primaryStage.show();	
			primaryStage.setTitle("Application Pevryscolaire");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	/*
	// Génère l'écran principale de l'application
	public void pagePrincipale(Stage secondaryStage) {
		try {
			
			this.secondaryStage = secondaryStage;
			this.secondaryStage.setTitle("Application Pevryscolaire");
		
			afficherPagePrincipale();
		//	afficherPageActivites();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			/*
		Parent pagePrincipale = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/PagePrincipale.fxml"));
		Scene principaleScene = new Scene(pagePrincipale,600,700);
		secondaryStage.setScene(principaleScene);
		secondaryStage.show();	
		secondaryStage.setTitle("Application Pevryscolaire");
		
		
	
	//Initialise la page principale de l'application
	public void afficherPagePrincipale() {
		try {
				// Génère l'écran en récupérant la page fxml
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("pevryscolaireView/PagePrincipale.fxml"));
				pagePrincipale = (BorderPane) loader.load();
				
				// Affiche la page ayant le contenu de PagePrincipale
				Scene scene = new Scene(pagePrincipale);
				secondaryStage.setScene(scene);
				secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	public  void afficherPageActivites() {
		try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("pevryscolaireView/PageActvites.fxml"));
				AnchorPane pageActivites = (AnchorPane) loader.load();
		
				pagePrincipale.setCenter(pageActivites);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	*/

	public static void main(String[] args) {
		launch(args);
	}

	/*
	private static void launch(String[] args) {
		// TODO Auto-generated method stub
		
	}
	*/
}
