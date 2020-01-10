package impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import operateurs.PipeLine;
import stockage.Nuplet;

public class NupletInt implements Nuplet,Iterable<Nuplet>{

	private byte[] values;
	
	public NupletInt(int size){
		this.values = new byte[size];
	}
	
	public NupletInt(byte[] tab){
		this.values = new byte[tab.length];
		for(int i=0;i<tab.length;i++){
			this.values[i] = tab[i];
		}
	}
	
	public Object getAtt(int i) {
		return this.values[i];
	}
	

	public int size(){
		return this.values.length;
	}
	
	public String toString(){
		String s = "";
		for(int i=0;i<this.size();i++){
			s+=this.values[i]+"\t";
		}
		return s;
	}

	@Override
	public void putAtt(int i, Object o) {
		this.values[i] = (byte) o;
	}
	
	@Override
	public Iterator<Nuplet> iterator() {
		return  null;
	}
	
	@Override
	public PipeLine pipeLine() {
		return new Iter();
		
	}
	
	 private class Iter implements PipeLine{
		
		private int current = 0 ; 
		
		
		
		public Iter() {
			super();

		}

		@Override
		public boolean hasNext() {
		
			return current < NupletInt.this.values.length;
		}

		@Override
		public Object next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }
		

            return NupletInt.this.getAtt(current++);
		}
		
		

		@Override
		public void open() {
			this.current = 0 ;
		}


		
		
	}


}
