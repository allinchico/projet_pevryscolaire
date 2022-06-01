package pevryscolaireModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Periscolaire extends Personne{
	
	public Periscolaire(String id) {
    	String requete = "SELECT * FROM periscolaire where id = "+id;
        ArrayList<ArrayList> allInformations = ConnectMySQL.main(requete);
        System.out.println("allInformations : "+allInformations);
        for(ArrayList tab : allInformations) {
        	System.out.println("Infos personne : "+tab);
        	this.id = tab.get(0).toString();
        	this.nom = tab.get(1).toString();
        	this.prenom = tab.get(2).toString();
        	this.dateDeNaissance = tab.get(3).toString();
        	this.sexe = tab.get(4).toString();     	
        }
    }

	
	public static ArrayList<ArrayList> getPeriscolaire() {
		String reqPeri = "SELECT nom, prenom FROM periscolaire";
        ArrayList<ArrayList> reponsablePeri = ConnectMySQL.main(reqPeri);
        return reponsablePeri;
	}
	
    public static void CreerActivite(String nom, String materiel, String idEmp){
        String reqAct = "INSERT INTO activites (nom, materiel, idPeriscolaire) VALUES ('"+ nom + "','"+ materiel +"','" + idEmp +"')";
        try{
            ConnectMySQL.main(reqAct);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqAct + "");
        }

    }

    public static void CreerSession(LocalDate localDate, String heure, String lieu, String string){
        String reqSes = "INSERT INTO session (date, heure, lieu, idActivite) VALUES ('"+ localDate + "','"+ heure +"','" + lieu +"','"+ string +"')";
        try{
            ConnectMySQL.main(reqSes);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
    }

    public void ModifierActivite(){

    }

    

    public void ModifierSession(){

    }
    
    
    public static void SupprimerActivite(String string){
        String reqSes = "DELETE FROM activites WHERE ID = "+string; 
        try{
        	ArrayList<ArrayList> tabSessions = Personne.ConsulterSession(string);
        	for(ArrayList ses : tabSessions) {
        		System.out.println(ses.get(5).toString());
        		ConnectMySQL.main("DELETE FROM enfant_session WHERE idSession ="+ses.get(0).toString());
        	}
        	ConnectMySQL.main("DELETE FROM session WHERE idActivite ="+string);
            ConnectMySQL.main(reqSes);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
    }

    public static void SupprimerSession(String string){
        String reqSes = "DELETE FROM session WHERE Id ='"+ string +"';"; 
        try{
        	ConnectMySQL.main("DELETE FROM enfant_session WHERE idSession ="+string);
            ConnectMySQL.main(reqSes);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
    }
}