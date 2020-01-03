package impl;

import operateurs.Min;
import stockage.Nuplet;

public class MinInt implements Min{

	@Override
	public int min(Nuplet[] nuplets, int att) {
		int min = (byte)nuplets[0].getAtt(att) ; 
		
		for(int i = 1 ; i<nuplets.length;i++) {
			if((byte)nuplets[i].getAtt(att)  < (byte)nuplets[i-1].getAtt(att) )
				min = (byte)nuplets[i].getAtt(att)  ; 
		}
		
		return min;
	
	}

}
