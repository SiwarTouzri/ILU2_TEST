package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
	}
	
	@Test
	void testControlTrouverEtalVendeur(){
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void trouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertEquals(null,controlTrouverEtalVendeur.trouverEtalVendeur("Existe pas"));
		Gaulois bonemine = new Gaulois("Bonemine",10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "tissu", 10);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"));
	}

}