package impl;

import operateurs.Count;
import stockage.Nuplet;

public class CountInt implements Count{

	@Override
	public int count(Nuplet[] nuplets, int att) {
		
		int i = 0 ;
		for(Nuplet nuplet: nuplets)
			if(nuplet != null)
				i++;
		
		return i;
	}

}
