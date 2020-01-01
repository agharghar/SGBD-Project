package test;



	import impl.JointureBl;
	import impl.JointureH;
	import impl.NupletInt;
	import impl.RestrictionInt;
	import impl.TableInt;
	import operateurs.Jointure;
	import stockage.Nuplet;
	import stockage.Table;

	public class Mises_à_jour_9 {

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
			
			
			
			
				t.delete(tab1[99], 0, (byte)99);
				t.update(tab1[0], 0, (byte)0, (byte)7);
				t.insert(tab1[0]);
				t.insert(tab1[0]);
	
			
			System.out.println("Lecture d'une table");
			for(Nuplet nuplet : t.fullScan()){
				System.out.println(nuplet.toString());
				}
				
			

		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
