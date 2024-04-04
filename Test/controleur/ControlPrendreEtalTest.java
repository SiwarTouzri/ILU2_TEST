package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
	}
	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite= new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testresteEtals() {
		ControlVerifierIdentite controlVerifierIdentite= new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		assertEquals(true,controlPrendreEtal.resteEtals());
		Gaulois bonemine = new Gaulois("Bonemine",10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "tissu", 10);
		assertEquals(false,controlPrendreEtal.resteEtals());
		
	}
	@Test
	void testprendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite= new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		Gaulois bonemine = new Gaulois("Bonemine",10);
		village.ajouterHabitant(bonemine);
		assertEquals(0,controlPrendreEtal.prendreEtal("Bonemine","tissu",10));
	}
	
	@Test
	void testverifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite= new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(controlVerifierIdentite,village);
		Gaulois bonemine = new Gaulois("Bonemine",10);
		village.ajouterHabitant(bonemine);
		assertEquals(true,controlPrendreEtal.verifierIdentite("Bonemine"));
		assertEquals(false,controlPrendreEtal.verifierIdentite("Mauvaisemine"));
	}

}