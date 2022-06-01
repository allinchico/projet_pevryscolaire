package pevryscolaireController;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import pevryscolaireModel.ConnectMySQL;
import pevryscolaireModel.Periscolaire;
import pevryscolaireModel.Personne;
import pevryscolaireModel.Session;

public class PagePeriscolaireController {

	ObservableList<String> activitesListe = FXCollections.observableArrayList();
	ObservableList<String> sessionsListe = FXCollections.observableArrayList();
	
    @FXML
    private ComboBox choixActivites, choixSessions;

    @FXML
    private AnchorPane panneauPeriscolaire;
    
    @FXML
    private Pane menuSport;
    
    @FXML
    private void deleteActivites(ActionEvent event) {
    	//idActivites pour récupérer le nom de l'activité sélectionnée dans le combobox
    	String nomActivite = (String) choixActivites.getValue();
    	//requête pour récupérer l'id de l'activité à partir de son nom
    	String reqIdActivite = "SELECT id FROM activites WHERE nom = '"+nomActivite+"'";
    	ArrayList idActiviteTab = ConnectMySQL.main(reqIdActivite);
    	System.out.println(idActiviteTab);
    	Periscolaire.SupprimerActivite(((List<String>) idActiviteTab.get(0)).get(0).toString());
    }

    @FXML
    private void deleteSessions(ActionEvent event) {
    	//idSessions pour récupérer le nom de la session sélectionnée dans le combobox
    	String nomSession = (String) choixSessions.getValue();
    	Periscolaire.SupprimerSession(choixSessions.getValue().toString());
    	
    }

    @FXML
    void initialize() {
    	
    	TableView table = new TableView();
    	TableColumn activiteCol 
        = new TableColumn("Id session");
    	activiteCol.setCellValueFactory(new PropertyValueFactory<>("activite"));
    	

        // Create column UserName (Data type of String).
        TableColumn dateCol 
                = new TableColumn("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Create column Email (Data type of String).
        TableColumn heureCol
                = new TableColumn("Heure");
        heureCol.setCellValueFactory(new PropertyValueFactory<>("heure"));

        // Create column FullName (Data type of String).
        TableColumn lieuCol
                = new TableColumn("Lieu");
        lieuCol.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        
        
        TableColumn nombreEnfantCol
        = new TableColumn("Nombre de participants");
        nombreEnfantCol.setCellValueFactory(new PropertyValueFactory<>("enfant"));
        table.getColumns().addAll(activiteCol, dateCol, heureCol, lieuCol, nombreEnfantCol);
        
        
    	ArrayList tabSession = new ArrayList();
    	System.out.println("utilisateur famille : "+ SceneConnexionController.user.nom);
		ArrayList<ArrayList> AllActivites = Personne.ConsulterActivite();
		System.out.println(AllActivites);
		for(ArrayList activite: AllActivites) {
			activitesListe.add(activite.get(1).toString());
			
			ArrayList<ArrayList> AllSession = Personne.ConsulterSession(activite.get(0).toString());
			
			for(ArrayList sess : AllSession) {
				ArrayList nombreParticipant = ConnectMySQL.main("SELECT COUNT(idEnfant) FROM enfant_session where idSession ="+sess.get(0).toString());
				Session ses = new Session (activite.get(1).toString()+" : "+sess.get(0).toString(),sess.get(1).toString(),sess.get(2).toString(),sess.get(3).toString(), nombreParticipant.get(0).toString());
				sessionsListe.add(sess.get(0).toString());
				tabSession.add(ses);
				
				}
		}
			
		choixSessions.setItems(sessionsListe);
		table.getItems().addAll(tabSession);
		table.setMaxSize(650, 200);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		menuSport.getChildren().add(table);
		
			choixActivites.setValue("<Veuillez sélectionner une activité>");
        	choixActivites.setItems(activitesListe);
        	//choixSessions.setValue("<Veuillez sélectionner une session>");
        	//choixSessions.setItems(sessionsListe);   	
		}
}