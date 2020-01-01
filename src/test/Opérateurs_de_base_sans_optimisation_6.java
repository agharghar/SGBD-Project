package test;

import impl.JointureBl;
import impl.JointureH;
import impl.JointureS;
import impl.NupletInt;
import impl.RestrictionInt;
import impl.TableInt;
import operateurs.Jointure;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_6 {

	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) {
		
		// Génération des données
		Nuplet[] tab1 = new NupletInt[datasetSize];
		Nuplet[] tab2 = new NupletInt[datasetSize];
		for(int i=0;i<datasetSize;i++){
			tab1[i] = new NupletInt(nupletSize);
			tab2[i] = new NupletInt(nupletSize);
			for(int j=0;j<nupletSize;j++){
				tab1[i].putAtt(j, (byte)(j+i));
				tab2[i].putAtt(j, (byte)(j+i));
			}
		}

		

		

		
		// 3 eme question 
		
		Jointure jointure = new JointureS() ; 
		Nuplet[] res = jointure.jointure(tab1, tab2, 0, 1);
		
		for(Nuplet n : res)
			System.out.println(n.toString());

		
	}
}
