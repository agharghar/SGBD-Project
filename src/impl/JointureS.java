package impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import comparator.NupletComparator;
import operateurs.Jointure;
import stockage.Nuplet;

public class JointureS implements Jointure {

	@Override
	public Nuplet[] jointure(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		Vector<Nuplet> retV= new Vector<Nuplet>();
		List<Nuplet> list1 = Arrays.asList(t1);
		List<Nuplet> list2 = Arrays.asList(t2);
		
		Collections.sort(list1,new NupletComparator(att1));
		Collections.sort(list2,new NupletComparator(att2));
		
		Iterator<Nuplet> iterator1 = list1.iterator();
		Iterator<Nuplet> iterator2 = list2.iterator(); 
		
		
		Nuplet nuplet1 = iterator1.next();
		Nuplet nuplet2 = iterator2.next();
		while(iterator1.hasNext() && iterator2.hasNext()) {
			

				
				if( (byte)nuplet1.getAtt(att1)  == (byte)nuplet2.getAtt(att2)) {
					retV.addElement(nuplet2);
					if(!retV.contains(nuplet1))
						retV.addElement(nuplet1);
					nuplet2 = iterator2.next() ; 	

				}else if((byte)nuplet1.getAtt(att1)  < (byte)nuplet2.getAtt(att2)) {
					nuplet1 = iterator1.next() ; 
				}else if((byte)nuplet1.getAtt(att1)  > (byte)nuplet2.getAtt(att2)) {
					nuplet2 = iterator2.next();
				}
				
				
		}
		
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;
	}
	

}
