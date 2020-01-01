package impl;

import java.util.Arrays;

import operateurs.Projection;
import stockage.Nuplet;

public class ProjectionImpl implements Projection{

	@Override
	public Nuplet[] project(Nuplet[] t, int[] atts) {
		/*
		for(Nuplet nuplet : t ) {
			for(int i=0; i<nuplet.size();i++) {
				boolean flag = false;
				for(int att : atts) {
					if(att == i)
						flag = true ;
				}
				if(flag)
					continue ; 
				nuplet.putAtt(i, (byte)0);
			}
		}
		*/

		Nuplet [] nuplets = new NupletInt[t.length];
		
		for(int i=0;i<t.length;i++) {
			Nuplet nuplet = new NupletInt(atts.length);
			for(int j=0; j<atts.length;j++) {
				nuplet.putAtt(j,t[i].getAtt(atts[j]));
			}
			nuplets[i] = nuplet; 
			
		}
		
		
		return nuplets;
	}

}
