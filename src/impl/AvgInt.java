package impl;

import operateurs.Avg;
import stockage.Nuplet;

public class AvgInt implements Avg{

	@Override
	public double avg(Nuplet[] nuplets, int att) {
		int avg =0,i=0 ; 
		for(Nuplet nuplet : nuplets) {
			if(nuplet != null) {
				i++;
				avg += (byte)nuplet.getAtt(att);
			}
				
		}
		return i != 0 ?  (double)avg/(double)i : 0 ; 
		
	}
	

}
