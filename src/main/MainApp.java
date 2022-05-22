package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;



public class MainApp extends Application {

	
	// Génère l'écran de connexion
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		Parent pageConnexion = FXMLLoader.load(getClass().getClassLoader().getResource("pevryscolaireView/SceneConnexion.fxml"));
		Scene connexionScene = new Scene(pageConnexion,450,500);
		primaryStage.setScene(connexionScene);
		primaryStage.show();	
		primaryStage.setTitle("Application Pevryscolaire");
	}	

	
	public static void main(String[] args) {
		launch(args);
	}

	/*
	private static void launch(String[] args) {
		// TODO Auto-generated method stub
		
	}
	*/
}