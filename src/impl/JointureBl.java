package impl;

import java.util.Vector;

import operateurs.Jointure;
import stockage.Nuplet;

public class JointureBl implements Jointure{

	@Override
	public Nuplet[] jointure(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		
		Vector<Nuplet> retV= new Vector<Nuplet>();
		for(Nuplet nuplet1 : t1) {
			boolean flag = false ; 
			for(Nuplet nuplet2 : t2) {
				if(nuplet1.getAtt(att1) == nuplet2.getAtt(att2)) {
					retV.addElement(nuplet2);
					flag = true ; 
				}
			}
			if(flag)
				retV.addElement(nuplet1);
				
		}			
		
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;
			
	}

}
