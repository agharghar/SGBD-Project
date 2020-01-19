/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */


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
		
		
		
		/**
		   * Prise en main du code 
		   * 0- Prenez connaissance et comprendre le code. En terme d’algèbre relationnelle, qu’est ce qu’un Nuplet[] ?
		   * 	Il s'agit d'une liste d'éléments finis. Dans notre cas, il représente une ligne dans une table 
		   * 
		   * Est-ce  que  dans  notre  code  les  données  restent  lorsque  le  programme  a  fini  de s’exécuter?
		   * 	Oui, il est enregister dans un fichier C:/temp/table2 OU C:/temp/table1 .. 
		   * 
		   * 
		   */
		
		
		/**
		   * 1- Codez la méthode fullScan() dans la classe TableInt. 
		   * Cette méthode doit retourner un Nuplet[] contenant tous les Nuplets de la table .
		   * 
		   * @param args Unused.
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * La méthode parse tout le fichier associé a la table ( représenter ici par t ) et retourne les nuplets
		   * 
		   */
		
		System.out.println("------------------------------------------------");	
		System.out.println("Start Full Scan");
		
		for(Nuplet n : t.fullScan())
			System.out.println(n);
		
		System.out.println("END Full Scan");
		System.out.println("------------------------------------------------");	
		
	
		
	}

}
