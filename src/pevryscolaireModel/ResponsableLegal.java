package pevryscolaireModel;

public class ResponsableLegal extends Personne {
    public String salaire, statutMaritale;

    public static void Inscrire(Integer idSession, Integer idEnfant){
        String req = "INSERT INTO enfant_session VALUES ("+idEnfant+", "+idSession+")";
        ConnectMySQL.main(req);
    }

    public void Deinscrire(){
        
    }
    
}
