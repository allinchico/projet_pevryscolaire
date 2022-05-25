package pevryscolaireModel;
/*-----------------------Notes-----------------------
Cette version de la connexion a†la base de donnees est rudimentaire,
il faudrait faire en sorte de n'avoir qu'une bdd commune au lieu de 3 bdd locale
De plus le systeme de prise en compte des divers type de requete est plus que sommaire
Il faudrait aussi rendre plus claire le code, par l'utilisation de commentaires notamment
*/

import java.sql.*;
import java.util.ArrayList;
public class ConnectMySQL
{
	public static ArrayList<ArrayList> main(String req)
	{
		ArrayList<ArrayList> tabRequete = new ArrayList<ArrayList>();
		try
		{
			
			//etape 1: charger la classe de driver
			Class.forName("com.mysql.jdbc.Driver");

			//etape 2: creer l'objet de connexion
			Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/pevryscolaire_bdd", "root", "");

			//etape 3: creer l'objet statement 
			Statement stmt = conn.createStatement();
			
			
			//prise en compte des requetes de type  "inserts"
			if(req.startsWith("SELECT")){
				ResultSet res = stmt.executeQuery(req);

			//etape 4: ex√©cuter la requete
			ResultSetMetaData loRsmd = res.getMetaData(); //Obtenir les infos sur le result set
    		int nbColonnes = loRsmd.getColumnCount(); //Obtenir le nombre de colonnes

    		while (res.next()) { //On parcours chaque resultat du result set
				ArrayList<String> tabLigne = new ArrayList<String>(); 
        			for (int i = 1; i <= nbColonnes ; i++) {
						tabLigne.add(res.getString(i));
    			}
				tabRequete.add(tabLigne);
			}
			System.out.println(tabRequete);
		}
		else{
			Integer	res = stmt.executeUpdate(req);
		}
		//etape 5: fermez l'objet de connexion
		conn.close();
		System.out.println("Requete effectuÈe");
		
	}
		//Prise en compte des erreurs potentiels
		catch(Exception e){ 
			System.out.println(e);
		}
		return tabRequete;
		
	}
}


