package impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import comparator.NupletComparator;
import operateurs.Jointure;
import operateurs.PipeLine;
import stockage.Nuplet;

public class JointureS implements Jointure,Iterable<Nuplet> {

	@Override
	public Nuplet[] jointure(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		Vector<Nuplet> retV= new Vector<Nuplet>();
		List<Nuplet> list1 = Arrays.asList(t1);
		List<Nuplet> list2 = Arrays.asList(t2);
		
		Collections.sort(list1,new NupletComparator(att1));
		Collections.sort(list2,new NupletComparator(att2));
		
		Iterator<Nuplet> iterator1 = list1.iterator();
		Iterator<Nuplet> iterator2 = list2.iterator(); 
		
		
		Nuplet nuplet1 = iterator1.next();
		Nuplet nuplet2 = iterator2.next();
		while(iterator1.hasNext() && iterator2.hasNext()) {
			Nuplet nuplet = null ;
			if( (byte)nuplet1.getAtt(att1)  == (byte)nuplet2.getAtt(att2)) {
				byte[] result = new byte[nuplet1.size() + nuplet2.size()];
				System.arraycopy(nuplet1.getValues(), 0, result, 0, nuplet1.getValues().length);  
				System.arraycopy(nuplet2.getValues(), 0, result, nuplet1.getValues().length, nuplet2.getValues().length);
				nuplet = new NupletInt(result) ;
				retV.addElement(nuplet); 	
				nuplet2 = iterator2.next() ; 
	
			}else if((byte)nuplet1.getAtt(att1)  < (byte)nuplet2.getAtt(att2)) {
				nuplet1 = iterator1.next() ; 
			}else if((byte)nuplet1.getAtt(att1)  > (byte)nuplet2.getAtt(att2)) {
				nuplet2 = iterator2.next();
			}
				
		}
		
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;
	}

	@Override
	public PipeLine pipeLine(Nuplet[] t1, Nuplet[] t2, int att1, int att2) {
		return new Iter(t1, t2, att1,  att2);
	}
	
	 private class Iter implements PipeLine{
		
		private Nuplet[] nuplets1,nuplets2;
		private int att1,att2 ;
		private int current1 = 0 ,current2 = 0 ;
		private Iterator<Nuplet> iterator1 = null ;
		private Iterator<Nuplet> iterator2 = null ;
		private boolean flag = true;
		private Nuplet nuplet1,nuplet2;

		
		
		
		

		public Iter(Nuplet[] nuplets1, Nuplet[] nuplets2, int att1, int att2) {
			super();
			this.nuplets1 = nuplets1;
			this.nuplets2 = nuplets2;
			this.att1 = att1;
			this.att2 = att2;
			
		}

		@Override
		public boolean hasNext() {
		
			return (current1 < this.nuplets1.length && current2 <= this.nuplets2.length)  ;
		}
		

		@Override
		public Nuplet next() {
			if (!hasNext()) {
               throw new NoSuchElementException();
           }
 
			
			if(this.flag ) {
				nuplet1 = iterator1.next();
				nuplet2 = iterator2.next();
				current1++;
				current2++;	
				this.flag = false ;
			}
			
			
			while(iterator1.hasNext() || iterator2.hasNext()) {
				
				if( (byte)nuplet1.getAtt(att1)  == (byte)nuplet2.getAtt(att2)) {
					byte[] result = new byte[nuplet1.size() + nuplet2.size()];
					System.arraycopy(nuplet1.getValues(), 0, result, 0, nuplet1.getValues().length);  
					System.arraycopy(nuplet2.getValues(), 0, result, nuplet1.getValues().length, nuplet2.getValues().length);
					if(iterator2.hasNext()) 
						nuplet2 = iterator2.next() ;
					
					current2++;
					return  new NupletInt(result) ;
 
		
				}else if((byte)nuplet1.getAtt(att1)  < (byte)nuplet2.getAtt(att2)) {
					if(iterator1.hasNext())
						nuplet1 = iterator1.next() ; 
					current1++;

						
				}else if((byte)nuplet1.getAtt(att1)  > (byte)nuplet2.getAtt(att2)) {
					if(iterator2.hasNext())
						nuplet2 = iterator2.next();
					current2++;
				}
					
			}
			if( (byte)nuplet1.getAtt(att1)  == (byte)nuplet2.getAtt(att2)) {
				byte[] result = new byte[nuplet1.size() + nuplet2.size()];
				System.arraycopy(nuplet1.getValues(), 0, result, 0, nuplet1.getValues().length);  
				System.arraycopy(nuplet2.getValues(), 0, result, nuplet1.getValues().length, nuplet2.getValues().length);
				
				return  new NupletInt(result) ;

	
			}
			
			return null ;
		}
	
		
		@Override
		public void open() {
			List<Nuplet> list1 = Arrays.asList(nuplets1);
			List<Nuplet> list2 = Arrays.asList(nuplets2);
			
			Collections.sort(list1,new NupletComparator(att1));
			Collections.sort(list2,new NupletComparator(att2));
			this.iterator1 = list1.iterator();
			this.iterator2 = list2.iterator();
			this.current1 = 0 ;
			this.current2 = 0 ;
		}
	

	 }

	@Override
	public Iterator<Nuplet> iterator() {
		return null;
	}
}