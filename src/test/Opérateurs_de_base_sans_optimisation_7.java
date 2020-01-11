package test;

import java.util.Iterator;

import impl.JointureBl;
import impl.NupletInt;
import impl.ProjectionImpl;
import impl.RestrictionInt;
import impl.TableInt;
import operateurs.Jointure;
import operateurs.PipeLine;
import operateurs.Projection;
import operateurs.Restriction;
import stockage.Nuplet;
import stockage.Table;

public class Opérateurs_de_base_sans_optimisation_7 {

	public static final int datasetSize = 100;
	public static final int nupletSize = 10;

	public static void main(String[] args){
		
		// Génération des données
		Nuplet[] tab = new NupletInt[datasetSize];
		Nuplet[] tab1 = new NupletInt[datasetSize];
		for(int i=0;i<datasetSize;i++){
			tab[i] = new NupletInt(nupletSize);
			tab1[i] = new NupletInt(nupletSize);
			for(int j=0;j<nupletSize;j++){
				tab[i].putAtt(j, (byte)(j+i));
				tab1[i].putAtt(j, (byte)(j+i));
			}
		}

		// Impl	émentation avec Table
		
		System.out.println("------------------------------------------------");	
		System.out.println("Création d'une table");
		TableInt t = new TableInt("C:/temp/table2", nupletSize);
		
		

		
		
		System.out.println("------------------------------------------------");	
		
		PipeLine pipelineFullScan =  t.pipeLine();
		pipelineFullScan.open();
		for(int i=0 ; i<50; i++) {
			System.out.println(pipelineFullScan.next());
		}
		System.out.println("------------------------------------------------");	
		pipelineFullScan.open();
		
		for(int i=0 ; i<50; i++) {
			System.out.println(pipelineFullScan.next());
		}
			
		System.out.println("------------------------------------------------");	

		
		int tabInt[] = {0,1,2} ; 
		PipeLine pipeLineProjection = new ProjectionImpl().pipeLine(tab, tabInt);
		
		while(pipeLineProjection.hasNext())
			System.out.println(pipeLineProjection.next());


		System.out.println("Start compare equal");
		Restriction restrictionInt = new RestrictionInt() ; 
		
		PipeLine pipeLineEgalite = restrictionInt.pipeLineEgalite(tab, 4, (byte)5);
		pipeLineEgalite.open();
		while(pipeLineEgalite.hasNext())
			System.out.println(pipeLineEgalite.next());
		System.out.println("END compare equal");
		
		System.out.println("Start compare sup or equ");
		System.out.println("----------------------------------------------------");
		PipeLine pipeLineSup = restrictionInt.pipeLineSup(tab, 2, (byte)6);
		pipeLineSup.open();
		while(pipeLineSup.hasNext())
			System.out.println(pipeLineSup.next());
		System.out.println("END compare sup or equ");
		System.out.println("----------------------------------------------------");
		
		System.out.println("Start compare Inf or equ");
		System.out.println("----------------------------------------------------");
		PipeLine pipeLineInf = restrictionInt.pipeLineInf(tab, 3, (byte)5);
		pipeLineInf.open();
		while(pipeLineInf.hasNext())
			System.out.println(pipeLineInf.next());
		System.out.println("END compare Inf or equ");
		System.out.println("----------------------------------------------------");
		
		// 3 eme question 
		

		System.out.println("start Join Bl");
		PipeLine pipeLineJointureBl = new JointureBl().pipeLine(tab, tab1, 0, 1);
		pipeLineJointureBl.open();
		while(pipeLineJointureBl.hasNext())
			System.out.println(pipeLineJointureBl.next());
		System.out.println("END Join Bl");
		System.out.println("----------------------------------------------------");
		

	}

}
