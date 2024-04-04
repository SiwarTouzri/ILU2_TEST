package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager= new ControlEmmenager(village);

	}
	
	@Test
    void testConstructeur() {
        ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
        assertNotNull(controlVerifierIdentite);
    }

	 @Test
	    void testVerifierIdentite_HabitantExiste() {
		 	ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
	        controlEmmenager.ajouterGaulois("Gaulois1", 10);
	        assertTrue(controlVerifierIdentite.verifierIdentite("Gaulois1"));
	    }

	    @Test
	    void testVerifierIdentite_HabitantNExistePas() {
	    	ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
	        assertFalse(controlVerifierIdentite.verifierIdentite("Gaulois2"));
	    }

}