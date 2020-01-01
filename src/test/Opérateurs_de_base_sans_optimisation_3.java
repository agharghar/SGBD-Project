package test;


import impl.NupletInt;
import impl.ProjectionImpl;
import operateurs.Projection;
import stockage.Nuplet;


public class Opérateurs_de_base_sans_optimisation_3 {

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

		Projection projection = new ProjectionImpl();
		int tabInt[] = {0,5,9} ; 
		Nuplet[] res = projection.project(tab1, tabInt);
		
		for(Nuplet n : res) {
			System.out.println(n.toString());
		}

		
	}

}
