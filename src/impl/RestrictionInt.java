package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import operateurs.PipeLine;
import operateurs.Restriction;
import stockage.Nuplet;

public class RestrictionInt implements Restriction,Iterable<Nuplet> {

	@Override
	public Nuplet[] egalite(Nuplet[] t, int att, Object v) {
		
		Vector<Nuplet> retV= new Vector<Nuplet>();
		for(int i=0;i<t.length;i++){
			if(((byte)t[i].getAtt(att)) == (byte)v ) 
				retV.addElement(t[i]);
				
		}
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;

		
		
	}

	@Override
	public Nuplet[] superieur(Nuplet[] t, int att, Object v) {
		Vector<Nuplet> retV= new Vector<Nuplet>();
		for(int i=0;i<t.length;i++){
			if(((byte)t[i].getAtt(att)) >= (byte)v ) 
				retV.addElement(t[i]);
				
		}
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;

	}

	@Override
	public Nuplet[] inferieur(Nuplet[] t, int att, Object v) {
		Vector<Nuplet> retV= new Vector<Nuplet>();
		for(int i=0;i<t.length;i++){
			if(((byte)t[i].getAtt(att)) <= (byte)v ) 
				retV.addElement(t[i]);
				
		}
		Nuplet[] ret = new Nuplet[retV.size()];
		for(int i=0;i<retV.size();i++)
			ret[i] = retV.elementAt(i);
		return ret;
	}
	
	
	@Override
	public Iterator<Nuplet> iterator() {
		return  null;
	}
	
	public PipeLine pipeLineEgalite(Nuplet[] t, int atts, Object v) {
		return new IterEgalite(t, atts,v);
		
	}
	
	public PipeLine pipeLineSup(Nuplet[] t, int atts, Object v) {
		return new IterSup(t, atts,v);
		
	}
	
	public PipeLine pipeLineInf(Nuplet[] t, int atts, Object v) {
		return new IterInf(t, atts,v);
		
	}
	
	 private class IterEgalite implements PipeLine{
		private Object value ; 
		private Nuplet[] nuplets;
		private int  atts ;
		private int current = 0 ; 
		private Iterator<Nuplet> iterator = null ;
		
		public IterEgalite(Nuplet[] nuplets, int atts,Object value) {
			super();
			this.value = value ; 
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
			
			while(this.iterator.hasNext()) {
				if(((byte)this.iterator.next().getAtt(this.atts)) == (byte)this.value) {
					current++;
					return this.nuplets[current-1] ;
				}
					
				
				current++ ;
				
			}
				
			
				
					
					return null;
		}
	
		
		@Override
		public void open() {
			this.current = 0 ;
			this.iterator = Arrays.stream(this.nuplets).iterator() ; 
		}


		
		
	}
	 
	 
	 private class IterSup implements PipeLine{
		private Object value ; 
		private Nuplet[] nuplets;
		private int  atts ;
		private int current = 0 ; 
		private Iterator<Nuplet> iterator = null ;
		
		
		
		public IterSup(Nuplet[] nuplets, int atts,Object value) {
			super();
			this.value = value ; 
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

			
			while(this.iterator.hasNext()) {
				if(((byte)this.iterator.next().getAtt(this.atts)) >= (byte)this.value) {
					current++;
					return this.nuplets[current-1] ;
				}
					
				
				current++ ;
				
			}
					return null;
				
		}
	
		
		@Override
		public void open() {
			this.current = 0 ;
			this.iterator = Arrays.stream(this.nuplets).iterator() ;
		}


		
		
	}
	 
	 private class IterInf implements PipeLine{
		private Object value ; 
		private Nuplet[] nuplets;
		private int  atts ;
		private int current = 0 ; 
		private Iterator<Nuplet> iterator = null ;
		
		
		
		public IterInf(Nuplet[] nuplets, int atts,Object value) {
			super();
			this.value = value ; 
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
			
			
			while(this.iterator.hasNext()) {
				if(((byte)this.iterator.next().getAtt(this.atts)) <= (byte)this.value) {
					current++;
					return this.nuplets[current-1] ;
				}
					
				
				current++ ;
				
			}
					return null;
				
		}
	
		
		@Override
		public void open() {
			this.current = 0 ;
			this.iterator = Arrays.stream(this.nuplets).iterator() ;
		}


		
		
	}

}
