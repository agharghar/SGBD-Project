package operateurs;

import stockage.Nuplet;

public interface Projection {

	public Nuplet[] project(Nuplet[] t, int[] atts); // projette les Nuplets sur un sous ensemble d'attributs définis par atts. Par exemple si atts = {1,3,4} on gardera les attributs 1 3 et 4 de l'ensemble des Nuplets.
	public PipeLine pipeLine(Nuplet[] t, int[] atts);
}
