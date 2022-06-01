package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pevryscolaireModel.Personne;

class ClasseTestConnection {

	@Test
	public void Test(){
		//On vérifie que si l'utilisateur entre des identifiants correct, il se connecte, et que des identifiants incorrects ne permettent pas la connexion
		//En théorie, la méthode seConnecter prend comme arguments le nom et le mot de passe de l'utilisateur, et renvoie un tableau comportant les informations de l'utilisateur si les
		//paramètres de la fonction sont bien présent en base, sinon, la fonction renvoie un tableau vide. Ici, l'utilisateur John (mot de passe : miage) existe, et l'utilisateur test
		//n'existe pas
		
		//Ce test doit être validé
		assertTrue(!Personne.seConnecter("John", "miage").isEmpty());
		//celui ci ne devrais pas être validé
        assertTrue(!Personne.seConnecter("test", "1234").isEmpty());
	}
	
	

}
