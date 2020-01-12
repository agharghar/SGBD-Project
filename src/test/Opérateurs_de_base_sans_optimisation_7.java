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
import impl.JointureS;
import impl.NupletInt;
import impl.ProjectionImpl;
import impl.RestrictionInt;
import impl.TableInt;
import operateurs.PipeLine;
import operateurs.Restriction;
import stockage.Nuplet;

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
		for(int i=0;i<datasetSize;i++){
			t.put(tab[i]);
			}
		
		

		/**
		 * 7- Modifiez les opérateurs de d’accès (e.g. fullscan()) et les opérateurs de l’algèbre relationnelle 
		 * (projection, restriction, et jointure)de telle sorte qu’ils puissent fonctionner en pipeline. 
		 * Dans ce cas, vous n’allez plus implémenter les interfaces de sgbd.operateurs. 
		 * Vous pourrez par exemple créer une nouvelle classegénérique Requeteavec les méthodes open() et fetch() (ou next()).
		 * Vous devrez également réfléchir à la possibilité de construire une Requete à partir de plusieurs autres Requetes.
		 */
		
		/**
		   * 
		   * @param No param
		   * @return Nuplet
		   * @exception 
		   * 	si on applle pas open() : NoSuchElementException
		   * 
		   *  iteration sur chaque els de la table est retourne un par un 
		   */
		
		
		System.out.println("------------------------------------------------");	
		System.out.println("Start Full Scan");
		PipeLine pipelineFullScan =  t.pipeLine();
		pipelineFullScan.open();
		while(pipelineFullScan.hasNext())
			System.out.println(pipelineFullScan.next());
		
		System.out.println("End Full Scan");
		System.out.println("------------------------------------------------");	

		/**
		   * 
		   * @param 
		   * 	tab : table des données
		   * 	tabInt : table des entiers
		   * 	
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * projette les Nuplets sur un sous ensemble d'attributs définis par atts. 
		   * Par exemple si atts = {1,3,4} on gardera les attributs 1 3 et 4 de l'ensemble des Nuplets.
		   * 
		   * iteration sur chaque els résultat est retourne un par un 
		   * 
		   */
		
		
		System.out.println("------------------------------------------------");	
		System.out.println("Start Projection");
		
		int tabInt[] = {0,1,2} ; 
		PipeLine pipeLineProjection = new ProjectionImpl().pipeLine(tab, tabInt);
		
		while(pipeLineProjection.hasNext())
			System.out.println(pipeLineProjection.next());

		System.out.println("End Projection");
		System.out.println("------------------------------------------------");

		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value == value ) ? 
		   * 	si true il retourne un nuplet
		   * 
		   */
		
		System.out.println("------------------------------------------------");
		System.out.println("Start compare equal");
		Restriction restrictionInt = new RestrictionInt() ; 
		PipeLine pipeLineEgalite = restrictionInt.pipeLineEgalite(tab, 4, (byte)5);
		pipeLineEgalite.open();
		while(pipeLineEgalite.hasNext())
			System.out.println(pipeLineEgalite.next());
		System.out.println("END compare equal");
		System.out.println("------------------------------------------------");
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value >= value ) ? 
		   * 	si true il retourne un nuplet
		   * 
		   */
		
		System.out.println("------------------------------------------------");
		System.out.println("Start compare sup or equ");
		PipeLine pipeLineSup = restrictionInt.pipeLineSup(tab, 2, (byte)6);
		pipeLineSup.open();
		while(pipeLineSup.hasNext())
			System.out.println(pipeLineSup.next());
		System.out.println("END compare sup or equ");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value <= value ) ? 
		   * 	si true il retourne un nuplet
		   * 
		   */
		System.out.println("------------------------------------------------");
		System.out.println("Start compare Inf or equ");
		PipeLine pipeLineInf = restrictionInt.pipeLineInf(tab, 3, (byte)5);
		pipeLineInf.open();
		while(pipeLineInf.hasNext())
			System.out.println(pipeLineInf.next());
		System.out.println("END compare Inf or equ");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	tab : 	table des données
		   * 	tab1 :	table des données
		   * 	5 :		numéro d'attribut de la table 1
		   * 	9 : 	numéro d'attribut de la table 2
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab1.att2 retourne un nuplet
		   */
		System.out.println("----------------------------------------------------");
		System.out.println("start Join Bl");
		PipeLine pipeLineJointureBl = new JointureBl().pipeLine(tab, tab1, 5, 9);
		pipeLineJointureBl.open();
		while(pipeLineJointureBl.hasNext())
			System.out.println(pipeLineJointureBl.next());
		System.out.println("END Join Bl");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	tab : 	table des données
		   * 	tab1 :	table des données
		   * 	5 :		numéro d'attribut de la table 1
		   * 	9 : 	numéro d'attribut de la table 2
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant hash(tab2.att2) in ? hash_table(tab1,att1)
		   * 
		   */ 
		
		System.out.println("----------------------------------------------------");
		System.out.println("start Join H");
		PipeLine pipeLineJointureH = new JointureH().pipeLine(tab, tab1, 5, 9);
		pipeLineJointureH.open();
		while(pipeLineJointureH.hasNext())
			System.out.println(pipeLineJointureH.next());
		System.out.println("END Join H");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	tab : 	table des données
		   * 	tab1 :	table des données
		   * 	5 :		numéro d'attribut de la table 1
		   * 	9 : 	numéro d'attribut de la table 2
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant algo sort Merge
		   */ 
		System.out.println("----------------------------------------------------");
		System.out.println("start Join S");
		PipeLine pipeLineJointureS = new JointureS().pipeLine(tab, tab1, 5, 9);
		pipeLineJointureS.open();
		while(pipeLineJointureS.hasNext())
			System.out.println(pipeLineJointureS.next());
		System.out.println("END Join S");
		System.out.println("----------------------------------------------------");
		

	}

}
