/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */


package test;

import impl.NupletInt;
import impl.RestrictionInt;
import impl.TableInt;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_2 {

	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) {
		
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
		
		/**
		   * 2- Codez dans sgbd.impl la classe RestrictionInt qui implémente la classe sgbd.operateurs.
		   * Restriction et qui travaille sur des NupletInt. 
		   * Proposez un programme Main qui démontre que votre code fonctionne.
		   * 
		   */
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet[].
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value == value ) ? 
		   * 	si true il retourne l'ensemble des nuplets
		   * 
		   */
		System.out.println("----------------------------------------------------");
		
		System.out.println("Start compare equal");
		RestrictionInt restrictionInt = new RestrictionInt() ; 
		Nuplet n [] = restrictionInt.egalite(tab, 0, (byte)20);
		for(Nuplet nuplet : n )
			System.out.println(nuplet.toString());
		System.out.println("END compare equal");
		
		
		
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet[].
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value >= value ) ? 
		   * 	si true il retourne l'ensemble des nuplets
		   * 
		   */
		
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("Start compare sup or equ");
		Nuplet n2 [] = restrictionInt.superieur(tab, 0, (byte)3);
		for(Nuplet nuplet : n2 )
			System.out.println(nuplet.toString());
		
		System.out.println("END compare sup or equ");
		
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet[].
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value <= value ) ? 
		   * 	si true il retourne l'ensemble des nuplets
		   * 
		   */
		
		System.out.println("----------------------------------------------------");
	
		System.out.println("Start compare INF or equ");
		Nuplet n3 [] = restrictionInt.inferieur(tab, 0, (byte)3);
		for(Nuplet nuplet : n3 )
			System.out.println(nuplet.toString());
		
		System.out.println("END compare INF or equ");
		
		System.out.println("----------------------------------------------------");
		
	}

}
