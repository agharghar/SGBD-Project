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
		
		// G�n�ration des donn�es
		Nuplet[] tab = new NupletInt[datasetSize];
		for(int i=0;i<datasetSize;i++){
			tab[i] = new NupletInt(nupletSize);
			for(int j=0;j<nupletSize;j++){
				tab[i].putAtt(j, (byte)(j+i));
			}
		}

		
		// Impl�mentation avec Table
		
		System.out.println("------------------------------------------------");	
		System.out.println("Cr�ation d'une table");
		Table t = new TableInt("C:/temp/table2", nupletSize);
		for(int i=0;i<datasetSize;i++){
			t.put(tab[i]);
			}
		
		
		
		/**
		   * Prise en main du code 
		   * 0- Prenez connaissance et comprendre le code. En terme d�alg�bre relationnelle, qu�est ce qu�un Nuplet[] ?
		   * 	Il s'agit d'une liste d'�l�ments finis. Dans notre cas, il repr�sente une ligne dans une table 
		   * 
		   * Est-ce  que  dans  notre  code  les  donn�es  restent  lorsque  le  programme  a  fini  de s�ex�cuter?
		   * 	Oui, il est enregister dans un fichier C:/temp/table2 OU C:/temp/table1 .. 
		   * 
		   * 
		   */
		
		
		/**
		   * 1- Codez la m�thode fullScan() dans la classe TableInt. 
		   * Cette m�thode doit retourner un Nuplet[] contenant tous les Nuplets de la table .
		   * 
		   * @param args Unused.
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * La m�thode parse tout le fichier associ� a la table ( repr�senter ici par t ) et retourne les nuplets
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
