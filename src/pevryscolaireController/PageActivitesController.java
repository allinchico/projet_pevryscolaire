package pevryscolaireController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pevryscolaireModel.ConnectMySQL;
import pevryscolaireModel.Personne;
import pevryscolaireModel.ResponsableLegal;
import pevryscolaireModel.Session;

public class PageActivitesController {

	ObservableList<String> activitesListe = FXCollections.observableArrayList();
	ObservableList<String> enfantsListe = FXCollections.observableArrayList();
	ObservableList<String> sessionListe = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox choixActivites, choixEnfant, choixSession;

    @FXML
    private DatePicker choixDate;
    
    @FXML
    private TabPane ongletSport;
    
    @FXML
    private Tab menuSport;
    
    
    
    String idSession;
    

    
	


    @FXML
    void initialize() {
        ArrayList<ArrayList> AllActivites = Personne.ConsulterActivite();
        for(ArrayList activite: AllActivites) {
        	 ArrayList<Session> ligneSession = new ArrayList();
        	TableView table = new TableView();
        	TableColumn activiteCol 
            = new TableColumn("Activite");
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
            table.getColumns().addAll(activiteCol, dateCol, heureCol, lieuCol);
        	
        	activitesListe.add(activite.get(1).toString());
        	ArrayList<ArrayList> tabSession = Personne.ConsulterSession(activite.get(0).toString());
        	
        	
        	for(ArrayList session: tabSession) {
        		sessionListe.add(activite.get(1)+"/"+session.get(1)+"/"+session.get(2)+"/"+session.get(3));
        		
        		Session ses = new Session(activite.get(1).toString(),session.get(1).toString(),session.get(2).toString(),session.get(3).toString(),"");
        		ligneSession.add(ses);
        		System.out.println(activite.get(1).toString()+"/"+session.get(1).toString()+"/"+session.get(2).toString()+"/"+session.get(3).toString());
        		
        		
        	}
        	for(Session ses : ligneSession) {
            	table.getItems().add(ses);
            	System.out.println(ses.getActivite());
            }
        	
        	Tab tab = new Tab(activite.get(1).toString());
        	tab.setContent(table);
        	ongletSport.getTabs().add(tab);
        }
        
        
        
        
        
        
        

        
        ArrayList<ArrayList> AllEnfants = ResponsableLegal.getEnfants();
        for(ArrayList enfant: AllEnfants) {
        	enfantsListe.add(enfant.get(2).toString());
        }
        choixEnfant.setValue("<Veuillez sélectionner un enfant>");
        choixEnfant.setItems(enfantsListe);
    	choixActivites.setValue("<Veuillez sélectionner un sport>");
    	choixActivites.setItems(activitesListe);
    	choixSession.setValue("<Veuillez sélectionner une session>");
    	choixSession.setItems(sessionListe);
        
    	
    }
    
    @FXML
    void inscrireEnfant() {
    	if(choixEnfant.getValue() != "<Veuillez sélectionner un enfant>" &&  choixSession.getValue() != "<Veuillez sélectionner une session>") {
    		ArrayList enfant = ConnectMySQL.main("SELECT id FROM enfant WHERE prenom = '"+choixEnfant.getValue().toString()+"'");
    		
    		System.out.println(choixEnfant.getValue());
    		System.out.println(choixSession.getValue());
    		String[] parts = choixSession.getValue().toString().split("/");
    		System.out.println(parts[0]);
    		
    		ArrayList session = ConnectMySQL.main("SELECT id FROM session WHERE date = '"+parts[1]+"' AND heure = '"+parts[2]+"' AND lieu = '"+parts[3]+"' and idActivite in (SELECT id FROM activites WHERE nom = '"+parts[0]+"')");
    	
    	String req = "INSERT INTO enfant_session values ("+enfant.get(0).toString().replaceAll("\\[|\\]", "")+","+session.get(0).toString().replaceAll("\\[|\\]", "")+");";
    	ConnectMySQL.main(req);
    	}
    }
    

}
