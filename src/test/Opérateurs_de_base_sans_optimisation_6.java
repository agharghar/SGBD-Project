/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */

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

		

		

		
		/**
		 * 6- Codez danssgbd.impl la classe JointureS qui implémente 
		 * une jointure en utilisant la technique de SortMergeJoin. 
		 * Donnez des programmes exemple.
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	2 :		numéro d'attribut de la table 1
		   * 	1 : 	numéro d'attribut de la table 2
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant algo sort Merge
		   */ 
		
		Jointure jointure = new JointureS() ; 
		Nuplet[] res = jointure.jointure(tab1, tab2, 2, 1);
		
		for(Nuplet n : res)
			System.out.println(n.toString());

		
	}
}
