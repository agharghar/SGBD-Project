package test;

import java.util.Iterator;

import impl.Agregats;
import impl.AvgInt;
import impl.CountInt;
import impl.MaxInt;
import impl.MinInt;
import impl.NupletInt;
import impl.SumInt;
import impl.TableInt;
import operateurs.Avg;
import operateurs.Count;
import operateurs.Max;
import operateurs.Min;
import operateurs.Sum;
import stockage.Nuplet;
import stockage.Table;

public class Agrégats_10 {

	public static final int datasetSize = 100;
	public static final int nupletSize = 10;
	
	public static void main(String[] args) {
		
		// Génération des données
		Nuplet[] tab1 = new NupletInt[datasetSize];
		for(int i=0;i<datasetSize;i++){
			tab1[i] = new NupletInt(nupletSize);
			for(int j=0;j<nupletSize;j++){
				tab1[i].putAtt(j, (byte)(j+i));
			}
		}

		
		// Implémentation avec Table
		
		System.out.println("------------------------------------------------");	
		System.out.println("Création d'une table");
		Table t = new TableInt("C:/temp/table2", nupletSize);
		
		
		for(int i=0;i<datasetSize;i++){
			t.put(tab1[i]);
			}
		
		System.out.println("Lecture d'une table");
		for(Nuplet nuplet : t.fullScan()){
			System.out.println(nuplet.toString());
			}
		
		
		Agregats agregats = new Agregats();
		agregats.Agregats_req(tab1, 2);
		


	}

}
