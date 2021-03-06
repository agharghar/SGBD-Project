package stockage;

import operateurs.PipeLine;

public interface Nuplet {

	/**
	 * 
	 * @param i position de l'attribut
	 * @return valeur de l'attribut
	 */
	public Object getAtt(int i); 
	
	public void putAtt(int i, Object o);
	
	public int size();
	
	public String toString();
	public PipeLine pipeLine(); 
	public byte[] getValues();
}
