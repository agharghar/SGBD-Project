package impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import operateurs.Jointure;
import operateurs.PipeLine;
import stockage.Nuplet;

public class JointureH implements Jointure,Iterable<Nuplet>{

	@Override
	public Nuplet[] jointure(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {

		
		Vector<Nuplet> retV= new Vector<Nuplet>();
		HashMap<Integer, Nuplet> hashTable = new HashMap<Integer, Nuplet>();
		for(Nuplet nuplet : t1) 
			hashTable.put(nuplet.getAtt(att1).toString().hashCode(), nuplet);
		
		for(Nuplet n : t2) {
			Nuplet nuplet = null ;
			if(hashTable.containsKey(n.getAtt(att2).toString().hashCode())) {
				byte[] result = new byte[n.size() + hashTable.get(n.getAtt(att2).toString().hashCode()).size()];
				
				System.arraycopy(hashTable.get(n.getAtt(att2).toString().hashCode()).getValues(), 0, result, 0, hashTable.get(n.getAtt(att2).toString().hashCode()).getValues().length);  
				System.arraycopy(n.getValues(), 0, result, hashTable.get(n.getAtt(att2).toString().hashCode()).getValues().length, n.getValues().length);  
				nuplet = new NupletInt(result) ;
				retV.addElement(nuplet);
				
			}
		}
	
		
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		
		
		
		return ret ;
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
		private Nuplet n1 = null ;
		private int att1,att2 ;
		private int current1 = 0 ,current2 = 0 ;
		private boolean flag = false; 
		private Iterator<Nuplet> iterator1 = null ;
		private Iterator<Nuplet> iterator2 = null ;
		

		
		
		
		

		public Iter(Nuplet[] nuplets1, Nuplet[] nuplets2, int att1, int att2) {
			super();
			this.nuplets1 = nuplets1;
			this.nuplets2 = nuplets2;
			this.att1 = att1;
			this.att2 = att2;
			
		}

		@Override
		public boolean hasNext() {
		
			return (current1 < this.nuplets1.length || current2 < this.nuplets2.length-1)  ;
		}
		

		@Override
		public Nuplet next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }
			
			
			Nuplet nuplet = null ;
			while(iterator1.hasNext() ) {
				if(!flag) {
					n1 = iterator1.next();
					current1++;
					flag = true;
				}
				while(iterator2.hasNext() ) {
					Nuplet n2 = iterator2.next();
					current2++;
					if(n1.getAtt(att1) == n2.getAtt(att2)) {
						byte[] result = new byte[n1.size() + n2.size()];
						System.arraycopy(n1.getValues(), 0, result, 0, n1.getValues().length);  
						System.arraycopy(n2.getValues(), 0, result, n1.getValues().length, n2.getValues().length);  
						nuplet = new NupletInt(result) ;
						return nuplet ;
					}
				}
				flag = false;
				this.iterator2 = Arrays.stream(this.nuplets2).iterator() ;
				current2 =0;
				
				

		}
			return nuplet ;
			
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
