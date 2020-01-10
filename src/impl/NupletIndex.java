package impl;

import java.util.Arrays;
import java.util.Collections;

import comparator.NupletComparator;
import stockage.Nuplet;

public class NupletIndex {

	
	public Nuplet[] index(Nuplet[] nuplets , int atts) {
		Collections.sort(Arrays.asList(nuplets),new NupletComparator(atts));
		
		return nuplets;
	}

}
