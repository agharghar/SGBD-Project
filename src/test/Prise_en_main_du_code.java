package test;

import impl.NupletInt;
import impl.TableInt;
import stockage.Nuplet;
import stockage.Table;

public class Prise_en_main_du_code {

	
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
		
		
		//Prise en main du code 1- Test Full Scan 
		System.out.println("Start Test Full Scan");
		for(Nuplet n : t.fullScan()){
			
			System.out.println(n.toString()+'\n');
		}
		
		System.out.println("END Test Full Scan");
		
	
		
		
	}

}
