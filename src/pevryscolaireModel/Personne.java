package pevryscolaireModel;

import java.util.ArrayList;

public class Personne {
    public static String id;
	public static String nom;
	public static String prenom;
	public static String sexe;
	public static String statutMaritale;
    public static String dateDeNaissance;
    public static String age; //faire calcul age par rapport à la date de naissance
    public static String salaire;
    
   
    

    public static ArrayList ConsulterActivite(){
        String requete = "SELECT * FROM activites" ;
        ArrayList<ArrayList> allActivite = ConnectMySQL.main(requete);
        System.out.println(allActivite);
        return allActivite;
    }
    
    public static ArrayList verifierStatutPeriscolaire(String idUser) {
    	String requete = "SELECT id from utilisateur where id in (Select id from periscolaire where idUser = "+idUser+")";
    	ArrayList allPeriscolaire = ConnectMySQL.main(requete);
        System.out.println(allPeriscolaire);
        return allPeriscolaire;
    }
    
    public static ArrayList ConsulterSession(String activite){

        String reqSes = "SELECT * FROM session WHERE idActivite = '"+activite+"'";
        ArrayList result = null;
        try{
            result = ConnectMySQL.main(reqSes);
            System.out.println(result);
            
        }
        catch(Exception e){
            System.out.println("impossible d'éxécuter la requête : " + reqSes + "");
        }
        return result;
    }
    
    public static ArrayList verifierStatutResponsable(String idUser) {
    	String requete = "SELECT id from utilisateur where id in (Select id from responsablelegal where idUser = "+idUser+")";
    	ArrayList allResponsable = ConnectMySQL.main(requete);
        System.out.println("resultat requ�te : "+allResponsable);
        return allResponsable;
    }

    public static ArrayList<ArrayList> seConnecter(String login, String password){
        String reqUse = "SELECT id, idPersonne FROM utilisateur WHERE login = '"+login+"' AND password = '"+password+"';";
        System.out.println(reqUse);
        return ConnectMySQL.main(reqUse);
    }
}
