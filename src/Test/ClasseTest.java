package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pevryscolaireModel.Personne;

class ClasseTest {

	@Test
	void test() {
		ArrayList testArray = Personne.ConsulterActivite();
		assertTrue(!Personne.ConsulterActivite().isEmpty());
        //assertTrue(Personne.ConsulterActivite().isEmpty());
	}

}
