/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */

package test;

import java.util.Random;

import impl.NonDenseIndex;
import impl.NupletInt;
import impl.SerialisableNuplet;
import impl.TableInt;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_10 {
	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		// Génération des données
				Nuplet[] tab = new NupletInt[datasetSize];
				for(int i=0;i<datasetSize;i++){
					tab[i] = new NupletInt(nupletSize);
					for(int j=0;j<nupletSize;j++){
						tab[i].putAtt(j, (byte)(j+i));
					}
				}
				

				
				// Implémentation avec Table
				
				System.out.println("------------------------------------------------");	
				System.out.println("Création d'une table");
				Table t = new TableInt("C:/temp/table2", nupletSize);
				for(int i=0;i<datasetSize;i++){
					t.put(tab[i]);
					}
				
				// Lecture de la table
				System.out.println("Lecture d'une table");
				for(Nuplet nuplet : t.fullScan()){
					System.out.println(nuplet.toString());
					}
				
				System.out.println("-----------------------------------");
				
				/*
				 * Normal Operation Demo
				 * 
				 */
				
				SerialisableNuplet serialisableNuplet = new SerialisableNuplet() ; 
				/**
				   * 
				   * @param 
				   * 	tab1[1] : 	Nuplet 
				   * @return void
				   * @exception No Exeption			
				   * 
				   *  Crée un fichier nomée hashCodeNuplet().txt et met la valeur true .
				   *  	checkTrue(fileName);
				   *  	si deja true :
				   *  		thread.sleep(rand_time)
				   *  	else : 
				   *  		put_in_file(true)
				   */
				
				serialisableNuplet.preLock(tab[0]);
				t.update(tab[0], 0, (byte)0, (byte)99);
				
				System.out.println("-----------------------------------");
				System.out.println("Lecture d'une table");
				for(Nuplet nuplet : t.fullScan()){
					System.out.println(nuplet.toString());
					}
				serialisableNuplet.afterLock(tab[0]);

				/**
				 * dead lock :)
				 * 
				 */
				
				System.out.println("-----------");
				Nuplet tab0Copy = tab[0] ;
				Nuplet tab1Copy = tab[1];
				
				serialisableNuplet.preLock(tab[0]);
				serialisableNuplet.preLock(tab[1]);

				t.update(tab[0], 0, (byte)0, (byte)99);
				t.update(tab[1], 0, (byte)1, (byte)11);
				System.out.println("dead Lock ici ==> veuillez lire les COMMENTRAIRES!! <==");
				
				/*
				 * Solution : 
				 * 
				 * 	F5 et supprimer les fichiers . 
				 * 	decomment le code :
				 *
				 */
				
//				serialisableNuplet.afterLock(tab0Copy);
//				serialisableNuplet.afterLock(tab1Copy);

				
				serialisableNuplet.preLock(tab0Copy);
				serialisableNuplet.preLock(tab1Copy);
				
				t.update(tab0Copy, 0, (byte)99, (byte)88);
				t.update(tab1Copy, 0, (byte)11, (byte)22);
				
				serialisableNuplet.afterLock(tab[0]);
				serialisableNuplet.afterLock(tab[1]);
				
				serialisableNuplet.afterLock(tab0Copy);
				serialisableNuplet.afterLock(tab1Copy);
				System.out.println("-----------------------------------");
				for(Nuplet nuplet : t.fullScan()){
					System.out.println(nuplet);
					}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
