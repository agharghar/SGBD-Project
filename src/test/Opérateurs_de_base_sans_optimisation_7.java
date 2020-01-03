package test;

import java.util.Iterator;

import impl.NupletInt;
import impl.ProjectionImpl;
import impl.TableInt;
import operateurs.PipeLine;
import operateurs.Projection;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_7 {

	public static final int datasetSize = 100;
	public static final int nupletSize = 10;

	public static void main(String[] args){
		
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
		TableInt t = new TableInt("C:/temp/table2", nupletSize);
		
		
		for(int i=0;i<datasetSize;i++){
			t.put(tab[i]);
			}

		
		System.out.println("------------------------------------------------");	
	/*	
		PipeLine pipelineFullScan =  t.pipeLine();
		pipeline.open();
		for(int i=0 ; i<50; i++) {
			System.out.println(pipelineFullScan.next());
		}
		System.out.println("------------------------------------------------");	
		pipeline.open();
		
		for(int i=0 ; i<50; i++) {
			System.out.println(pipelineFullScan.next());
		}
			
		*/

		int tabInt[] = {0,1,2} ; 
		PipeLine pipeLineProjection = new ProjectionImpl().pipeLine(tab, tabInt);
		
//		while(pipeLineProjection.hasNext())
//			System.out.println(pipeLineProjection.next());



	}

}
