package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer

		if ( !controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut être un habitant du village pour commercer ici.\n");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + ",je vais regarder si je peux trouver un étal.\n");
			if ( !controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur + "je n'ai plus d'étal qui ne soit pas déjà occupé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		String produit = " ";
		int nbProduit;
		int numeroEtal = -1;
		StringBuilder question = new StringBuilder();
		
		question.append("C'est parfait, il me reste un étal pour vous !\n");
		question.append("Il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaitez-vous vendre ?\n");
		System.out.println(question.toString());
		produit = scan.next();
		
		nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numeroEtal+1) + ".");
		}
	}
}
