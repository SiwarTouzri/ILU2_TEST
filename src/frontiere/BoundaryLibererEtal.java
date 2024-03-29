package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		boolean vendeurReconnu;
		vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if( Boolean.parseBoolean(donneesEtal[0]) == true ) {
			String produit = donneesEtal[2];
			int quantiteInitial = Integer.parseInt(donneesEtal[3]);
			int quantiteVendu = Integer.parseInt(donneesEtal[4]);
			System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + "" + produit + ".\n");
			System.out.println("Au revoir " + nomVendeur+ " , passez une bonne journée.\n");	
		}
	}

}
}


