package pevryscolaireModel;

public class Session {
	public  String activite;
	public  String date;
	public  String heure;
	public  String lieu;
	
	
	public Session(String activite, String date, String heure, String lieu) {
		this.activite = activite;
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        
	}
	
    public String getDate() {
        return date;
    }
    
    public String setDate(String Date) {
    	return this.date = Date;
    }

    public String getHeure() {
        return heure;
    }
    public String setHeure(String Heure) {
    	return this.heure = Heure;
    }
    
    public String getLieu() {
        return lieu;
    }
    public String setLieu(String Lieu) {
    	return this.lieu = Lieu;
    }
    
    public String getActivite() {
        return activite;
    }
    public String setActivite(String Activite) {
    	return this.activite = Activite;
    }
}
