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
import impl.NupletInt;
import impl.RestrictionInt;
import impl.TableInt;
import operateurs.Jointure;
import stockage.Nuplet;
import stockage.Table;

public class Op�rateurs_de_base_sans_optimisation_4 {

	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) {
		
		// G�n�ration des donn�es
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
		 * 4-Codez dans sgbd.impl la classe JointureBI qui impl�mente une jointure sur deux ensembles
		 * de Nuplet[] sur les attributs  att1 de  t1 et att2 de  t2 en utilisant  un algorithme
		 * basique  de  type doubles boucles imbriqu�es.
		 * 
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des donn�es
		   * 	tab2 :	table des donn�es
		   * 	0 :		num�ro d'attribut de la table 1
		   * 	2 : 	num�ro d'attribut de la table 2
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab1.att2 
		   */
		 
		
		Jointure jointure = new JointureBl() ; 
		Nuplet[] res = jointure.jointure(tab1, tab2, 0, 2);
		
		for(Nuplet n : res)
			System.out.println(n.toString());

		
		
	}

}

















