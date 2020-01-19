package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import comparator.NupletComparator;
import stockage.Nuplet;

public class NonDenseIndex {


	private Hashtable< Object, List<Nuplet>> indexHashtable = new Hashtable<Object, List<Nuplet>>() ; 
	
	public NonDenseIndex(Nuplet[] nuplets , int attr) {
		super();
		Collections.sort(Arrays.asList(nuplets),new NupletComparator(attr));
		for(Nuplet nuplet : nuplets) {
			if(!indexHashtable.containsKey((byte)nuplet.getAtt(attr))) {
				List<Nuplet> listNuplets = new ArrayList<Nuplet>() ; 
				listNuplets.add(nuplet);
				indexHashtable.put((byte)nuplet.getAtt(attr), listNuplets);
			}else {
				List<Nuplet> list = indexHashtable.get(nuplet.getAtt(attr));
				list.add(nuplet);
				indexHashtable.put(nuplet.getAtt(attr),list );
				
				
				
			}
			
			
		}
		
		
		
	}

	public Nuplet[] index(int value) {
		
		if(indexHashtable.get((byte)value ) != null) {
			return indexHashtable.get((byte)value ).toArray(new Nuplet[indexHashtable.get((byte)value).size()]);

		}
		return new Nuplet[0] ;
		
		
	}

}
