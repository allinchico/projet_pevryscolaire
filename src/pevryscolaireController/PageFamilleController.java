package pevryscolaireController;

import java.util.ArrayList;
import java.util.TreeSet;

import javafx.fxml.FXML;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import pevryscolaireModel.ConnectMySQL;
import pevryscolaireModel.ResponsableLegal;
import pevryscolaireModel.Session;



public class PageFamilleController {
	
	@FXML
    private Pane paneSessions;
	
	@FXML
    void initialize() {
    	
    	TableView table = new TableView();
    	TableColumn activiteCol 
        = new TableColumn("Activite");
    	activiteCol.setCellValueFactory(new PropertyValueFactory<>("activite"));
    	

        TableColumn dateCol 
                = new TableColumn("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        
        TableColumn heureCol
                = new TableColumn("Heure");
        heureCol.setCellValueFactory(new PropertyValueFactory<>("heure"));

        
        TableColumn lieuCol
                = new TableColumn("Lieu");
        lieuCol.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        
        TableColumn enfantCol 
        = new TableColumn("Enfant");
        enfantCol.setCellValueFactory(new PropertyValueFactory<>("enfant"));
    	
        
        table.getColumns().addAll(activiteCol, dateCol, heureCol, lieuCol, enfantCol);
        
        
        ArrayList AllSession = new ArrayList();
    	String req = "SELECT id FROM enfant where idResponsableLegal = "+SceneConnexionController.user.id;
        ArrayList<ArrayList> AllEnfants = ConnectMySQL.main(req);
        System.out.println(AllEnfants);
        for(ArrayList enfant : AllEnfants) {
        	String idEnfant = enfant.get(0).toString();
        	String reqEnfant = "SELECT prenom FROM enfant WHERE id ="+idEnfant;
        	ArrayList nomEnfant = ConnectMySQL.main(reqEnfant);
        	String reqSession = "SELECT * from session where id in (SELECT idSession FROM enfant_session where idEnfant = "+idEnfant+")";
        	ArrayList<ArrayList> InfosSession = ConnectMySQL.main(reqSession);
        	for(ArrayList session : InfosSession) {
        		String activite = "SELECT nom FROM activites, session where activites.id = session.idActivite AND session.id ="+session.get(0);
        		ArrayList nomActivite = ConnectMySQL.main(activite);
        		Session ses = new Session(nomActivite.get(0).toString().replaceAll("\\[|\\]", ""), session.get(1).toString(),session.get(2).toString(),session.get(3).toString(), nomEnfant.get(0).toString().replaceAll("\\[|\\]", ""));
        		AllSession.add(ses);
        	}
        }
        System.out.println(AllSession);
        table.getItems().addAll(AllSession);
        
        paneSessions.getChildren().add(table);
    }
	
}
