package impl;

import operateurs.Max;
import stockage.Nuplet;

public class MaxInt implements Max{

	@Override
	public int max(Nuplet[] nuplets, int att) {
		int max = (byte)nuplets[0].getAtt(att) ; 
		
		for(int i = 1 ; i<nuplets.length;i++) {
			if((byte)nuplets[i].getAtt(att)  > (byte)nuplets[i-1].getAtt(att) )
				max = (byte)nuplets[i].getAtt(att)  ; 
		}
		
		return max;
	}

}
