package pevryscolaireModel;

import java.util.ArrayList;

public class ResponsableLegal extends Personne {

	public ResponsableLegal(String id) {
    	String requete = "SELECT * FROM responsablelegal where id = "+id;
        ArrayList<ArrayList> allInformations = ConnectMySQL.main(requete);
        System.out.println("allInformations : "+allInformations);
        for(ArrayList tab : allInformations) {
        	System.out.println("Infos personne : "+tab);
        	this.id = tab.get(0).toString();
        	this.nom = tab.get(1).toString();
        	this.prenom = tab.get(2).toString();
        	this.sexe = tab.get(3).toString();
        	this.dateDeNaissance = tab.get(5).toString();
        	this.salaire = tab.get(6).toString();
        	this.statutMaritale = tab.get(7).toString();      	
        }
    }
    

    public static void Inscrire(Integer idSession, Integer idEnfant){
        String req = "INSERT INTO enfant_session VALUES ("+idEnfant+", "+idSession+")";
        ConnectMySQL.main(req);
    }

    public void Deinscrire(){
        
    }
    
    public static ArrayList<ArrayList> getEnfants(){
    	String req = "SELECT * FROM enfant WHERE idResponsableLegal = "+id;
        ArrayList<ArrayList> enfants = ConnectMySQL.main(req);
        return enfants;
    }
    
    public static ArrayList getAllInformations() {
    	String requete = "SELECT * FROM responsablelegal where id = " + id;
        ArrayList<ArrayList> allInformations = ConnectMySQL.main(requete);
        System.out.println("allInformations : "+allInformations);
        return allInformations;
    }
    
}
