package impl;

import java.util.HashMap;
import java.util.Vector;

import operateurs.Jointure;
import operateurs.PipeLine;
import stockage.Nuplet;

public class JointureH implements Jointure{

	@Override
	public Nuplet[] jointure(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		Vector<Nuplet> retV= new Vector<Nuplet>();
		
		HashMap<Integer, Nuplet> hashTable = new HashMap<Integer, Nuplet>();
		for(Nuplet nuplet : t1) 
			hashTable.put(nuplet.getAtt(att1).toString().hashCode(), nuplet);
			
	
					
		for(Nuplet nuplet : t2) {
				if(hashTable.containsKey(nuplet.getAtt(att2).toString().hashCode())) {
					if(!retV.contains(hashTable.get(nuplet.getAtt(att2).toString().hashCode())))
						retV.addElement(hashTable.get(nuplet.getAtt(att2).toString().hashCode()));
					if(!retV.contains(nuplet))
						retV.addElement(nuplet);
					

				}
		}			
		
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;
	}

	@Override
	public PipeLine pipeLine(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		// TODO Auto-generated method stub
		return null;
	}

}
