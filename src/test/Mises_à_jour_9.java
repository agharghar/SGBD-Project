/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */

package test;



	import impl.JointureBl;
	import impl.JointureH;
	import impl.NupletInt;
	import impl.RestrictionInt;
	import impl.TableInt;
	import operateurs.Jointure;
	import stockage.Nuplet;
	import stockage.Table;

	public class Mises_�_jour_9 {

		public static final int datasetSize = 100;
		public static final int nupletSize = 10;
		
		public static void main(String[] args) {
			
			// G�n�ration des donn�es
			Nuplet[] tab1 = new NupletInt[datasetSize];
			for(int i=0;i<datasetSize;i++){
				tab1[i] = new NupletInt(nupletSize);
				for(int j=0;j<nupletSize;j++){
					tab1[i].putAtt(j, (byte)(j+i));
				}
			}

			
			// Impl�mentation avec Table
			
			System.out.println("------------------------------------------------");	
			System.out.println("Cr�ation d'une table");
			Table t = new TableInt("C:/temp/table2", nupletSize);
			
			
			for(int i=0;i<datasetSize;i++){
				t.put(tab1[i]);
				}
			
			/**
			 * 
			 * 9- Impl�mentez les m�thodes insert, delete et update dans la classe TableInt
			 * 
			 */
			
			
			/**
			   * 
			   * @param 
			   * 	tab1[99] : 	Nuplet 
			   * 	0 :		num�ro d'attribut de la table 1
			   * 	99 : 	value
			   * @return void
			   * @exception 
			   * 	si num�roAttribut > tab.length : ArrayIndexOutOfBoundsException			
			   * 
			   *  efface tous les Nuplets dont att est �gal � value
			   */
			
				System.out.println("------------------------------");
				System.out.println("Start delete");
				t.delete(tab1[99], 0, (byte)99);
				System.out.println("End  delete");
				System.out.println("------------------------------");
				
				
				/**
				   * 
				   * @param 
				   * 	tab1[0] : 	Nuplet 
				   * 	0 :		num�ro d'attribut de la table 1
				   * 	7 : 	value
				   * @return void
				   * @exception 
				   * 	si num�roAttribut > tab.length : ArrayIndexOutOfBoundsException			
				   * 
				   *  modifie tous les Nuplets dont att �tait �gal � oldValue et leur met la valeur newValue
				   */
				System.out.println("------------------------------");
				System.out.println("Start update");
				t.update(tab1[0], 0, (byte)0, (byte)7);
				System.out.println("End  update");
				System.out.println("------------------------------");
				
				/**
				   * 
				   * @param 
				   * 	tab1[0] : 	Nuplet 
				   * @return void
				   * @exception 
				   * 	si num�roAttribut > tab.length : ArrayIndexOutOfBoundsException			
				   * 
				   *  insert new nuplet
				   */
				System.out.println("------------------------------");
				System.out.println("Start insert");
				t.insert(tab1[0]);
				System.out.println("End  insert");
				System.out.println("------------------------------");
			
				
			// Lecture de la table
			System.out.println("Lecture d'une table");
			for(Nuplet nuplet : t.fullScan()){
				System.out.println(nuplet.toString());
				}
				
			

		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
