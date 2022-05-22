package pevryscolaireModel;

import java.util.ArrayList;

public class Periscolaire extends Personne{
	
	

    public void CreerActivite(String nom, String emplacement, String idEmp){
        String reqAct = "INSERT INTO activites (nom, lieu, idPeriscolaire) VALUES ('"+ nom + "'','"+ emplacement +"'','" + idEmp +"'')";
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
