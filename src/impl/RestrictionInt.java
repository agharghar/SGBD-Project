package impl;

import java.util.Vector;

import operateurs.Restriction;
import stockage.Nuplet;

public class RestrictionInt implements Restriction {

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

}
