package pevryscolaireModel;

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

    public void CreerSession(String date, String heure, String lieu, Integer idActivite){
        String reqSes = "INSERT INTO session (date, heure, lieu, idActivite) VALUES ('"+ date + "','"+ heure +"','" + lieu +"','"+ idActivite +"')";
        try{
            ConnectMySQL.main(reqSes);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
    }

    public void ModifierActivite(){

    }

    public void ConsulterSession(Integer idActivite){

        String reqSes = "SELECT * FROM session WHERE idActivite = '"+idActivite+"'";
        try{
            ArrayList result = ConnectMySQL.main(reqSes);
            System.out.println(result);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
    }

    public void ModifierSession(){

    }

    public void SupprimerSession(Integer idSession){
        String reqSes = "DELETE FROM session WHERE Id ='"+ idSession +"';"; 
        try{
            ConnectMySQL.main(reqSes);
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
    }
}
