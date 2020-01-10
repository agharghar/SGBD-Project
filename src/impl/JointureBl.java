package impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import operateurs.Jointure;
import operateurs.PipeLine;
import stockage.Nuplet;

public class JointureBl implements Jointure,Iterable<Nuplet>{

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
	
	@Override
	public Iterator<Nuplet> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PipeLine pipeLine(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		return new Iter(t1, t2, att1,  att2);
		
	}
	
	 private class Iter implements PipeLine{

		private Nuplet[] nuplets1,nuplets2;
		private int att1,att2 ;
		private int current1 = 0 ,current2 = 0 ;
		private boolean flag = false; 
		private Iterator<Nuplet> iterator1 = null ;
		private Iterator<Nuplet> iterator2 = null ;
		private Nuplet nupletTmp = null;
		private boolean flagIt = true;
		
		
		
		

		public Iter(Nuplet[] nuplets1, Nuplet[] nuplets2, int att1, int att2) {
			super();
			this.nuplets1 = nuplets1;
			this.nuplets2 = nuplets2;
			this.att1 = att1;
			this.att2 = att2;
			
		}

		@Override
		public boolean hasNext() {
		
			//return (iterator1 != null ? iterator1.hasNext() : (iterator2 != null ? iterator2.hasNext() : true));
			return (current1 <= this.nuplets1.length || current2 <= this.nuplets2.length-1)  ;
		}
		

		@Override
		public Nuplet next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }
			
			while(iterator1.hasNext() || current1 <= this.nuplets1.length) {
				 
				if(this.flagIt) {
					if(iterator1.hasNext()) {
						this.nupletTmp = iterator1.next();
					}
					current1++;
					this.flagIt = false;
				}
				
				
				
				while(iterator2.hasNext() ) {
					if(this.nupletTmp.getAtt(att1) == iterator2.next().getAtt(att2)) {
						if(this.current2 <= 100 )
							current2++;
						flag = true ;
						return nuplets2[current2-1];
					}
					current2++;
				}
				
				if(this.flag && iterator1.hasNext()) {
					this.flag=false;
					return nuplets1[current1-1];
				}
				this.flagIt = true;
				this.iterator2 = Arrays.stream(this.nuplets2).iterator() ;
				this.current2 = 0 ;
			}
			
			if(!iterator1.hasNext()) {
				this.flag=false;
				current1++;
				current2++;
			}
			

			return null;
		}
	
		
		@Override
		public void open() {
			this.current1 = 0 ;
			this.current2 = 0 ;
			this.iterator1 = Arrays.stream(this.nuplets1).iterator() ;
			this.iterator2 = Arrays.stream(this.nuplets2).iterator() ;
		}


		
		
	}

	




}
