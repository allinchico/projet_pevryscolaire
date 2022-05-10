package pevryscolaireModel;

import java.util.ArrayList;

public class Personne {
    public String nom, prenom, sexe;
    public Integer dateNaissance;
    public String age; //faire calcul age par rapport à la date de naissance

    public static void ConsulterActivite(){
        String requete = "SELECT * FROM activites" ;
        ArrayList<ArrayList> allActivite = ConnectMySQL.main(requete);
        System.out.println(allActivite);
    }

    public static ArrayList<ArrayList> seConnecter(String login, String password){
        String reqUse = "SELECT id FROM utilisateur WHERE login = '"+login+"' AND password = '"+password+"';";
        System.out.println(reqUse);
        return ConnectMySQL.main(reqUse);
    }
}
