/**
 * 
 * @author AGHARGHAR zakariya
 * @version 1.0 
 * 
 * 
 * 
 */





package test;


import stockage.*;
import impl.*;
import operateurs.Avg;
import operateurs.Count;
import operateurs.Jointure;
import operateurs.Max;
import operateurs.Min;
import operateurs.PipeLine;
import operateurs.Projection;
import operateurs.Restriction;
import operateurs.Sum;


public class Main {
	
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

		System.err.println("Si vous avez des Exceptions de dépendance, "
				+ "veuillez vérifier le PATH pour Log4J Jar et java 1.8 ");
		
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
		
		/**
		   * 2- Codez dans sgbd.impl la classe RestrictionInt qui implémente la classe sgbd.operateurs.
		   * Restriction et qui travaille sur des NupletInt. 
		   * Proposez un programme Main qui démontre que votre code fonctionne.
		   * 
		   */
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet[].
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value == value ) ? 
		   * 	si true il retourne l'ensemble des nuplets
		   * 
		   */
		System.out.println("----------------------------------------------------");
		
		System.out.println("Start compare equal");
		RestrictionInt restrictionInt = new RestrictionInt() ; 
		Nuplet n [] = restrictionInt.egalite(tab, 0, (byte)20);
		for(Nuplet nuplet : n )
			System.out.println(nuplet.toString());
		System.out.println("END compare equal");
		
		
		
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet[].
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value >= value ) ? 
		   * 	si true il retourne l'ensemble des nuplets
		   * 
		   */
		
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("Start compare sup or equ");
		Nuplet n2 [] = restrictionInt.superieur(tab, 0, (byte)3);
		for(Nuplet nuplet : n2 )
			System.out.println(nuplet.toString());
		
		System.out.println("END compare sup or equ");
		
		
		/**
		   * 
		   * @param 
		   * 	table : table des données
		   * 	attribut : numéro d'attribut dans la table
		   * 	value : valeur d'attribut dans la table
		   * @return Nuplet[].
		   * @exception 
		   * 	Index 'attribut.value' out of bounds for length 'table.length'
		   * 
		   * La méthode compare tous les attributes avec la valeur fournie en arg ( attribut.value <= value ) ? 
		   * 	si true il retourne l'ensemble des nuplets
		   * 
		   */
		
		System.out.println("----------------------------------------------------");
	
		System.out.println("Start compare INF or equ");
		Nuplet n3 [] = restrictionInt.inferieur(tab, 0, (byte)3);
		for(Nuplet nuplet : n3 )
			System.out.println(nuplet.toString());
		
		System.out.println("END compare INF or equ");
		
		System.out.println("----------------------------------------------------");
		

		/**
		 * 
		 * 3 -Codez dans sgbd.impl la classe ProjectionImpl qui implémente la classe sgbd.operateurs.
		 * Projection.  Proposez  un  programme  Main  qui  démontre  que  votre  code fonctionne.
		 * 
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab1 : table des données
		   * 	tabInt : table des entiers
		   * 	
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * projette les Nuplets sur un sous ensemble d'attributs définis par atts. 
		   * Par exemple si atts = {1,3,4} on gardera les attributs 1 3 et 4 de l'ensemble des Nuplets.
		   * 
		   */
		
		// Génération des données
		Nuplet[] tabProj = new NupletInt[datasetSize];
		for(int i=0;i<datasetSize;i++){
			tabProj[i] = new NupletInt(nupletSize);
			for(int j=0;j<nupletSize;j++){
				tabProj[i].putAtt(j, (byte)(j+i));
			}
		}

		Projection projection = new ProjectionImpl();
		int tabInt[] = {5,9} ; 
		Nuplet[] res1 = projection.project(tabProj, tabInt);
		
		System.out.println("\t ---------------- Start Projection----------------");
		for(Nuplet n1 : res1) {
			System.out.println(n1.toString());
		}
		System.out.println("\t ---------------- End Projection----------------");
		
		System.out.println("----------------------------------------------------");

		
		

		// Génération des données
		Nuplet[] tab1 = new NupletInt[datasetSize];
		Nuplet[] tab2 = new NupletInt[datasetSize];
		for(int i=0;i<datasetSize;i++){
			tab1[i] = new NupletInt(nupletSize);
			tab2[i] = new NupletInt(nupletSize);
			for(int j=0;j<nupletSize;j++){
				tab1[i].putAtt(j, (byte)(j+i));
				tab2[i].putAtt(j, (byte)(j+i));
			}
		}

		

		
		/**
		 * 4-Codez dans sgbd.impl la classe JointureBI qui implémente une jointure sur deux ensembles
		 * de Nuplet[] sur les attributs  att1 de  t1 et att2 de  t2 en utilisant  un algorithme
		 * basique  de  type doubles boucles imbriquées.
		 * 
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	0 :		numéro d'attribut de la table 1
		   * 	2 : 	numéro d'attribut de la table 2
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab1.att2 
		   */
		 
		System.out.println("\t ---------------- Start JoinBL----------------");
		Jointure jointure = new JointureBl() ; 
		Nuplet[] resJoin = jointure.jointure(tab1, tab2, 0, 2);
		
		for(Nuplet nJoin : resJoin)
			System.out.println(nJoin.toString());
		
		
		System.out.println("\t ---------------- End JoinBL----------------");
		System.out.println("----------------------------------------------------");
		
		
		/**
		 * 5- Codez dans sgbd.impl la classe JointureH qui implémente une jointure 
		 * en utilisant la technique de HashJoin. 
		 * Donnez des programmes exemple.
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	0 :		numéro d'attribut de la table 1
		   * 	2 : 	numéro d'attribut de la table 2
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant hash(tab2.att2) in ? hash_table(tab1,att1)
		   */ 
		
		Jointure jointureH = new JointureH() ; 
		Nuplet[] resH = jointureH.jointure(tab1, tab2, 0, 2);
		System.out.println("\t ---------------- Start JoinH----------------");
		
		for(Nuplet nJoinH : resH)
			System.out.println(nJoinH.toString());

		System.out.println("\t ---------------- End JoinH----------------");
		System.out.println("----------------------------------------------------");

		

		/**
		 * 6- Codez danssgbd.impl la classe JointureS qui implémente 
		 * une jointure en utilisant la technique de SortMergeJoin. 
		 * Donnez des programmes exemple.
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	2 :		numéro d'attribut de la table 1
		   * 	1 : 	numéro d'attribut de la table 2
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant algo sort Merge
		   */ 
		
		Jointure jointureS = new JointureS() ; 
		Nuplet[] resS = jointureS.jointure(tab1, tab2, 2, 1);
		
		System.out.println("\t ---------------- Start JoinS----------------");

		
		for(Nuplet nS : resS)
			System.out.println(nS.toString());

		System.out.println("\t ---------------- End JoinS----------------");
		System.out.println("----------------------------------------------------");


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
		System.out.println("Start Full Scan PipeLine");
		PipeLine pipelineFullScan =  t.pipeLine();
		pipelineFullScan.open();
		while(pipelineFullScan.hasNext())
			System.out.println(pipelineFullScan.next());
		
		System.out.println("End Full Scan PipeLine");
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
		System.out.println("Start Projection PipeLine");
		
		int tabInt1[] = {0,1,2} ; 
		PipeLine pipeLineProjection = new ProjectionImpl().pipeLine(tab1, tabInt1);
		
		while(pipeLineProjection.hasNext())
			System.out.println(pipeLineProjection.next());

		System.out.println("End Projection PipeLine");
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
		System.out.println("Start compare equal PipeLine");
		Restriction restrictionInt1 = new RestrictionInt() ; 
		PipeLine pipeLineEgalite = restrictionInt1.pipeLineEgalite(tab1, 4, (byte)5);
		pipeLineEgalite.open();
		while(pipeLineEgalite.hasNext())
			System.out.println(pipeLineEgalite.next());
		System.out.println("END compare equal PipeLine");
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
		System.out.println("Start compare sup or equ PipeLine");
		PipeLine pipeLineSup = restrictionInt.pipeLineSup(tab1, 2, (byte)6);
		pipeLineSup.open();
		while(pipeLineSup.hasNext())
			System.out.println(pipeLineSup.next());
		System.out.println("END compare sup or equ PipeLine");
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
		System.out.println("Start compare Inf or equ PipeLine");
		PipeLine pipeLineInf = restrictionInt.pipeLineInf(tab1, 3, (byte)5);
		pipeLineInf.open();
		while(pipeLineInf.hasNext())
			System.out.println(pipeLineInf.next());
		System.out.println("END compare Inf or equ PipeLine");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	5 :		numéro d'attribut de la table 1
		   * 	9 : 	numéro d'attribut de la table 2
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab1.att2 retourne un nuplet
		   */
		System.out.println("----------------------------------------------------");
		System.out.println("start Join Bl PipeLine");
		PipeLine pipeLineJointureBl = new JointureBl().pipeLine(tab1, tab2, 5, 9);
		pipeLineJointureBl.open();
		while(pipeLineJointureBl.hasNext())
			System.out.println(pipeLineJointureBl.next());
		System.out.println("END Join Bl PipeLine");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	5 :		numéro d'attribut de la table 1
		   * 	9 : 	numéro d'attribut de la table 2
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant hash(tab2.att2) in ? hash_table(tab1,att1)
		   * 
		   */ 
		
		System.out.println("----------------------------------------------------");
		System.out.println("start Join H PipeLine");
		PipeLine pipeLineJointureH = new JointureH().pipeLine(tab1, tab2, 5, 9);
		pipeLineJointureH.open();
		while(pipeLineJointureH.hasNext())
			System.out.println(pipeLineJointureH.next());
		System.out.println("END Join H PipeLine");
		System.out.println("----------------------------------------------------");
		
		
		/**
		   * 
		   * @param 
		   * 	tab1 : 	table des données
		   * 	tab2 :	table des données
		   * 	5 :		numéro d'attribut de la table 1
		   * 	9 : 	numéro d'attribut de la table 2
		   * @return Nuplet
		   * @exception No Exeption
		   * 
		   * Jointure sur tab1.att1 = tab2.att2 en utilisant algo sort Merge
		   */ 
		System.out.println("----------------------------------------------------");
		System.out.println("start Join S PipeLine");
		PipeLine pipeLineJointureS = new JointureS().pipeLine(tab1, tab2, 5, 9);
		pipeLineJointureS.open();
		
		while(pipeLineJointureS.hasNext())
			System.out.println(pipeLineJointureS.next());
		
		System.out.println("END Join S PipeLine");
		System.out.println("----------------------------------------------------");
		
		
		
		/**
		 * 8- Rajoutez des index Non Dense
		 * 
		 */
		
		/**
		   * 
		   * @param 
		   * 	tab : table des données
		   * 	2 : numéro d'attribut à indexer
		   * @return Nuplet[]
		   * @exception No Exeption
		   * 
		   * Indexer une table avec un objet qui représente un index 
		   */
		
		System.out.println("----------------------------------------------------");
		NonDenseIndex nupletIndex = new NonDenseIndex(t.fullScan(),2) ;
		
		System.out.println("\tStart Non Dense Index");
		
		for( Nuplet nuplet : nupletIndex.index(3))
			System.out.println(nuplet);
		
		System.out.println("\tEnd Start Non Dense Index");

		/*
		 * Comparaison temps de réponse index et restriction : 
		 * 
		 */
		System.out.println("\t ----- Comparaison temps de réponse index et restriction -----");
		
		RestrictionInt restrictionInt2 = new RestrictionInt() ; 
		
		double startTimeIndex = System.nanoTime();
		nupletIndex.index(3) ; 
		double endTimeIndex = System.nanoTime();
		double startTimeRestriction = System.nanoTime();
		restrictionInt2.egalite(tab, 0, (byte)3);
		double endTimeRestriction = System.nanoTime();
		System.out.println("Index Response Time :"+(endTimeIndex - startTimeIndex ));
		System.out.println("Restriction Response Time : "+(endTimeRestriction - startTimeRestriction));
		
		
		
		System.out.println("----------------------------------------------------");
		
		

		/**
		 * 
		 * 9- Implémentez les méthodes insert, delete et update dans la classe TableInt
		 * 
		 */
		
		
		/**
		   * 
		   * @param 
		   * 	tab1[99] : 	Nuplet 
		   * 	0 :		numéro d'attribut de la table 1
		   * 	99 : 	value
		   * @return void
		   * @exception 
		   * 	si numéroAttribut > tab.length : ArrayIndexOutOfBoundsException			
		   * 
		   *  efface tous les Nuplets dont att est égal à value
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
			   * 	0 :		numéro d'attribut de la table 1
			   * 	7 : 	value
			   * @return void
			   * @exception 
			   * 	si numéroAttribut > tab.length : ArrayIndexOutOfBoundsException			
			   * 
			   *  modifie tous les Nuplets dont att était égal à oldValue et leur met la valeur newValue
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
			   * 	si numéroAttribut > tab.length : ArrayIndexOutOfBoundsException			
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
		
		System.out.println("---------------------------------------------------");
		
		
		/**
		 * 
		 * 10-	Proposez une implémentation permettant d’assurer la sérialisabilité 
		 * 		de vos opérations de mises à jour.
		 *  	Comment avez-vous architecturé votre code pour assurer cette contrainte?
		 */
		
		
		/**
		   * 
		   * @param 
		   * 	tab1[1] : 	Nuplet 
		   * @return void
		   * @exception No Exeption			
		   * 
		   *  Crée un fichier nomée hashCodeNuplet().txt et met la valeur true .
		   *  	checkTrue(fileName);
		   *  	si deja true :
		   *  		thread.sleep(rand_time)
		   *  	else : 
		   *  		put_in_file(true)
		   */
		SerialisableNuplet serialisableNuplet = new SerialisableNuplet() ;
		serialisableNuplet.preLock(tab[0]);
		t.update(tab[0], 0, (byte)0, (byte)99);
		
		System.out.println("-----------------------------------");
		System.out.println("\tSerialisation & dead lock");
		
		serialisableNuplet.afterLock(tab[0]);

		/**
		 * dead lock :)
		 * 
		 */
		
		System.out.println("-----------");
		Nuplet tab0Copy = tab[0] ;
		Nuplet tab1Copy = tab[1];
		
		serialisableNuplet.preLock(tab[0]);
		serialisableNuplet.preLock(tab[1]);

		t.update(tab[0], 0, (byte)0, (byte)99);
		t.update(tab[1], 0, (byte)1, (byte)11);
		System.err.println("Dead Lock ici ===> veuillez lire les COMMENTRAIRES !! <====");
		System.err.println("Ou bien : F5 et supprimer les fichiers && décomment le code commenter ");
		
		/*
		 * Solution : 
		 * 
		 * 	F5 et supprimer les fichiers . 
		 * 	decomment le code :
		 *
		 */
		
//		serialisableNuplet.afterLock(tab0Copy);
//		serialisableNuplet.afterLock(tab1Copy);

		
		serialisableNuplet.preLock(tab0Copy);
		serialisableNuplet.preLock(tab1Copy);
		
		t.update(tab0Copy, 0, (byte)99, (byte)88);
		t.update(tab1Copy, 0, (byte)11, (byte)22);
		
		serialisableNuplet.afterLock(tab[0]);
		serialisableNuplet.afterLock(tab[1]);
		
		serialisableNuplet.afterLock(tab0Copy);
		serialisableNuplet.afterLock(tab1Copy);
		
		System.out.println("----------------------------------------------");

		
		/**
		 * D- Mettez en place des opérateurs pour gérer 
		 * les agrégats (COUNT, SUM, AVG, MIN, MAX) et les intégrer dans une Requete
		 */
		
		/**
		   * 
		   * @param 
		   * 	nuplets : 	table de Nuplets
		   * 	2 :		numéro d'attribut de la table 
		   * @return Le calcule
		   * @exception 
		   * 	si numéroAttribut > tab.length : ArrayIndexOutOfBoundsException			
		   * 
		   *  le nom de la méthode est auto descriptif
		   */
		
		System.out.println("\tLes agrégats");
		Nuplet[] nuplets = t.fullScan(); 
		Sum sum = new SumInt();
		Min min = new MinInt();
		Max max = new MaxInt();
		Avg avg = new AvgInt();
		Count count = new CountInt();
		
		
		System.out.println("SUM =======>"+sum.sum(nuplets, 2));
		System.out.println("Min =======>"+min.min(nuplets, 2));
		System.out.println("Max =======>"+max.max(nuplets, 2));
		System.out.println("Avg =======>"+avg.avg(nuplets, 2));
		System.out.println("Count =====>"+count.count(nuplets, 2));
		
		System.out.println("-------------------------------------------------");
		
		
		/**
		 * Reprise sur panne
		 * 
		 * B- Améliorez la classe TableInt pour pouvoir 
		 * supporter des pannes de type coupure de courant.
		 * 
		 */
		
		System.out.println("\tUtilisation des Log dans fichierInt ( utilisation log4j)");
		System.out.println();
		System.out.println("Pour Voir les Log F5 , et cat /log/logFile");
		System.out.println();
		System.out.println("end TP projet");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	
		
		
		
		
	
	

	
	

	}

