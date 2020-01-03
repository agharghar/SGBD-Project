package impl;

import operateurs.Avg;
import operateurs.Count;
import operateurs.Max;
import operateurs.Min;
import operateurs.Sum;
import stockage.Nuplet;

public class Agregats {
	
	public void Agregats_req(Nuplet[] nuplets, int att) {
		
		Sum sum = new SumInt();
		Min min = new MinInt();
		Max max = new MaxInt();
		Avg avg = new AvgInt();
		Count count = new CountInt();
		
		System.out.println("SUM =======>"+sum.sum(nuplets, att));
		System.out.println("Min =======>"+min.min(nuplets, att));
		System.out.println("Max =======>"+max.max(nuplets, att));
		System.out.println("Avg =======>"+avg.avg(nuplets, att));
		System.out.println("Count =====>"+count.count(nuplets, att));
		
	}

}
