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
    
    

    public static ArrayList<ArrayList> seConnecter(String login, String password){
        String reqUse = "SELECT id FROM utilisateur WHERE login = '"+login+"' AND password = '"+password+"';";
        System.out.println(reqUse);
        return ConnectMySQL.main(reqUse);
    }
}
