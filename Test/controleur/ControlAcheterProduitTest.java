package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

class ControlAcheterProduitTest {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlAcheterProduit controlAcheterProduit;
    private Gaulois acheteur;

    @BeforeEach
    public void initialiserSituation() {
        System.out.println("Initialisation...");
        village = new Village("Le village gaulois", 10, 5);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
        acheteur = new Gaulois("Ast�rix", 10);
    }

    @Test
    void testVerfierIdentite() {
        assertTrue(controlAcheterProduit.verifierIdentite(acheteur.getNom()));
        assertFalse(controlAcheterProduit.verifierIdentite("NonExistant"));
    }

    @Test
    void testTrouverVendeurProduit() {
        village.ajouterEtal(new Etal("Panoramix", "Potion magique", 10));
        Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurProduit("Potion magique");
        assertNotNull(vendeurs);
        assertEquals(1, vendeurs.length);
        assertEquals("Panoramix", vendeurs[0].getNom());
    }

    @Test
    void testTrouverEtalVendeur() {
        village.ajouterEtal(new Etal("Panoramix", "Potion magique", 10));
        Etal etal = controlAcheterProduit.trouverEtalVendeur("Panoramix");
        assertNotNull(etal);
        assertEquals("Potion magique", etal.getProduit());
    }

    // Remarque : Pour le test de la m�thode acheterProduit, il serait id�al
    // d'utiliser des mocks ou des doubles pour simuler le comportement des
    // objets Etal afin d'isoler le test. Cependant, cela d�passe la port�e de
    // cet exemple basique.
}
