package impl;

import operateurs.Sum;
import stockage.Nuplet;

public class SumInt implements Sum{

	@Override
	public int sum(Nuplet[] nuplets, int att) {
		int sum =0;
		for(Nuplet nuplet : nuplets) {
			sum += (byte) nuplet.getAtt(att);
		}
			
		
		return sum;
	}

}
