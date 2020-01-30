package impl;

import java.util.Iterator;
import java.util.Vector;


import operateurs.PipeLine;
import stockage.Nuplet;
import stockage.Table;



public class TableInt implements Table,Iterable<Nuplet>{
	
	private int records;
	FichierInt f;
	

	
	public TableInt(String filePath, int nupletSize){
		this.records = 0;
		this.f = new FichierInt(filePath, nupletSize);
	}

	@Override
	public Nuplet get(int pos) {
		return (Nuplet) f.get(pos);
	}

	@Override
	public int size() {
		return this.records;
	}

	@Override
	public void put(Nuplet n) {
		f.store(this.records, n);
		this.records++;
	}

	/** Cette méthode peut être améliorée par un index !
	 * 
	 */
	@Override
	public Nuplet[] getByAtt(int att, Object value) {
		Vector<Nuplet> v = new Vector<Nuplet>();
		for(int i=0;i<this.size();i++){
			Nuplet temp = this.get(i);
			if((byte)(temp.getAtt(att)) == (byte)value){
				v.addElement(temp);
			}
		}
		Nuplet[] ret = new Nuplet[v.size()];
		for(int i=0;i<v.size();i++)
			ret[i] = v.elementAt(i);
		return ret;
	}

	@Override
	public Nuplet[] fullScan() {
		Nuplet[] ret = new Nuplet[this.size()];
		
		for(int i=0;i<this.size();i++)
			 ret[i] = this.get(i);
			
		return ret ; 
	}

	@Override
	public void insert(Nuplet n) {
		this.f.store(this.size(), n);
		records++;
		
	}

	@Override
	public void delete(Nuplet n, int att, Object value) {
		
		Nuplet[] nuplets = this.fullScan();
		if((byte)n.getAtt(att) == (byte)value) {
			for(int i=0;i<nuplets.length;i++) {
				if(nuplets[i].toString().hashCode() == n.toString().hashCode()) {
					for(int j = i ; j<nuplets.length;j++) {
						if(j+1 <= nuplets.length)
							this.f.store(j, this.f.get(j+1));
						else
							this.f.store(j, System.getProperty("line.separator"));
					}
					records--;
				}		
				
				
			}

			
		}

			 



		
		
	}

	@Override
	public void update(Nuplet n, int att, Object oldValue, Object newValue) {
		Nuplet[] nuplets = this.fullScan();
		
		for(int i =0 ;i<nuplets.length ; i++) {
			if((byte)nuplets[i].getAtt(att) == (byte)oldValue) {
						nuplets[i].putAtt(att, (byte)newValue);
						this.f.store(i, nuplets[i]);

			}
		}

		
		

		
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


		private int current = -1 ; 
		
		@Override
		public boolean hasNext() {
		
			return current < TableInt.this.size();
		}

		@Override
		public Nuplet next() {

            return TableInt.this.get(current++);
		}
	
		
		@Override
		public void open() {
			this.current = 0 ;
		}


		
		
	}

}
