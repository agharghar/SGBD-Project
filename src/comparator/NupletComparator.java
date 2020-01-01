package comparator;

import java.util.Comparator;


import stockage.Nuplet;

public class NupletComparator implements Comparator<Nuplet>{

	private int attr1 ;

	
	
	public NupletComparator(int attr1) {
		super();
		this.attr1 = attr1;

	}

	@Override
	public int compare(Nuplet nupletInt1 , Nuplet nupletInt2) {
		
		if((byte)nupletInt1.getAtt(attr1) > (byte)nupletInt2.getAtt(attr1)) {
			return 1;
		}else if((byte)nupletInt1.getAtt(attr1) < (byte)nupletInt2.getAtt(attr1)) {
			return -1 ;
		}
		
		
		return 0;
	}



}
