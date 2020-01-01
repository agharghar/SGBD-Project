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
		
		// 2 èmè question 
		System.out.println("Start compare equal");
		RestrictionInt restrictionInt = new RestrictionInt() ; 
		Nuplet n [] = restrictionInt.egalite(tab, 0, (byte)3);
		for(Nuplet nuplet : n )
			System.out.println(nuplet.toString());
		System.out.println("END compare equal");
		
		
		
		System.out.println("Start compare sup or equ");
		System.out.println("----------------------------------------------------");
		Nuplet n2 [] = restrictionInt.superieur(tab, 0, (byte)3);
		for(Nuplet nuplet : n2 )
			System.out.println(nuplet.toString());
		
		System.out.println("END compare sup or equ");
		
	
		System.out.println("Start compare INF or equ");
		System.out.println("----------------------------------------------------");
		Nuplet n3 [] = restrictionInt.inferieur(tab, 0, (byte)3);
		for(Nuplet nuplet : n3 )
			System.out.println(nuplet.toString());
		
		System.out.println("END compare INF or equ");
		
	}

}
