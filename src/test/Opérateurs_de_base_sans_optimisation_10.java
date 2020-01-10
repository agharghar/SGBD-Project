package test;

import java.util.Random;

import impl.NupletIndex;
import impl.NupletInt;
import impl.TableInt;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_10 {
	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) {

		Random random = new Random();
		// Génération des données
				Nuplet[] tab = new NupletInt[datasetSize];
				for(int i=0;i<datasetSize;i++){
					tab[i] = new NupletInt(nupletSize);
					for(int j=0;j<nupletSize;j++){
						tab[i].putAtt(j, (byte)(j+i+random.nextInt(10)));
					}
				}

				
				// Implémentation avec Table
				
				System.out.println("------------------------------------------------");	
				System.out.println("Création d'une table");
				Table t = new TableInt("C:/temp/table2", nupletSize);
				for(int i=0;i<datasetSize;i++){
					t.put(tab[i]);
					}
				
				
				NupletIndex nupletIndex = new NupletIndex() ;
				for( Nuplet nuplet : nupletIndex.index(t.fullScan(), 1))
					System.out.println(nuplet);
		
	}

}
