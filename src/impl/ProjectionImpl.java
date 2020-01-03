package impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


import operateurs.PipeLine;
import operateurs.Projection;
import stockage.Nuplet;

public class ProjectionImpl implements Projection,Iterable<Nuplet>{

	@Override
	public Nuplet[] project(Nuplet[] t, int[] atts) {

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
	
	
	@Override
	public Iterator<Nuplet> iterator() {
		return  null;
	}
	
	public PipeLine pipeLine(Nuplet[] t, int[] atts) {
		return new Iter(t, atts);
		
	}
	
	 private class Iter implements PipeLine{

		private Nuplet[] nuplets;
		private int [] atts ;
		private int current = 0 ; 
		
		
		
		public Iter(Nuplet[] nuplets, int[] atts) {
			super();
			this.nuplets = nuplets;
			this.atts = atts;
		}

		@Override
		public boolean hasNext() {
		
			return current < this.nuplets.length;
		}

		@Override
		public Nuplet next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }
			
			Nuplet nuplet = new NupletInt(this.atts.length);
			for(int j=0; j<atts.length;j++) 
				nuplet.putAtt(j,nuplets[current].getAtt(atts[j]));
			current++;
			
            return nuplet;
		}
	
		
		@Override
		public void open() {
			this.current = 0 ;
		}


		
		
	}

}
