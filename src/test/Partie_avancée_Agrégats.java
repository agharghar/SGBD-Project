/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */

package test;

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

public class Partie_avanc�e_Agr�gats {

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
		
		System.out.println("Lecture d'une table");
		for(Nuplet nuplet : t.fullScan()){
			System.out.println(nuplet.toString());
			}
		
		Nuplet[] nuplets = t.fullScan(); 
		Sum sum = new SumInt();
		Min min = new MinInt();
		Max max = new MaxInt();
		Avg avg = new AvgInt();
		Count count = new CountInt();
		
		/**
		 * D- Mettez en place des op�rateurs pour g�rer 
		 * les agr�gats (COUNT, SUM, AVG, MIN, MAX) et les int�grer dans une Requete
		 */
		
		/**
		   * 
		   * @param 
		   * 	nuplets : 	table de Nuplets
		   * 	2 :		num�ro d'attribut de la table 
		   * @return Le calcule
		   * @exception 
		   * 	si num�roAttribut > tab.length : ArrayIndexOutOfBoundsException			
		   * 
		   *  le nom de la m�thode est auto descriptif
		   */
		
		System.out.println("-------------------------------------------------");
		System.out.println("SUM =======>"+sum.sum(nuplets, 2));
		System.out.println("Min =======>"+min.min(nuplets, 2));
		System.out.println("Max =======>"+max.max(nuplets, 2));
		System.out.println("Avg =======>"+avg.avg(nuplets, 2));
		System.out.println("Count =====>"+count.count(nuplets, 2));
		


	}

}
