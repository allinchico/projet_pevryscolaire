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
	
	
	// G�n�re l'�cran de connexion
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

	public static void main(String[] args) {
		launch(args);
	}

	/*
	private static void launch(String[] args) {
		// TODO Auto-generated method stub
		
	}
	*/
}
