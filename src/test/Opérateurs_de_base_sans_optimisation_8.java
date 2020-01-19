/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */

package test;

import impl.NonDenseIndex;
import impl.NupletInt;
import impl.RestrictionInt;
import impl.TableInt;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_8 {
	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) {

		// Génération des données
				Nuplet[] tab = new NupletInt[datasetSize];
				for(int i=0;i<datasetSize;i++){
					tab[i] = new NupletInt(nupletSize);
					for(int j=0;j<nupletSize;j++){
						tab[i].putAtt(j, (byte)(i+j));
					}
				}

				
				// Implémentation avec Table
				
				System.out.println("------------------------------------------------");	
				System.out.println("Création d'une table");
				Table t = new TableInt("C:/temp/table2", nupletSize);
				for(int i=0;i<datasetSize;i++){
					t.put(tab[i]);
					}
				
				/**
				 * 8- Rajoutez des index Non Dense
				 * 
				 */
				
				/**
				   * 
				   * @param 
				   * 	tab : table des données
				   * 	2 : numéro d'attribut à indexer
				   * @return Nuplet[]
				   * @exception No Exeption
				   * 
				   * Indexer une table avec un objet qui représente un index 
				   */
				
				System.out.println("---------------------");
				NonDenseIndex nupletIndex = new NonDenseIndex(t.fullScan(),2) ;
				
				for(Nuplet nuplet : t.fullScan()) {
					System.out.println(nuplet);
				}
				
				System.out.println("---------------------");
				for( Nuplet nuplet : nupletIndex.index(3))
					System.out.println(nuplet);
				/*
				 * Comparaison temps de réponse index et restriction : 
				 * 
				 */
				
				RestrictionInt restrictionInt = new RestrictionInt() ; 
				
				double startTimeIndex = System.nanoTime();
				nupletIndex.index(3) ; 
				double endTimeIndex = System.nanoTime();
				double startTimeRestriction = System.nanoTime();
				restrictionInt.egalite(tab, 0, (byte)3);
				double endTimeRestriction = System.nanoTime();
				System.out.println("Index Response Time :"+(endTimeIndex - startTimeIndex ));
				System.out.println("Restriction Response Time : "+(endTimeRestriction - startTimeRestriction));
				

	}

}
